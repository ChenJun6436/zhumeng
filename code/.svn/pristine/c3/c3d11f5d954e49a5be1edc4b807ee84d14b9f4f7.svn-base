package com.jf.projects.zmt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jf.projects.zmt.service.UserService;
import com.jf.projects.zmt.util.ConstantsUtil;
import com.jf.projects.zmt.vo.ResponseVO;
import com.jf.projects.zmt.vo.user.UserSearch;

/**
 * 
 * @className: UserController
 *
 * @description:账号
 *
 * @author wj
 *
 * @date 2017年11月1日下午2:09:37
 *
 */
@Controller
@RequestMapping("/*")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 获取所有用户类型
     * 
     * @return
     */
    @RequestMapping(value = "/sign/user/find_key", method = RequestMethod.POST)
    @ResponseBody
    public ResponseVO getType(UserSearch search) {
        ResponseVO responseVO = new ResponseVO();
        try {
            responseVO.setCode(ConstantsUtil.RES_SUCCESS_CODE);
            responseVO.setMessage(ConstantsUtil.RES_SUCCESS_MESSAGE);
            responseVO.setData(userService.findUserByKey(search));
            return responseVO;
        } catch (Exception e) {
            e.printStackTrace();
            responseVO.setCode(ConstantsUtil.RES_FAIL_CODE);
            responseVO.setMessage(ConstantsUtil.RES_FAIL_MESSAGE);
            return responseVO;
        }
    }

}
