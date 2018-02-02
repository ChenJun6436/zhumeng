package com.jf.projects.zmt.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jf.projects.zmt.service.MarketSaleService;
import com.jf.projects.zmt.service.PigService;
import com.jf.projects.zmt.util.ConstantsUtil;
import com.jf.projects.zmt.vo.ResponseVO;


/**
 * 
 * @ClassName: PigController
 *
 * @Description:生猪
 *
 * @author wj
 *
 * @date 2018年1月8日
 *
 */
@Controller
@RequestMapping("/*")
public class PigController {
	
	@Autowired
	private PigService pigService;
	
	@Autowired
	private MarketSaleService saleService;
	
	/**
	 * 获取生猪品种数据
	 * @return
	 */
	@RequestMapping(value = "/pig/getPigType",method = RequestMethod.POST)
	@ResponseBody	
	public ResponseVO getPigType(@RequestParam(required = false)  Integer type){//type=1获取市级数据
		ResponseVO responseVO = new ResponseVO();
		try {
			responseVO.setCode(ConstantsUtil.RES_SUCCESS_CODE);
			responseVO.setMessage(ConstantsUtil.RES_SUCCESS_MESSAGE);
			responseVO.setData(pigService.findPigType(type));
			return responseVO;
		} catch (Exception e) {
			e.printStackTrace();
			responseVO.setCode(ConstantsUtil.RES_FAIL_CODE);
			responseVO.setMessage(ConstantsUtil.RES_FAIL_MESSAGE);
			return responseVO;		
		}
	}
	
	/**
	 * 获取生猪品种TOP5
	 * @return
	 */
	@RequestMapping(value = "/pig/getPigTop5",method = RequestMethod.POST)
	@ResponseBody	
	public ResponseVO getPigTop5(@RequestParam(required = false)  Integer type){//type=1获取市级数据
		ResponseVO responseVO = new ResponseVO();
		try {
			responseVO.setCode(ConstantsUtil.RES_SUCCESS_CODE);
			responseVO.setMessage(ConstantsUtil.RES_SUCCESS_MESSAGE);
			responseVO.setData(pigService.findPigTop5(type));
			return responseVO;
		} catch (Exception e) {
			e.printStackTrace();
			responseVO.setCode(ConstantsUtil.RES_FAIL_CODE);
			responseVO.setMessage(ConstantsUtil.RES_FAIL_MESSAGE);
			return responseVO;		
		}
	}
	
	/**
	 * 获取总览
	 * @return
	 */
	@RequestMapping(value = "/pig/getOverview",method = RequestMethod.POST)
	@ResponseBody	
	public ResponseVO getOverview(@RequestParam(required = false)  Integer type){//type=1获取市级数据
		ResponseVO responseVO = new ResponseVO();
		try {
			responseVO.setCode(ConstantsUtil.RES_SUCCESS_CODE);
			responseVO.setMessage(ConstantsUtil.RES_SUCCESS_MESSAGE);
			responseVO.setData(pigService.findOverview(type));
			return responseVO;
		} catch (Exception e) {
			e.printStackTrace();
			responseVO.setCode(ConstantsUtil.RES_FAIL_CODE);
			responseVO.setMessage(ConstantsUtil.RES_FAIL_MESSAGE);
			return responseVO;		
		}
	}
	
	/**
	 * 获取销售重量及销售市场前五名
	 * @return
	 */
	@RequestMapping(value = "/market/sale/top5",method = RequestMethod.POST)
	@ResponseBody	
	public ResponseVO getMarketSaleTop5(@RequestParam(required = false)  Integer type){//type=1获取市级数据
		ResponseVO responseVO = new ResponseVO();
		try {
			responseVO.setCode(ConstantsUtil.RES_SUCCESS_CODE);
			responseVO.setMessage(ConstantsUtil.RES_SUCCESS_MESSAGE);
			responseVO.setData(saleService.findMarketToSale(type));
			return responseVO;
		} catch (Exception e) {
			e.printStackTrace();
			responseVO.setCode(ConstantsUtil.RES_FAIL_CODE);
			responseVO.setMessage(ConstantsUtil.RES_FAIL_MESSAGE);
			return responseVO;		
		}
	}
	
}
