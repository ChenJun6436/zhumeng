package com.jf.projects.zmt.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jf.projects.zmt.service.HomePageService;
import com.jf.projects.zmt.util.ConstantsUtil;
import com.jf.projects.zmt.vo.RequestPageParam;
import com.jf.projects.zmt.vo.ResponseVO;
import com.jf.projects.zmt.vo.home.HomeSearchVo;

@Controller
@RequestMapping("home/page")
public class HomePageController {

	@Autowired
	private HomePageService service;
	
	/**
	 * 实时数据统计
	 * @param search
	 * @return
	 */
	@RequestMapping(value = "/real_count",method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody   
    public ResponseVO getTodayReal(@RequestParam(value = "id",required = false) Integer areaId,
    									@RequestParam(value = "type",required = false) Integer type){
		ResponseVO vo = new ResponseVO();
		vo.setData(service.getTodayReal(areaId, type));
		vo.setCode(ConstantsUtil.RES_SUCCESS_CODE);
		vo.setMessage(ConstantsUtil.RES_SUCCESS_MESSAGE);
		return vo;
    }
	
	/**
	 * 统计图表数据
	 * @param search
	 * @return
	 */
	@RequestMapping(value = "/get_pic_value",method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody   
    public ResponseVO getPicValue(@RequestParam(value = "id",required = false) Integer areaId,
    									@RequestParam(value = "type",required = false) Integer type){
		ResponseVO vo = new ResponseVO();
		vo.setData(service.getPic(areaId, type));
		vo.setCode(ConstantsUtil.RES_SUCCESS_CODE);
		vo.setMessage(ConstantsUtil.RES_SUCCESS_MESSAGE);
		return vo;
    }
	
	/**
	 * 根据条件分页查询
	 * @param vo
	 * @return
	 */
	@RequestMapping(value = "/find_page",method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody   
    public ResponseVO getPigByFiled(HomeSearchVo vo){
		
		return service.getPigByFiled(vo);
    }
	
	/**
	 * 根据生猪id查看流程
	 * @param pigId
	 * @return
	 */
	@RequestMapping(value = "/find_by_id",method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody   
    public ResponseVO findFlowByPigId(@RequestParam(value = "pig_id",required = false)String pigId,
    		RequestPageParam pageParam){
		ResponseVO res = new ResponseVO();
		
		res = service.findFlowByPigId(pigId,pageParam);
		res.setCode(ConstantsUtil.RES_SUCCESS_CODE);
		res.setMessage(ConstantsUtil.RES_SUCCESS_MESSAGE);
		return res;
    }
	
	/**
	 * 根据生猪id获取所有流程  APP端调用
	 * @param pigId
	 * @return
	 */
	@RequestMapping(value = "/find_all_by_id",method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody   
    public ResponseVO findAllByPigId(@RequestParam(value = "pig_id",required = false)String pigId){
		ResponseVO res = new ResponseVO();
		
		res.setData(service.findAllByPigId(pigId));
		res.setCode(ConstantsUtil.RES_SUCCESS_CODE);
		res.setMessage(ConstantsUtil.RES_SUCCESS_MESSAGE);
		return res;
    }
	
}
