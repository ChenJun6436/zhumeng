package com.jf.projects.zmt.controller;

import java.io.IOException;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jf.projects.zmt.service.UserService;
import com.jf.projects.zmt.util.ConstantsUtil;
import com.jf.projects.zmt.vo.ResponseVO;


/**
 * 
 * @ClassName: UserController
 *
 * @Description:用户基础操作
 *
 * @author wj
 *
 * @date 2018年1月9日
 *
 */
@Controller
@RequestMapping("/*")
public class UserController {
	
	@Autowired
	private UserService  userService;
	
	/**
	 * 用户登录
	 * @param account
	 * @param password
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	@RequestMapping(value = "/user/login",method = RequestMethod.POST)
	@ResponseBody	
	public ResponseVO loginUser(@RequestParam(value = "account", required = true) String account,   
                                @RequestParam(value = "password", required = true) String password)
	                                       throws ServletException, IOException { 
	        return userService.loginUser(account,password);
	}
	
	
	/**
	 * 
	 * @Title: getArea
	 * @Description: 获取地址
	 * @param @return    
	 * @return ResponseVO    
	 * @throws
	 */
	@RequestMapping(value = "/user/getArea",method = RequestMethod.POST)
	@ResponseBody	
	public ResponseVO getArea(@RequestParam(required = false)  Integer type){//type=1获取市级数据
		ResponseVO responseVO = new ResponseVO();
		try {
			responseVO.setCode(ConstantsUtil.RES_SUCCESS_CODE);
			responseVO.setMessage(ConstantsUtil.RES_SUCCESS_MESSAGE);
			responseVO.setData(userService.findArea(type));
			return responseVO;
		} catch (Exception e) {
			e.printStackTrace();
			responseVO.setCode(ConstantsUtil.RES_FAIL_CODE);
			responseVO.setMessage(ConstantsUtil.RES_FAIL_MESSAGE);
			return responseVO;		
		}
	}
	       
}
