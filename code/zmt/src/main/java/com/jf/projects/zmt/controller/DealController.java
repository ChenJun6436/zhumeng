package com.jf.projects.zmt.controller;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jf.projects.zmt.dao.AndSlaughterhouseUserMapper;
import com.jf.projects.zmt.service.SupplierServcie;
import com.jf.projects.zmt.service.WholesalerService;
import com.jf.projects.zmt.util.ConstantsUtil;
import com.jf.projects.zmt.vo.ResponseVO;
import com.jf.projects.zmt.vo.deal.SupplierVo;
import com.jf.projects.zmt.vo.deal.WholesalerVo;

/**
 * 出入库
 * 出库：肉贩子
 * 入库：猪贩子
 * @author dqh
 *
 */
@Controller
@RequestMapping("/deal")
public class DealController {
	
	@Autowired
	private SupplierServcie supplierService;//入库
	
	@Autowired
	private WholesalerService wholesalerService;//出库
	
	@Autowired
	private AndSlaughterhouseUserMapper andSlUser;//用户屠宰场关系表
	
	/**
	 * 新增入库信息
	 * @param vo
	 * @return
	 */
	@ResponseBody 
	@RequestMapping(value = "/supplier/add",method = {RequestMethod.POST,RequestMethod.GET})
	public ResponseVO add(SupplierVo vo){
		ResponseVO response = new ResponseVO();
		
		if(StringUtils.isEmpty(vo.getSlaughterId())){//如果屠宰场id为空
			if(StringUtils.isEmpty(vo.getUserId())){
				response.setCode(ConstantsUtil.RES_PARAMER_FAIL_CODE);
				response.setMessage(ConstantsUtil.RES_PARAMER_FAIL_MESSAGE);
				return response;
			}
			//根据用户id获取屠宰场id
			String sl = andSlUser.getSlaughterhouseIdByUserId(vo.getUserId());
			if(StringUtils.isEmpty(sl)){
				response.setCode(ConstantsUtil.RES_PARAMER_FAIL_CODE);
				response.setMessage(ConstantsUtil.RES_PARAMER_FAIL_MESSAGE);
				return response;
			}
			vo.setSlaughterId(sl);
		}
		
		Integer result = supplierService.add(vo);
		if(result != 1){
			response.setCode(ConstantsUtil.RES_FAIL_CODE);
			response.setMessage(ConstantsUtil.RES_FAIL_MESSAGE);
			return response;
		}
		response.setCode(ConstantsUtil.RES_SUCCESS_CODE);
		response.setMessage(ConstantsUtil.RES_SUCCESS_MESSAGE);
		return response;
	}
	
	/**
	 * 根据入库单id获取单据详情
	 * @param id
	 * @return
	 */
	@ResponseBody 
	@RequestMapping(value = "/supplier/find_by_id",method = {RequestMethod.POST,RequestMethod.GET})
	public ResponseVO findSupplierById(@RequestParam(value = "id") String id){
		ResponseVO vo = new ResponseVO();
		vo.setCode(ConstantsUtil.RES_SUCCESS_CODE);
		vo.setMessage(ConstantsUtil.RES_SUCCESS_MESSAGE);
		vo.setData(supplierService.findById(id));
		return vo;
	}
	
	/**
	 * 根据用户id查询该用户屠宰场当日入库数据
	 * @param userId
	 * @return
	 */
	@ResponseBody 
	@RequestMapping(value = "/supplier/find_page_by_uid",method = {RequestMethod.POST,RequestMethod.GET})
	public ResponseVO findPageByUserId(@RequestParam(value = "user_id") String userId,
									   @RequestParam(value = "start")Integer start,
									   @RequestParam(value = "length")Integer length){
		return supplierService.findPageByUserId(userId,start,length);
	}
	
	/**
	 * 根据屠宰场id查询该屠宰场当日入库数据（监管人员）
	 * @param slId 屠宰场id
	 * @return
	 */
	@ResponseBody 
	@RequestMapping(value = "/supplier/find_page_by_slaughter_id",method = {RequestMethod.POST,RequestMethod.GET})
	public ResponseVO findPageBySlId(@RequestParam(value = "slaughter_id") String slId,
									 @RequestParam(value = "start")Integer start,
									 @RequestParam(value = "length")Integer length){
		return supplierService.findPageBySlId(slId,start,length);
	}
	
	/**
	 * 新增出库信息
	 * @param vo
	 * @return
	 */
	@ResponseBody 
	@RequestMapping(value = "/wholesaler/add",method = {RequestMethod.POST,RequestMethod.GET})
	public ResponseVO addWholesaler(WholesalerVo vo){
		ResponseVO response = new ResponseVO();
		if(StringUtils.isEmpty(vo.getSlaughterId())){//如果屠宰场id为空
			if(StringUtils.isEmpty(vo.getUserId())){
				response.setCode(ConstantsUtil.RES_PARAMER_FAIL_CODE);
				response.setMessage(ConstantsUtil.RES_PARAMER_FAIL_MESSAGE);
				return response;
			}
			//根据用户id获取屠宰场id
			String sl = andSlUser.getSlaughterhouseIdByUserId(vo.getUserId());
			if(StringUtils.isEmpty(sl)){
				response.setCode(ConstantsUtil.RES_PARAMER_FAIL_CODE);
				response.setMessage(ConstantsUtil.RES_PARAMER_FAIL_MESSAGE);
				return response;
			}
			vo.setSlaughterId(sl);
		}
		
		Integer result = wholesalerService.add(vo);
		if(result != 1){
			response.setCode(ConstantsUtil.RES_FAIL_CODE);
			response.setMessage(ConstantsUtil.RES_FAIL_MESSAGE);
			return response;
		}
		response.setCode(ConstantsUtil.RES_SUCCESS_CODE);
		response.setMessage(ConstantsUtil.RES_SUCCESS_MESSAGE);
		return response;
	}
	
	/**
	 * 根据出库单id获取详情
	 * @param id 出库单id
	 * @return
	 */
	@ResponseBody 
	@RequestMapping(value = "/wholesaler/find_by_id",method = {RequestMethod.POST,RequestMethod.GET})
	public ResponseVO findWholesalerById(@RequestParam(value = "id") String id){
		ResponseVO vo = new ResponseVO();
		vo.setCode(ConstantsUtil.RES_SUCCESS_CODE);
		vo.setMessage(ConstantsUtil.RES_SUCCESS_MESSAGE);
		vo.setData(wholesalerService.findById(id));
		return vo;
	}
	
	/**
	 * 根据用户id查询该用户屠宰场当日出库数据
	 * @param userId
	 * @return
	 */
	@ResponseBody 
	@RequestMapping(value = "/wholesaler/find_page_by_uid",method = {RequestMethod.POST,RequestMethod.GET})
	public ResponseVO findWholesalerPageByUserId(@RequestParam(value = "user_id") String userId,
												 @RequestParam(value = "start")Integer start,
												 @RequestParam(value = "length")Integer length){
		return wholesalerService.findPageByUserId(userId,start,length);
	}
	
	/**
	 * 根据屠宰场id查询该屠宰场当日出库数据（监管人员）
	 * @param slId 屠宰场id
	 * @return
	 */
	@ResponseBody 
	@RequestMapping(value = "/wholesaler/find_page_by_slaughter_id",method = {RequestMethod.POST,RequestMethod.GET})
	public ResponseVO findWholesalerPageBySlId(@RequestParam(value = "slaughter_id") String slId,
												 @RequestParam(value = "start")Integer start,
												 @RequestParam(value = "length")Integer length){
		return wholesalerService.findPageBySlId(slId,start,length);
	}
	
	/**
	 * 根据用户id查询屠宰场数据
	 * @param userId 用户id
	 * @return
	 */
	@ResponseBody 
	@RequestMapping(value = "/find_number_by_uid",method = {RequestMethod.POST,RequestMethod.GET})
	public ResponseVO findNumberByUserId(@RequestParam(value = "user_id") String userId){
		ResponseVO vo = new ResponseVO();
		vo.setCode(ConstantsUtil.RES_SUCCESS_CODE);
		vo.setMessage(ConstantsUtil.RES_SUCCESS_MESSAGE);
		vo.setData(wholesalerService.findNumberByUserId(userId));
		return vo;
	}
	
	/**
	 * 根据屠宰场id查询屠宰场数据
	 * @param slId 屠宰场id
	 * @return
	 */
	@ResponseBody 
	@RequestMapping(value = "/find_number_by_slaughter_id",method = {RequestMethod.POST,RequestMethod.GET})
	public ResponseVO findNumberBySlId(@RequestParam(value = "slaughter_id") String slId){
		ResponseVO vo = new ResponseVO();
		vo.setCode(ConstantsUtil.RES_SUCCESS_CODE);
		vo.setMessage(ConstantsUtil.RES_SUCCESS_MESSAGE);
		vo.setData(wholesalerService.findNumberBySlId(slId));
		return vo;
	}

}
