package com.jf.projects.zmt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jf.projects.zmt.model.AndMarketUser;
import com.jf.projects.zmt.model.Market;
import com.jf.projects.zmt.model.PigFile;
import com.jf.projects.zmt.service.AndMarketUserService;
import com.jf.projects.zmt.service.PigFileService;
import com.jf.projects.zmt.service.UserService;
import com.jf.projects.zmt.util.ConstantsUtil;
import com.jf.projects.zmt.vo.BaseParam;
import com.jf.projects.zmt.vo.OptionVo;
import com.jf.projects.zmt.vo.ResponseVO;
import com.jf.projects.zmt.vo.market.MarketPigVo;

/**
 * @className: AndMarketUserController
 * @description:屠宰场
 * @author yt
 * @date 2017年10月25日下午3:17:39
 */
@Controller
@RequestMapping("/*")
public class AndMarketUserController {

    @Autowired
    private AndMarketUserService service;

    @Autowired
    private UserService userService;

    @Autowired
    private PigFileService pigFileService;

    private Long count = 0l;

    /**
     * 用户市场关联建立
     * 
     * @param vo
     * @return
     */
    @RequestMapping(value = "/sign/and_market_user/add_user_market", method = RequestMethod.POST)
    @ResponseBody
    public ResponseVO addUserMarket(AndMarketUser vo) {

        boolean flag = service.addUserMarket(vo);
        ResponseVO responseVO = new ResponseVO();
        responseVO.setCode(flag ? ConstantsUtil.RES_SUCCESS_CODE : ConstantsUtil.RES_FAIL_CODE);
        responseVO.setMessage(flag ? ConstantsUtil.RES_SUCCESS_MESSAGE
                                  : ConstantsUtil.RES_FAIL_MESSAGE);
        return responseVO;
    }

    /**
     * 生猪是否存在
     * 
     * @param vo
     * @return
     */
    @RequestMapping(value = "/sign/and_market_user/exist", method = RequestMethod.POST)
    @ResponseBody
    public ResponseVO existPigId(@RequestParam(value = "pigId", required = true) String pigId,
                                 @RequestParam(value = "userId", required = false) String userId) {

        boolean flag = service.existPigId(pigId);
        ResponseVO responseVO = new ResponseVO();
        if (pigFileService.existPigId(pigId)) {
            responseVO.setCode("800");
            responseVO.setMessage("猪ID不存在！");
            return responseVO;
        }
        responseVO.setCode(flag ? "800" : "0");
        responseVO.setMessage(flag ? "该猪已被本市场或其他市场录入，不能重复录入;" : "");
        PigFile pigFile = pigFileService.findPigfileBySign(pigId);
        if (flag) {
            return responseVO;
        }
        if (pigFile != null) {
            // 生猪状态0正常 1死亡 2待屠宰录入 3待屠宰 4宰后待检验 5待销售 6已处理 7已销售
            Integer pigStatus = pigFile.getPigStatus();
            if (pigStatus == null || pigStatus != 5) {
                responseVO.setCode("800");
                responseVO.setMessage("猪ID非待销售状态，不能销售录入！");
                return responseVO;
            }
        }
        if (userId != null) {
            Market market = service.getMaketByUser(userId);
            responseVO.setData(market);
        }
        return responseVO;
    }

    /**
     * @param vo
     * @return
     */
    @RequestMapping(value = "/sign/and_market_user/add", method = RequestMethod.POST)
    @ResponseBody
    public ResponseVO add(AndMarketUser vo) {

        if (vo.getMarketId() == null && vo.getUserId() != null) {
            List<OptionVo> ops = service.findUserOption(vo.getUserId());
            if (ops != null && ops.size() > 0) {
                vo.setMarketId(ops.get(0).getKey());
            }
        }
        ResponseVO responseVO = new ResponseVO();
        if (pigFileService.existPigId(vo.getPigId())) {
            responseVO.setCode("800");
            responseVO.setMessage("猪ID不存在！");
            return responseVO;
        }
        PigFile pigFile = pigFileService.findPigfileBySign(vo.getPigId());
        if (pigFile != null) {
            // 生猪状态0正常 1死亡 2待屠宰录入 3待屠宰 4宰后待检验 5待销售 6已处理 7已销售
            Integer pigStatus = pigFile.getPigStatus();
            if (pigStatus == null || pigStatus != 5) {
                responseVO.setCode("800");
                responseVO.setMessage("猪ID非待销售状态，不能销售录入！");
                return responseVO;
            }
        }
        boolean flag = service.add(vo);

        responseVO.setCode(flag ? ConstantsUtil.RES_SUCCESS_CODE : ConstantsUtil.RES_FAIL_CODE);
        responseVO.setMessage(flag ? ConstantsUtil.RES_SUCCESS_MESSAGE
                                  : ConstantsUtil.RES_FAIL_MESSAGE);
        return responseVO;
    }

    /**
     * 分页显示猪列表
     * 
     * @return
     */
    @RequestMapping(value = "/sign/and_market_user/find_pig_list", method = RequestMethod.POST)
    @ResponseBody
    public ResponseVO getList(BaseParam param) {
        ResponseVO responseVO = new ResponseVO();
        try {
            List<MarketPigVo> vos = service.findListByPid(param);

            count = service.findListCountByPid(param);
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
     * 不分页显示猪列表
     * 
     * @return
     */
    @RequestMapping(value = "/sign/and_market_user/find_list", method = RequestMethod.POST)
    @ResponseBody
    public ResponseVO getLists(BaseParam param) {
        ResponseVO responseVO = new ResponseVO();
        try {
            List<MarketPigVo> vos = service.findList(param);

            responseVO = new ResponseVO();
            responseVO.setData(vos);
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
     * 查询市场下的人员
     * 下拉列表用
     * 
     * @param vo
     * @return
     */
    @RequestMapping(value = "/sign/and_market_user/get_maket_persons", method = RequestMethod.POST)
    @ResponseBody
    public ResponseVO getMaketPersons(@RequestParam(value = "marketId", required = true) String marketId) {
        ResponseVO responseVO = new ResponseVO();
        try {
            List<OptionVo> vos = service.getMaketPersons(marketId);
            responseVO.setData(vos);
            responseVO.setCode(ConstantsUtil.RES_SUCCESS_CODE);
            responseVO.setMessage(ConstantsUtil.RES_SUCCESS_MESSAGE);

        } catch (Exception e) {
            e.printStackTrace();
            responseVO.setCode(ConstantsUtil.RES_FAIL_CODE);
            responseVO.setMessage(ConstantsUtil.RES_FAIL_MESSAGE);

        }
        return responseVO;
    }
}
