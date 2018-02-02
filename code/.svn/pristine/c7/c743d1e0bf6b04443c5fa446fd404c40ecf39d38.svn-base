package com.jf.projects.zmt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jf.projects.zmt.service.CultureService;
import com.jf.projects.zmt.util.ConstantsUtil;
import com.jf.projects.zmt.vo.ResponseVO;



/**
 * 
 * @ClassName: CultureController
 *
 * @Description:养殖
 *
 * @author wj
 *
 * @date 2018年1月8日
 *
 */
@Controller
@RequestMapping("/*")
public class CultureController {
	
	@Autowired
	private CultureService service;
	
	/**
	 * 统计养殖户和散户占比
	 * @return
	 */
	@RequestMapping(value = "/culture/countCulture",method = RequestMethod.POST)
	@ResponseBody	
	public ResponseVO getPigType(@RequestParam(required = false)  Integer type){//type=1获取市级数据
		ResponseVO responseVO = new ResponseVO();
		try {
			responseVO.setCode(ConstantsUtil.RES_SUCCESS_CODE);
			responseVO.setMessage(ConstantsUtil.RES_SUCCESS_MESSAGE);
			responseVO.setData(service.countCulture(type));
			return responseVO;
		} catch (Exception e) {
			e.printStackTrace();
			responseVO.setCode(ConstantsUtil.RES_FAIL_CODE);
			responseVO.setMessage(ConstantsUtil.RES_FAIL_MESSAGE);
			return responseVO;		
		}
	}
}
