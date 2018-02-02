package com.jf.projects.zmt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jf.projects.zmt.model.EntryArea;
import com.jf.projects.zmt.service.EntryAreaService;
import com.jf.projects.zmt.util.ConstantsUtil;
import com.jf.projects.zmt.vo.ResponseVO;
import com.jf.projects.zmt.vo.area.EntryAreaSearch;
import com.jf.projects.zmt.vo.area.EntryAreaUpdateVo;

/**
 * 乡镇
 * @author dqh
 *
 */
@Controller
@RequestMapping("/entry_area")
public class EntryAreaController {

	@Autowired
	private EntryAreaService service;
	
	/**
	 * 根据省市区镇id获取村
	 * @param search
	 * @return
	 */
	@RequestMapping(value = "/find_page",method = RequestMethod.POST)
	@ResponseBody	
	public ResponseVO getType(EntryAreaSearch search){
		return service.findPage(search);
	}
	
	/**
	 * 新增乡镇
	 * @param entryArea
	 * @return
	 */
	@RequestMapping(value = "/add",method = RequestMethod.POST)
	@ResponseBody	
	public ResponseVO add(EntryArea entryArea){
		return service.add(entryArea);		
	}
	
	/**
	 * 修改
	 * @param vo
	 * @return
	 */
	@RequestMapping(value = "/update",method = RequestMethod.POST)
	@ResponseBody	
	public ResponseVO update(EntryAreaUpdateVo vo){
		return service.update(vo);
	}
	
	/**
	 * 修改状态
	 * @param village_id 乡村id
	 * @return
	 */
	@RequestMapping(value = "/update_status",method = RequestMethod.POST)
	@ResponseBody	
	public ResponseVO updateStatus(@RequestParam(value = "village_id") Integer villageId){
		ResponseVO responseVO = new ResponseVO();
		try {
			Integer num = service.updateStatus(villageId);
			if(num == 2){
				responseVO.setData(num);
				responseVO.setCode(ConstantsUtil.RES_ILLEGAL_CODE);
				responseVO.setMessage("已有用户使用的地址不可禁用");
				return responseVO;
			}
			responseVO.setData(num);
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
	 * 修改状态
	 * @param village_id 乡村id
	 * @return
	 */
	@RequestMapping(value = "/delete",method = RequestMethod.POST)
	@ResponseBody	
	public ResponseVO delete(@RequestParam(value = "village_id") Integer villageId){
		ResponseVO responseVO = new ResponseVO();
		try {
			Integer num = service.delete(villageId);
			if(num == 2){
				responseVO.setData(num);
				responseVO.setCode(ConstantsUtil.RES_ILLEGAL_CODE);
				responseVO.setMessage("已有用户使用的地址不可删除");
				return responseVO;
			}
			responseVO.setData(num);
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
	 * 根据区县id获取镇的下拉数据
	 * @param districtId
	 * @return
	 */
	@RequestMapping(value = "/find_town_option",method = RequestMethod.POST)
	@ResponseBody	
	public ResponseVO findTownOption(@RequestParam(value = "district_id") Integer districtId){
		ResponseVO responseVO = new ResponseVO();
		try {
			responseVO.setData(service.getTownOption(districtId));
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
	 * 根据乡镇id获取村的下拉数据
	 * @param districtId
	 * @return
	 */
	@RequestMapping(value = "/find_village_option",method = RequestMethod.POST)
	@ResponseBody	
	public ResponseVO getVillageOption(@RequestParam(value = "town_id") Integer townId){
		ResponseVO responseVO = new ResponseVO();
		try {
			responseVO.setData(service.getVillageOption(townId));
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
}
