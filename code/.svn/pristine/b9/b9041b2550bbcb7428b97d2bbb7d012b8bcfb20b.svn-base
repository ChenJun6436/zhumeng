package com.zmt.zmtofficialwebsite.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zmt.zmtofficialwebsite.dao.ContactInfoRepository;
import com.zmt.zmtofficialwebsite.dao.FriendLinkRepository;
import com.zmt.zmtofficialwebsite.model.ContactInformation;
import com.zmt.zmtofficialwebsite.model.FriendLink;
import com.zmt.zmtofficialwebsite.service.ContactInfoService;
import com.zmt.zmtofficialwebsite.service.FileUploadService;
import com.zmt.zmtofficialwebsite.util.result.ResultVo;
import com.zmt.zmtofficialwebsite.vo.FormVo;
import com.zmt.zmtofficialwebsite.vo.Home_BottomVo;
import com.zmt.zmtofficialwebsite.vo.Links;

@Service
@Transactional(rollbackFor = Exception.class)
public class ContactInfoServiceImpl implements ContactInfoService {

	@Autowired
	private ContactInfoRepository contactInfoRepository;
	@Autowired
	private FriendLinkRepository friendLinkRepository;
	@Autowired
	private FileUploadService uploadService;

	@Override
	public ResultVo saveContactInfo(FormVo vo) {
		Number number = friendLinkRepository.count();

		ContactInformation c = new ContactInformation();
		c.setCreateTime(new Date());
		c.setId(1L);
		c.setAddres(vo.getAddress());
		c.setPhone(vo.getPhone());
		c.setRecord(vo.getRecord());
		c.setTel(vo.getTel());
		c.setWbName(vo.getWbName());
		c.setWxName(vo.getWxName());
		c.setLastUpdateTime(new Date());
		c.setWbImg(vo.getWbImg());
		c.setWxImg(vo.getWxImg());
		if (vo.getLiksList() != null) {
			if (number.intValue() + vo.getLiksList().size() > 20) {
				return ResultVo.error("超过20个链接不能再添加");
			}
		}
		ContactInformation mContactInformation = contactInfoRepository.save(c);

		// 友情连接
		List<FriendLink> friendLinks = new ArrayList<>();
		for (Links links : vo.getLiksList()) {
			FriendLink fLink = new FriendLink();
			fLink.setId(links.getId());
			fLink.setFalg("true");
			fLink.setName(links.getName());
			fLink.setUrl(links.getUrl());
			if (links.getId() != null) {
				fLink.setCreateTime(new Date());
			}
			fLink.setLastUpdateTime(new Date());
			friendLinks.add(fLink);
		}
		friendLinkRepository.save(friendLinks);
		return new ResultVo(mContactInformation);

	}

	/**
	 * 官网首页查询
	 * 
	 * @return Home_SeoVo
	 */
	@Override
	public Home_BottomVo findConfiguration() {
		List<ContactInformation> information = contactInfoRepository.findAll();
		if (null == information || information.size() < 1) {
			return null;
		}
		return new Home_BottomVo(information.get(0));
	}

	@Override
	public ResultVo findContactInfo() {
		List<ContactInformation> list = contactInfoRepository.findAll();
		if (null == list || list.size() < 1) {
			return new ResultVo(null);
		}
		return new ResultVo(list.get(0));
	}
}
