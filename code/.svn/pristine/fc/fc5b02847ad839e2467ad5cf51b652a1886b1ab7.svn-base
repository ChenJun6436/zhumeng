package com.jf.projects.zmt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jf.projects.zmt.model.Checkout;
import com.jf.projects.zmt.service.CheckoutService;
import com.jf.projects.zmt.service.UserService;
import com.jf.projects.zmt.util.ConstantsUtil;
import com.jf.projects.zmt.vo.ResponseVO;
import com.jf.projects.zmt.vo.checkout.CheckoutDetailsVo;
import com.jf.projects.zmt.vo.checkout.CheckoutVo;
import com.jf.projects.zmt.vo.user.UserSearch;

/**
 * @className: CheckoutController
 * @description:检验中心
 * @author yt
 * @date 2017年10月25日下午3:17:39
 */
@Controller
@RequestMapping("/*")
public class CheckoutController {

    @Autowired
    private CheckoutService checkoutService;

    @Autowired
    private UserService userService;

    private Long count = 0l;

    /**
     * 获取所有用户类型
     * 
     * @return
     */
    @RequestMapping(value = "/sign/checkout/find_key", method = RequestMethod.POST)
    @ResponseBody
    public ResponseVO getType(UserSearch search) {
        ResponseVO responseVO = new ResponseVO();
        try {
            List<CheckoutVo> vos = checkoutService.findUserByKey(search);
            count = userService.findUserCountByKey(search);
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
     * 获取检验中心用户详情
     * 
     * @return
     */
    @RequestMapping(value = "/sign/checkout/find_details", method = RequestMethod.POST)
    @ResponseBody
    public ResponseVO getDetails(@RequestParam(value = "id", required = true) String id) {
        ResponseVO responseVO = new ResponseVO();
        try {
            CheckoutDetailsVo vo = checkoutService.findUserDetailsByKey(id);
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
     * 获取所有用户管理的猪列表
     * 
     * @return
     */
    @RequestMapping(value = "/sign/checkout/find_pigs", method = RequestMethod.POST)
    @ResponseBody
    public ResponseVO findListByPid(@RequestParam(value = "id", required = true) String id,
                                    @RequestParam(value = "pigId", required = false) String pigId,
                                    @RequestParam(value = "start", required = false) Integer start,
                                    @RequestParam(value = "length", required = false) Integer length) {
        ResponseVO responseVO = new ResponseVO();
        try {
            List<Checkout> vos = checkoutService.findListByPid(id, pigId, start, length);
            count = checkoutService.findCountById(id).longValue();
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
     * 新增
     * 
     * @param vo
     * @return
     */
    @RequestMapping(value = "/sign/checkout/add", method = RequestMethod.POST)
    @ResponseBody
    public ResponseVO add(Checkout vo) {

        boolean flag = checkoutService.add(vo);
        ResponseVO responseVO = new ResponseVO();
        responseVO.setCode(flag ? ConstantsUtil.RES_SUCCESS_CODE : ConstantsUtil.RES_FAIL_CODE);
        responseVO.setMessage(flag ? ConstantsUtil.RES_SUCCESS_MESSAGE
                                  : ConstantsUtil.RES_FAIL_MESSAGE);
        return responseVO;
    }

    /**
     * 更新
     * 
     * @param vo
     * @return
     */
    @RequestMapping(value = "/sign/checkout/update", method = RequestMethod.POST)
    @ResponseBody
    public ResponseVO update(Checkout vo) {
        boolean flag = checkoutService.update(vo);
        ResponseVO responseVO = new ResponseVO();
        responseVO.setCode(flag ? ConstantsUtil.RES_SUCCESS_CODE : ConstantsUtil.RES_FAIL_CODE);
        responseVO.setMessage(flag ? ConstantsUtil.RES_SUCCESS_MESSAGE
                                  : ConstantsUtil.RES_FAIL_MESSAGE);
        return responseVO;
    }

}
