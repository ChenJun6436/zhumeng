package com.jf.projects.zmt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jf.projects.zmt.service.AreaService;
import com.jf.projects.zmt.util.ConstantsUtil;
import com.jf.projects.zmt.vo.ResponseVO;

/**
 * 区域
 * @author dqh
 *
 */
@Controller
@RequestMapping("/area")
public class AreaController {
	
	@Autowired
	private AreaService service;
	
	/**
	 * 获取所有省份下拉数据
	 * @return
	 */
	@RequestMapping(value = "/find_province_option",method = RequestMethod.POST)
	@ResponseBody	
	public ResponseVO findProvinceOption(){
		ResponseVO vo = new ResponseVO();
		vo.setData(service.findProvinceOption());
		vo.setCode(ConstantsUtil.RES_SUCCESS_CODE);
		vo.setMessage(ConstantsUtil.RES_SUCCESS_MESSAGE);
		return vo; 
	}
	
	/**
	 * 根据省份id获取市
	 * @param provId
	 * @return
	 */
	@RequestMapping(value = "/find_city_option",method = RequestMethod.POST)
	@ResponseBody	
	public ResponseVO findCityOption(@RequestParam(value = "province_id")Integer provId){
		ResponseVO vo = new ResponseVO();
		vo.setData(service.findCityOption(provId));
		vo.setCode(ConstantsUtil.RES_SUCCESS_CODE);
		vo.setMessage(ConstantsUtil.RES_SUCCESS_MESSAGE);
		return vo; 
	}
	
	/**
	 * 根据市id获取区县
	 * @param cityId
	 * @return
	 */
	@RequestMapping(value = "/find_district_option",method = RequestMethod.POST)
	@ResponseBody	
	public ResponseVO findDistrictOption(@RequestParam(value = "city_id")Integer cityId){
		ResponseVO vo = new ResponseVO();
		vo.setData(service.findDistrictOption(cityId));
		vo.setCode(ConstantsUtil.RES_SUCCESS_CODE);
		vo.setMessage(ConstantsUtil.RES_SUCCESS_MESSAGE);
		return vo; 
	}
	
	/**
	 * 获取树行数据
	 * @param id 区域id
	 * @param type 层级
	 * @param user_id 当前登录用户id
	 * @return
	 */
	@RequestMapping(value = "/find_ztree",method = RequestMethod.POST)
	@ResponseBody	
	public ResponseVO findZtree(@RequestParam(value = "id",required = false)Integer id,
								@RequestParam(value = "type",required = false)Integer type,
								@RequestParam(value = "user_id",required = false)String userId){
		ResponseVO vo = new ResponseVO();
		vo.setData(service.findTree(id, type, userId));
		vo.setCode(ConstantsUtil.RES_SUCCESS_CODE);
		vo.setMessage(ConstantsUtil.RES_SUCCESS_MESSAGE);
		return vo; 
	}

}
