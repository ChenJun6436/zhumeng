package com.zmt.zmtofficialwebsite.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.zmt.zmtofficialwebsite.service.NewsService;
import com.zmt.zmtofficialwebsite.util.result.ResultVo;

/**
 * 
 * 
 * @className:
 * 
 * @description:官网分页展示新闻
 * 
 * @author wzw
 * 
 * @date 2018年1月16日
 * 
 */
@RestController
@RequestMapping("/websit")
public class NewsPageController {
	@Autowired
	private NewsService service;

	/**
	 * 分页展示新闻
	 * 
	 * @param type
	 * @param page
	 * @param size
	 * @return
	 */
	@RequestMapping("/news/byType")
	@ResponseBody
	public ResultVo findNewsByType(
			@RequestParam(value = "type", required = true) Integer type,
			@RequestParam(value = "page", required = true, defaultValue = "0") Integer page,
			@RequestParam(value = "size", required = true, defaultValue = "5") Integer size) {
		try {
			if (page >= 1) {
				page = page - 1;
			}
			return new ResultVo(service.findNewsByType(type, page, size));
		} catch (Exception e) {
			e.printStackTrace();
			return ResultVo.error(e.getMessage());
		}
	}
}
