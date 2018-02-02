package com.jf.projects.zmt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jf.projects.zmt.model.Slaughterhouse;
import com.jf.projects.zmt.service.SlaughterhouseService;
import com.jf.projects.zmt.service.UserService;
import com.jf.projects.zmt.util.ConstantsUtil;
import com.jf.projects.zmt.vo.OptionVo;
import com.jf.projects.zmt.vo.ResponseVO;
import com.jf.projects.zmt.vo.slaughterhouse.SlaughterhouseDetailsVo;
import com.jf.projects.zmt.vo.slaughterhouse.SlaughterhouseListVo;
import com.jf.projects.zmt.vo.slaughterhouse.SlaughterhouseUserDetailsVo;
import com.jf.projects.zmt.vo.slaughterhouse.SlaughterhouseVo;
import com.jf.projects.zmt.vo.user.UserSearch;

/**
 * @className: SlaughterhouseController
 * @description:屠宰场
 * @author yt
 * @date 2017年10月25日下午3:17:39
 */
@Controller
@RequestMapping("/*")
public class SlaughterhouseController {

    @Autowired
    private SlaughterhouseService service;

    @Autowired
    private UserService userService;

    private Long count = 0l;

    /**
     * 分页显示所有屠宰场
     * 
     * @return
     */
    @RequestMapping(value = "/sign/slaughterhouse/find_list_key", method = RequestMethod.POST)
    @ResponseBody
    public ResponseVO getList(UserSearch search) {
        ResponseVO responseVO = new ResponseVO();
        try {
            List<SlaughterhouseListVo> vos = service.findListByKey(search);
            count = service.findListCountByKey(search);
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
     * 屠宰场新增
     * 
     * @param vo
     * @return
     */
    @RequestMapping(value = "/sign/slaughterhouse/add", method = RequestMethod.POST)
    @ResponseBody
    public ResponseVO add(Slaughterhouse vo) {

        boolean flag = service.add(vo);
        ResponseVO responseVO = new ResponseVO();
        responseVO.setCode(flag ? ConstantsUtil.RES_SUCCESS_CODE : ConstantsUtil.RES_FAIL_CODE);
        responseVO.setMessage(flag ? ConstantsUtil.RES_SUCCESS_MESSAGE
                                  : ConstantsUtil.RES_FAIL_MESSAGE);
        return responseVO;
    }

    /**
     * 屠宰场修改
     * 
     * @param vo
     * @return
     */
    @RequestMapping(value = "/sign/slaughterhouse/update", method = RequestMethod.POST)
    @ResponseBody
    public ResponseVO update(Slaughterhouse vo) {

        boolean flag = service.update(vo);
        ResponseVO responseVO = new ResponseVO();
        responseVO.setCode(flag ? ConstantsUtil.RES_SUCCESS_CODE : ConstantsUtil.RES_FAIL_CODE);
        responseVO.setMessage(flag ? ConstantsUtil.RES_SUCCESS_MESSAGE
                                  : ConstantsUtil.RES_FAIL_MESSAGE);
        return responseVO;
    }

    /**
     * 启用禁用
     * 
     * @param vo
     * @return
     */
    @RequestMapping(value = "/sign/slaughterhouse/update_status", method = RequestMethod.POST)
    @ResponseBody
    public ResponseVO updateStatus(@RequestParam(value = "id", required = true) String id,
                                   @RequestParam(value = "status", required = true) String status) {

        boolean flag = service.updateStatus(id, status);
        ResponseVO responseVO = new ResponseVO();
        responseVO.setCode(flag ? ConstantsUtil.RES_SUCCESS_CODE : ConstantsUtil.RES_FAIL_CODE);
        responseVO.setMessage(flag ? ConstantsUtil.RES_SUCCESS_MESSAGE
                                  : ConstantsUtil.RES_FAIL_MESSAGE);
        return responseVO;
    }

    /**
     * 屠宰场详情
     * 
     * @param vo
     * @return
     */
    @RequestMapping(value = "/sign/slaughterhouse/find_details", method = RequestMethod.POST)
    @ResponseBody
    public ResponseVO findDetailsById(@RequestParam(value = "id", required = true) String id) {

        SlaughterhouseDetailsVo vo = service.findDetailsById(id);
        ResponseVO responseVO = new ResponseVO();
        try {
            responseVO.setData(vo);
            responseVO.setCode(ConstantsUtil.RES_SUCCESS_CODE);
            responseVO.setMessage(ConstantsUtil.RES_SUCCESS_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            responseVO.setCode(ConstantsUtil.RES_FAIL_CODE);
            responseVO.setMessage(ConstantsUtil.RES_FAIL_MESSAGE);
        }
        return responseVO;
    }

    /**
     * 获取屠宰场所有用户
     * 
     * @return
     */
    @RequestMapping(value = "/sign/slaughterhouse/find_key", method = RequestMethod.POST)
    @ResponseBody
    public ResponseVO getType(UserSearch search) {
        ResponseVO responseVO = new ResponseVO();
        try {
            List<SlaughterhouseVo> vos = service.findSlaughterHouseUserByKey(search);
            count = userService.findSlaughterHouseUserCountByKey(search);
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
     * 获取屠宰场用户详情
     * 
     * @return
     */
    @RequestMapping(value = "/sign/slaughterhouse/find_user_details", method = RequestMethod.POST)
    @ResponseBody
    public ResponseVO getUserDetails(@RequestParam(value = "id", required = true) String id) {
        ResponseVO responseVO = new ResponseVO();
        try {
            SlaughterhouseUserDetailsVo vo = service.findUserDetailsByKey(id);
            if (vo == null || vo.getSlaughterhouseId() == null) {
                responseVO.setCode("800");
                responseVO.setMessage("该用户未分配屠宰场，不能操作！");
            }
            responseVO.setData(vo);
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
     * 获取屠宰场下拉数据
     * 
     * @return
     */
    @RequestMapping(value = "/sign/slaughterhouse/find_option", method = RequestMethod.POST)
    @ResponseBody
    public ResponseVO findOption() {
        ResponseVO responseVO = new ResponseVO();
        try {
            responseVO.setData(service.findOption());
            responseVO.setCode(ConstantsUtil.RES_SUCCESS_CODE);
            responseVO.setMessage(ConstantsUtil.RES_SUCCESS_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            responseVO.setCode(ConstantsUtil.RES_FAIL_CODE);
            responseVO.setMessage(ConstantsUtil.RES_FAIL_MESSAGE);
        }
        return responseVO;
    }

    /**
     * 获取用户的屠宰场下拉数据
     * 
     * @return
     */
    @RequestMapping(value = "/sign/slaughterhouse/find_user_option", method = RequestMethod.POST)
    @ResponseBody
    public ResponseVO findUserOption(@RequestParam(value = "userId", required = true) String userId) {
        ResponseVO responseVO = new ResponseVO();
        try {
            List<OptionVo> ops = service.findUserOption(userId);
            responseVO.setData(ops);
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
