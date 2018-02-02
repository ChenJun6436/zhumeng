package com.jf.projects.zmt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jf.projects.zmt.service.AccountService;
import com.jf.projects.zmt.util.ConstantsUtil;
import com.jf.projects.zmt.vo.ResponseVO;
import com.jf.projects.zmt.vo.account.AccountSearchVo;
import com.jf.projects.zmt.vo.account.AddUserInfoVo;
import com.jf.projects.zmt.vo.area.AppUpdateAddressVo;

@Controller
@RequestMapping("account/manage")
public class AccountController {
	
	@Autowired
	private AccountService service;
	
	/**
	 * 根据条件查询列表
	 * @param search
	 * @return
	 */
	@RequestMapping(value = "/find_page",method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody   
    public ResponseVO getDepartmentList(AccountSearchVo search){
            
		return service.findPage(search);
    }
	
	/**
	 * 根据用户id获取用户信息
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/find_info_by_id",method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody   
    public ResponseVO findAccountInfoByUserId(@RequestParam(value = "user_id") String id){
		ResponseVO vo = new ResponseVO();
		try{
			vo.setData(service.findInfoById(id));
			vo.setCode(ConstantsUtil.RES_SUCCESS_CODE);
			vo.setMessage(ConstantsUtil.RES_SUCCESS_MESSAGE);
		}catch (Exception e) {
			e.printStackTrace();
			vo.setCode(ConstantsUtil.RES_FAIL_CODE);
			vo.setMessage(ConstantsUtil.RES_FAIL_MESSAGE);
		}
		return vo;
    }
	
	/**
	 * 根据用户id获取用户管辖区域id及区域类型
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/find_area_by_user",method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody   
    public ResponseVO findUserArea(@RequestParam(value = "user_id") String id){
		ResponseVO vo = new ResponseVO();
		try{
			vo.setData(service.findAreaByUserId(id));
			vo.setCode(ConstantsUtil.RES_SUCCESS_CODE);
			vo.setMessage(ConstantsUtil.RES_SUCCESS_MESSAGE);
		}catch (Exception e) {
			e.printStackTrace();
			vo.setCode(ConstantsUtil.RES_FAIL_CODE);
			vo.setMessage(ConstantsUtil.RES_FAIL_MESSAGE);
		}
		return vo;
    }
	
	/**
	 * 新增
	 * @param addVo
	 * @return
	 */
	@RequestMapping(value = "/add",method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody   
    public ResponseVO add(AddUserInfoVo addVo){
		ResponseVO vo = new ResponseVO();
		
	/*	String REGEX_MOBILE = "^((17[0-9])|(14[0-9])|(13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$";
		boolean falg = Pattern.matches(REGEX_MOBILE, addVo.getTel());
		if(!falg){
			vo.setCode("非法电话号码");
			vo.setMessage(ConstantsUtil.RES_FAIL_MESSAGE);
			return vo;
		}*/
		try{
			String result = service.add(addVo);
			if("0".equals(result)){
				vo.setData(result);
				vo.setCode(ConstantsUtil.RES_FAIL_CODE);
				vo.setMessage("该电话号码系统已存在");
			}else{
				vo.setData(result);
				vo.setCode(ConstantsUtil.RES_SUCCESS_CODE);
				vo.setMessage(ConstantsUtil.RES_SUCCESS_MESSAGE);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
			vo.setCode(ConstantsUtil.RES_FAIL_CODE);
			vo.setMessage(ConstantsUtil.RES_FAIL_MESSAGE);
		}
		return vo;
    }
	/**
	 * 修改
	 * @param addVo
	 * @return
	 */
	@RequestMapping(value = "/update",method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody   
    public ResponseVO update(AddUserInfoVo addVo){
		ResponseVO vo = new ResponseVO();
		try{
			Integer result = service.update(addVo);
			if(result == 1){
				vo.setData(result);
				vo.setCode(ConstantsUtil.RES_SUCCESS_CODE);
				vo.setMessage(ConstantsUtil.RES_SUCCESS_MESSAGE);
			}else{
				vo.setData(result);
				vo.setCode(ConstantsUtil.RES_FAIL_CODE);
				vo.setMessage("该电话号码系统已存在");
			}
			
			
		}catch (Exception e) {
			e.printStackTrace();
			vo.setCode(ConstantsUtil.RES_FAIL_CODE);
			vo.setMessage(ConstantsUtil.RES_FAIL_MESSAGE);
		}
		return vo;
    }
	
	/**
	 * 修改状态
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "/update_status",method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody   
    public ResponseVO updateStatus(@RequestParam(value = "user_id")String userId){
		ResponseVO vo = new ResponseVO();
		try{
			vo.setData(service.updateStatus(userId));
			vo.setCode(ConstantsUtil.RES_SUCCESS_CODE);
			vo.setMessage(ConstantsUtil.RES_SUCCESS_MESSAGE);
		}catch (Exception e) {
			e.printStackTrace();
			vo.setCode(ConstantsUtil.RES_FAIL_CODE);
			vo.setMessage(ConstantsUtil.RES_FAIL_MESSAGE);
		}
		return vo;
    }
	
	/**
	 * 删除用户
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "/delete",method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody   
    public ResponseVO delete(@RequestParam(value = "user_id")String userId){
		ResponseVO vo = new ResponseVO();
		try{
			String str = service.delete(userId);
			if("ok".equals(str)){
				vo.setCode(ConstantsUtil.RES_SUCCESS_CODE);
				vo.setMessage(ConstantsUtil.RES_SUCCESS_MESSAGE);
			}else{
				vo.setCode(ConstantsUtil.RES_FAIL_CODE);
				vo.setMessage(str);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
			vo.setCode(ConstantsUtil.RES_FAIL_CODE);
			vo.setMessage(ConstantsUtil.RES_FAIL_MESSAGE);
		}
		return vo;
    }
	
	/**
	 * 重置密码
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "/rest_pwd",method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody   
    public ResponseVO restPwd(@RequestParam(value = "user_id")String userId){
		ResponseVO vo = new ResponseVO();
		try{
			String str = service.restPwd(userId);
			if(str != null){
				vo.setCode(ConstantsUtil.RES_FAIL_CODE);
				vo.setMessage(str);
				return vo;
			}
			vo.setCode(ConstantsUtil.RES_SUCCESS_CODE);
			vo.setMessage(ConstantsUtil.RES_SUCCESS_MESSAGE);
		}catch (Exception e) {
			e.printStackTrace();
			vo.setCode(ConstantsUtil.RES_FAIL_CODE);
			vo.setMessage(ConstantsUtil.RES_FAIL_MESSAGE);
		}
		return vo;
    }
	
	/**
	 * 根据用户id判断该用户是否被禁用或被删除
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "/verify_by_id",method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody   
    public ResponseVO verifyUserById(@RequestParam(value = "user_id")String userId){
		ResponseVO vo = new ResponseVO();
		try{
			String str = service.verifyUserById(userId);
			if("ok".equals(str)){
				vo.setData(true);
				vo.setCode(ConstantsUtil.RES_SUCCESS_CODE);
				vo.setMessage(ConstantsUtil.RES_SUCCESS_MESSAGE);
				return vo;
			}else{
				vo.setData(false);
				vo.setCode(ConstantsUtil.RES_LAWYER_FROZEN_ACCOUNT_CODE);
				vo.setMessage(str);
				return vo;
			}
			
		}catch (Exception e) {
			e.printStackTrace();
			vo.setData(false);
			vo.setCode(ConstantsUtil.RES_FAIL_CODE);
			vo.setMessage(ConstantsUtil.RES_FAIL_MESSAGE);
		}
		return vo;
    }
	
	/**
	 * App端修改用户地址
	 * @param vo
	 * @return
	 */
	@RequestMapping(value = "/app_update_address",method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody   
    public ResponseVO AppUpdateAddress(AppUpdateAddressVo vo){
		ResponseVO response = new ResponseVO();
		if(StringUtils.isEmpty(vo.getUserId())){//用户id为必传项
			response.setCode(ConstantsUtil.RES_FAIL_CODE);
			response.setMessage(ConstantsUtil.RES_FAIL_MESSAGE);
			return response;
		}
		Integer falg = service.AppUpdateAddress(vo);
		if(falg == 0){
			response.setData(false);
			response.setCode(ConstantsUtil.RES_FAIL_CODE);
			response.setMessage("用户不存在");
		}else{
			response.setData(true);
			response.setCode(ConstantsUtil.RES_SUCCESS_CODE);
			response.setMessage(ConstantsUtil.RES_SUCCESS_MESSAGE);
		}
		
		return response;
	}
	
}
