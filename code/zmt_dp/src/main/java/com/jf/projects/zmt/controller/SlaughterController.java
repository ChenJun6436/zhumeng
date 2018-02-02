package com.jf.projects.zmt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jf.projects.zmt.service.SlaughterService;
import com.jf.projects.zmt.util.ConstantsUtil;
import com.jf.projects.zmt.vo.ResponseVO;


/**
 * 
 * @ClassName: SlaughterController
 *
 * @Description:屠宰
 *
 * @author wj
 *
 * @date 2018年1月8日
 *
 */
@Controller
@RequestMapping("/*")
public class SlaughterController {
	
	@Autowired
	private SlaughterService service;//屠宰Service
	
	
	/**
	 * 近1年生猪总数与屠宰数折线图
	 * @return
	 */
	@RequestMapping(value = "/find/pig_and_slaughter_for_year",method = RequestMethod.POST)
	@ResponseBody	
	public ResponseVO countPigAndSlaughterForYear(@RequestParam(required = false)  Integer type){//type=1获取市级数据
		ResponseVO responseVO = new ResponseVO();
		try {
			responseVO.setCode(ConstantsUtil.RES_SUCCESS_CODE);
			responseVO.setMessage(ConstantsUtil.RES_SUCCESS_MESSAGE);
			responseVO.setData(service.findPigAndSlaughterForYear(type));
			return responseVO;
		} catch (Exception e) {
			e.printStackTrace();
			responseVO.setCode(ConstantsUtil.RES_FAIL_CODE);
			responseVO.setMessage(ConstantsUtil.RES_FAIL_MESSAGE);
			return responseVO;		
		}
	}
	
	/**
	 * 近1年生猪总数与屠宰数折线图
	 * @return
	 */
	@RequestMapping(value = "/find/slaughter/top5",method = RequestMethod.POST)
	@ResponseBody	
	public ResponseVO findSlaughtTop5(@RequestParam(required = false)  Integer type){//type=1获取市级数据
		ResponseVO responseVO = new ResponseVO();
		try {
			responseVO.setCode(ConstantsUtil.RES_SUCCESS_CODE);
			responseVO.setMessage(ConstantsUtil.RES_SUCCESS_MESSAGE);
			responseVO.setData(service.findTop5ToMonth(type));
			return responseVO;
		} catch (Exception e) {
			e.printStackTrace();
			responseVO.setCode(ConstantsUtil.RES_FAIL_CODE);
			responseVO.setMessage(ConstantsUtil.RES_FAIL_MESSAGE);
			return responseVO;		
		}
	}
	
}
