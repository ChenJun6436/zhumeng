package com.jf.projects.zmt.controller;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jf.projects.zmt.model.PigBreed;
import com.jf.projects.zmt.service.PigBreedService;
import com.jf.projects.zmt.vo.ResponseVO;

@Controller
@RequestMapping("/pig_breed")
public class PigBreedController {

	@Autowired
	private PigBreedService service;

	/**
	 * 新增
	 * 
	 * @param name
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/add", method = { RequestMethod.POST,
			RequestMethod.GET })
	@ResponseBody
	public ResponseVO getType(
			@RequestParam(value = "name", required = false) String name,
			HttpServletRequest request) {
		PigBreed pigBreed = new PigBreed();
		pigBreed.setId(UUID.randomUUID().toString());
		pigBreed.setName(name);
		pigBreed.setStatus("disable");
		return service.add(pigBreed);
	}

	/**
	 * 获取生猪品种信息
	 * 
	 * @return
	 */
	@RequestMapping(value = "/find_all", method = { RequestMethod.POST,
			RequestMethod.GET })
	@ResponseBody
	public ResponseVO findPage() {
		return service.findAll();
	}

	/**
	 * 删除
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/delete", method = { RequestMethod.POST,
			RequestMethod.GET })
	@ResponseBody
	public ResponseVO delete(@Param(value = "id") String id) {
		return service.delete(id);
	}

	/**
	 * 删除
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/update_status", method = { RequestMethod.POST,
			RequestMethod.GET })
	@ResponseBody
	public ResponseVO updateStatus(@Param(value = "id") String id) {
		return service.updateStatus(id);
	}

	@RequestMapping(value = "/getByEnable", method = { RequestMethod.POST,
			RequestMethod.GET })
	@ResponseBody
	public ResponseVO findEnablePigBreed() {
		return service.findPigBreedEnable();
	}
}
