package com.zmt.zmtofficialwebsite.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zmt.zmtofficialwebsite.model.SeoInfo;
import com.zmt.zmtofficialwebsite.service.SeoInfoService;
import com.zmt.zmtofficialwebsite.util.result.ResultVo;

/**
 * 
 * 
 * @className:
 * 
 * @description:官网后台seo 配置
 * 
 * @author wzw
 * 
 * @date 2018年1月10日
 * 
 */
@Controller
@RequestMapping("/websit")
public class SeoInfoController {
	@Autowired
	private SeoInfoService seoInfoService;

	/**
	 * 保存修改seo配置
	 * 
	 * @param seoInfo
	 * @return
	 */
	@RequestMapping(value = "/save/seoInfo", method = RequestMethod.POST)
	@ResponseBody
	public ResultVo saveSeoInfo(SeoInfo seoInfo) {
		return seoInfoService.saveSeoInfo(seoInfo);
	}

	@RequestMapping(value = "/find/seoInfo", method = RequestMethod.GET)
	@ResponseBody
	public ResultVo findSeoInfo() {
		return seoInfoService.findSeo();
	}

}
