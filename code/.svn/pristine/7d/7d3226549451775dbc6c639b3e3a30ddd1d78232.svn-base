package com.jf.projects.zmt.controller;


import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jf.projects.zmt.dao.AndSlaughterhouseUserMapper;
import com.jf.projects.zmt.model.LButcherCount;
import com.jf.projects.zmt.service.ButcherCountService;
import com.jf.projects.zmt.util.ConstantsUtil;
import com.jf.projects.zmt.vo.ResponseVO;

@Controller
@RequestMapping("/butcher")
public class ButcherCountController {
	
	@Autowired
	private ButcherCountService service;
	
	@Autowired
	private AndSlaughterhouseUserMapper andSlMapper;
	
	/**
	 * 屠宰场新增一条数据,每天只能存在一条  
	 * @param userId 屠宰场人员id 不能为空
	 * @param number 屠宰数量 不能为空
	 * @return
	 */
	@RequestMapping(value = "/add_by_uid",method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody 
	public ResponseVO addByUser(@RequestParam(value = "user_id") String userId,
						  @RequestParam(value = "number") Integer number) {
		ResponseVO vo = new ResponseVO();
		if(StringUtils.isBlank(userId)){
			return new ResponseVO(ConstantsUtil.RES_PARAMER_FAIL_CODE, "user_id 不能为空");
		}
		if(number == null){
			return new ResponseVO(ConstantsUtil.RES_PARAMER_FAIL_CODE, "number 不能为空");
		}
		//根据用户id获取屠宰场id
		String slaughterhouseId = andSlMapper.getSlaughterhouseIdByUserId(userId);
		if(StringUtils.isEmpty(slaughterhouseId)){
			return new ResponseVO(ConstantsUtil.RES_PARAMER_FAIL_CODE, "此用户不是屠宰场人员");
		}
		
		LButcherCount bean = new LButcherCount();
		bean.setSlaughterhouseId(slaughterhouseId);
		bean.setNumber(number);
		try{
			service.add(bean);
		}catch (Exception e) {
			vo.setCode(ConstantsUtil.RES_FAIL_CODE);
			vo.setMessage(ConstantsUtil.RES_FAIL_MESSAGE);
			return vo;
		}
		vo.setCode(ConstantsUtil.RES_SUCCESS_CODE);
		vo.setMessage(ConstantsUtil.RES_SUCCESS_MESSAGE);
		return vo;
	}
	
	/**
	 * 屠宰场新增一条数据,每天只能存在一条  
	 * @param slaughterhouseId 屠宰场id 不能为空
	 * @param number 屠宰数量 不能为空
	 * @return
	 */
	@RequestMapping(value = "/add",method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody 
	public ResponseVO add(@RequestParam(value = "slaughterhouse_id") String slaughterhouseId,
						  @RequestParam(value = "number") Integer number) {
		ResponseVO vo = new ResponseVO();
		if(StringUtils.isBlank(slaughterhouseId)){
			return new ResponseVO(ConstantsUtil.RES_PARAMER_FAIL_CODE, "slaughterhouseId 不能为空");
		}
		if(number == null){
			return new ResponseVO(ConstantsUtil.RES_PARAMER_FAIL_CODE, "number 不能为空");
		}
		LButcherCount bean = new LButcherCount();
		bean.setSlaughterhouseId(slaughterhouseId);
		bean.setNumber(number);
		try{
			service.add(bean);
		}catch (Exception e) {
			vo.setCode(ConstantsUtil.RES_FAIL_CODE);
			vo.setMessage(ConstantsUtil.RES_FAIL_MESSAGE);
			return vo;
		}
		vo.setCode(ConstantsUtil.RES_SUCCESS_CODE);
		vo.setMessage(ConstantsUtil.RES_SUCCESS_MESSAGE);
		return vo;
	}

}
