package com.jf.projects.zmt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jf.projects.zmt.model.AndCheckoutPig;
import com.jf.projects.zmt.model.PigFile;
import com.jf.projects.zmt.service.CheckoutPigService;
import com.jf.projects.zmt.service.PigFileService;
import com.jf.projects.zmt.service.UserService;
import com.jf.projects.zmt.util.ConstantsUtil;
import com.jf.projects.zmt.vo.BaseParam;
import com.jf.projects.zmt.vo.OptionVo;
import com.jf.projects.zmt.vo.ResponseVO;
import com.jf.projects.zmt.vo.checkout.CheckoutPigsVo;
import com.jf.projects.zmt.vo.checkout.CheckoutPigtVo;
import com.jf.projects.zmt.vo.checkout.PidDetailsVo;

/**
 * @className: CheckoutController
 * @description:检验中心
 * @author yt
 * @date 2017年10月25日下午3:17:39
 */
@Controller
@RequestMapping("/*")
public class CheckoutPigController {

    @Autowired
    private CheckoutPigService checkoutPigService;

    @Autowired
    private UserService userService;

    private Long count = 0l;

    @Autowired
    private PigFileService pigFileService;

    /**
     * 获取所有用户管理的猪列表
     * 
     * @return
     */
    @RequestMapping(value = "check_pig/find_pigs", method = RequestMethod.POST)
    @ResponseBody
    public ResponseVO getList(BaseParam param) {
        ResponseVO responseVO = new ResponseVO();
        try {
            List<CheckoutPigsVo> vos = checkoutPigService.findListByPid(param);

            count = checkoutPigService.findListCountByPid(param);
            responseVO = new ResponseVO(count, count, vos);
            responseVO.setCode(ConstantsUtil.RES_SUCCESS_CODE);
            responseVO.setMessage(ConstantsUtil.RES_SUCCESS_MESSAGE);

            return responseVO;
        } catch (Exception e) {
            e.printStackTrace();
            responseVO.setCode(ConstantsUtil.RES_FAIL_CODE);
            responseVO.setMessage(ConstantsUtil.RES_FAIL_MESSAGE);
            return responseVO;
        }
    }

    /**
     * 根据猪id获取猪信息
     * 
     * @param id
     * @return
     */
    @RequestMapping(value = "check_pig/find_pig_details", method = { RequestMethod.POST,
                                                                    RequestMethod.GET })
    @ResponseBody
    public ResponseVO findPidDetails(@RequestParam(value = "pigId") String pigId) {
        ResponseVO rvo = new ResponseVO();
        try {
            PidDetailsVo vo = checkoutPigService.findPidDetails(pigId);
            rvo.setData(vo);
            rvo.setCode(ConstantsUtil.RES_SUCCESS_CODE);
            rvo.setMessage(ConstantsUtil.RES_SUCCESS_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            rvo.setCode(ConstantsUtil.RES_FAIL_CODE);
            rvo.setMessage(ConstantsUtil.RES_FAIL_MESSAGE);
        }
        return rvo;
    }

    /**
     * 根据猪id获取猪信息
     * 
     * @param id
     * @return
     */
    @RequestMapping(value = "check_pig/find_info_by_pig_id", method = { RequestMethod.POST,
                                                                       RequestMethod.GET })
    @ResponseBody
    public ResponseVO findInfoByPigId(@RequestParam(value = "pigId") String pigId) {
        ResponseVO rvo = new ResponseVO();
        PigFile pigFile = pigFileService.findPigfileBySign(pigId);
        if (pigFileService.existPigId(pigId)) {
            rvo.setCode("800");
            rvo.setMessage("猪ID不存在！");
            return rvo;
        }
        if (pigFile != null) {
            // 生猪状态0正常 1死亡 2待屠宰录入 3待屠宰 4宰后待检验 5待销售 6已处理 7已销售
            Integer pigStatus = pigFile.getPigStatus();
            String pigStatusStr = null;
            switch (pigStatus) {
            case 1:
                pigStatusStr = "死亡";
                break;
            case 3:
                pigStatusStr = "待屠宰";
                break;
            case 5:
                pigStatusStr = "待销售";
                break;
            case 6:
                pigStatusStr = "已处理";
                break;
            case 7:
                pigStatusStr = "已销售";
                break;
            }
            if (pigStatusStr != null) {
                rvo.setCode("800");
                rvo.setMessage("猪ID为" + pigStatusStr + "状态，不能进行检验！");
                return rvo;
            }
        }
        try {
            CheckoutPigtVo vo = checkoutPigService.findInfoByPigId(pigId);
            rvo.setData(vo);
            rvo.setCode(ConstantsUtil.RES_SUCCESS_CODE);
            rvo.setMessage(ConstantsUtil.RES_SUCCESS_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            rvo.setCode(ConstantsUtil.RES_FAIL_CODE);
            rvo.setMessage(ConstantsUtil.RES_FAIL_MESSAGE);
        }
        return rvo;
    }

    /**
     * 新增
     * 
     * @param vo
     * @return
     */
    @RequestMapping(value = "/check_pig/add", method = RequestMethod.POST)
    @ResponseBody
    public ResponseVO add(AndCheckoutPig vo) {
        ResponseVO responseVO = new ResponseVO();
        if (pigFileService.existPigId(vo.getPigId())) {
            responseVO.setCode("800");
            responseVO.setMessage("猪ID不存在！");
            return responseVO;
        }
        if (vo.getType() != null) {
            PigFile pigFile = pigFileService.findPigfileBySign(vo.getPigId());
            if (pigFile != null) {
                Integer pigStatus = pigFile.getPigStatus();
                if (vo.getType() == 1) {
                    if (pigStatus > 3 || pigStatus == 1) {
                        responseVO.setCode("800");
                        responseVO.setMessage("猪ID已经死亡或销售！不能进行疫苗！");
                        return responseVO;
                    }
                }
                if (vo.getType() != 1) {
                    // 1常规检查2宰前检查3宰后检查
                    Integer checkType = vo.getCheckType();
                    // 生猪状态0正常 1死亡 2待屠宰录入 3待屠宰 4宰后待检验 5待销售 6已处理 7已销售

                    if (checkType == 1) {
                        if (pigStatus > 3 || pigStatus == 1) {
                            responseVO.setCode("800");
                            responseVO.setMessage("猪ID已经死亡！不能进行常规检验！");
                            return responseVO;
                        }
                    }
                    if (checkType == 2 && pigStatus != 2) {
                        responseVO.setCode("800");
                        // responseVO.setMessage("猪ID非正常状态，不能进行宰前检验！");
                        responseVO.setMessage("猪ID非宰前待检验状态，不能进行宰前检验！");
                        return responseVO;
                    }
                    if (checkType == 3 && pigStatus != 4) {
                        responseVO.setCode("800");
                        responseVO.setMessage("猪ID非 宰后待检验 状态，不能进行宰后检查！");
                        return responseVO;
                    }
                }
            }
        }
        boolean flag = checkoutPigService.add(vo);
        responseVO.setCode(flag ? ConstantsUtil.RES_SUCCESS_CODE : ConstantsUtil.RES_FAIL_CODE);
        responseVO.setMessage(flag ? ConstantsUtil.RES_SUCCESS_MESSAGE
                                  : ConstantsUtil.RES_FAIL_MESSAGE);
        return responseVO;
    }

    /**
     * 新增
     * 
     * @param vo
     * @return
     */
    @RequestMapping(value = "/check_pig/get_users", method = RequestMethod.GET)
    @ResponseBody
    public ResponseVO getUsers() {

        ResponseVO responseVO = new ResponseVO();
        List<OptionVo> users = checkoutPigService.getUsers();
        responseVO.setData(users);
        responseVO.setCode(ConstantsUtil.RES_SUCCESS_CODE);
        responseVO.setMessage(ConstantsUtil.RES_SUCCESS_MESSAGE);
        return responseVO;
    }
}
