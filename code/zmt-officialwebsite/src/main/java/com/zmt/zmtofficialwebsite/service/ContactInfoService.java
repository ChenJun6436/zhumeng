package com.zmt.zmtofficialwebsite.service;

import com.zmt.zmtofficialwebsite.util.result.ResultVo;
import com.zmt.zmtofficialwebsite.vo.FormVo;
import com.zmt.zmtofficialwebsite.vo.Home_BottomVo;

/**
 * @author wzw
 * @className:
 * @description:
 * @date 2018年1月11日
 */
public interface ContactInfoService {

	/**
	 * 保存或者修改官网底部信息
	 */
	ResultVo saveContactInfo(FormVo vo);

	/**
	 * 官网首页查询
	 * 
	 * @return Home_SeoVo
	 */
	Home_BottomVo findConfiguration();

	ResultVo findContactInfo();
}