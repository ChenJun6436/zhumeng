package com.jf.projects.zmt.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jf.projects.zmt.service.BrandService;
import com.jf.projects.zmt.service.SignExcelService;
import com.jf.projects.zmt.vo.RequestPageParam;
import com.jf.projects.zmt.vo.ResponseVO;

@Controller
@RequestMapping("/brand")
public class BrandController {
	@Autowired
	private BrandService brandService;
	@Autowired
	private SignExcelService signExcelService;

	/*
	 * 创建标签
	 */
	@ResponseBody
	@RequestMapping("/sign/create")
	public ResponseVO insertBrand(
			@RequestParam(value = "id", required = true) String id,
			@RequestParam(value = "address", required = true) String address,
			HttpServletResponse response) {
		return brandService.createSign(Integer.valueOf(id), response, address);
	}

	/*
	 * 获取标签EXcel信息
	 */
	@ResponseBody
	@RequestMapping("/sign/getExcel")
	public ResponseVO findSignExcel(RequestPageParam vo) {
		return signExcelService.getPageSignExcel(vo);
	}

	/**
	 * 下载某一个标签Excel
	 * 
	 * @param url
	 * @param response
	 */
	@RequestMapping("/sign/DownExcel")
	public void downSignExcel(
			@RequestParam(value = "url", required = true) String url,
			HttpServletResponse response) {
		signExcelService.downloadSignExcel(url, response);
	}
}
