package com.zmt.zmtofficialwebsite.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zmt.zmtofficialwebsite.service.FriendLinkService;
import com.zmt.zmtofficialwebsite.util.result.ResultVo;

/**
 * 
 * 
 * @className:
 * 
 * @description:友情链接
 * 
 * @author wzw
 * 
 * @date 2018年1月18日
 * 
 */
@Controller
@RequestMapping("/websit")
public class FriendLinkController {
	@Autowired
	private FriendLinkService friendLinkService;

	/**
	 * 官网 查找所有友情链接
	 * 
	 * @return
	 */
	@RequestMapping("/find/friendLinks")
	@ResponseBody
	public ResultVo findAllFriendLink() {
		return new ResultVo(friendLinkService.findAll());
	}

	/**
	 * 官网 删除友情链接
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/delete/friendLinks", method = RequestMethod.POST)
	@ResponseBody
	public ResultVo deleteFriendLinks(
			@RequestParam(value = "id", required = true) String id) {
		return friendLinkService.deleteFriendLink(Long.valueOf(id));
	}
}
