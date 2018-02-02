package com.zmt.zmtofficialwebsite.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zmt.zmtofficialwebsite.dao.SeoInfoRepository;
import com.zmt.zmtofficialwebsite.model.SeoInfo;
import com.zmt.zmtofficialwebsite.service.SeoInfoService;
import com.zmt.zmtofficialwebsite.util.result.ResultVo;
import com.zmt.zmtofficialwebsite.vo.Home_SeoVo;

@Service
@Transactional(rollbackFor = Exception.class)
public class SeoInfoServiceImpl implements SeoInfoService {

	@Autowired
	private SeoInfoRepository seoInfoRepository;

	@Override
	public ResultVo saveSeoInfo(SeoInfo seoInfo) {
		if (seoInfo.getId() == null) {
			seoInfo.setCreateTime(new Date());
		}
		seoInfo.setLastUpdateTime(new Date());
		SeoInfo data = seoInfoRepository.save(seoInfo);
		if (data != null) {
			ResultVo vo = new ResultVo(data);
			return vo;
		} else {
			return ResultVo.error("失败");
		}

	}

	/**
	 * 首页seo配置查询
	 * 
	 * @return Home_SeoVo
	 */
	@Override
	public Home_SeoVo findConfiguration() {
		List<SeoInfo> seoInfo = seoInfoRepository.findAll();
		if (null == seoInfo || seoInfo.size() < 1) {
			return null;
		}
		return new Home_SeoVo(seoInfo.get(0).getTitle(), seoInfo.get(0)
				.getKeywords(), seoInfo.get(0).getDescription());
	}

	@Override
	public ResultVo findSeo() {
		List<SeoInfo> list = seoInfoRepository.findAll();
		if (null == list || list.size() < 1) {
			return new ResultVo(null);
		}
		return new ResultVo(list.get(0));
	}
}
