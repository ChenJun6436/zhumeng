package com.jf.projects.zmt.service;

import javax.servlet.http.HttpServletResponse;

import com.jf.projects.zmt.vo.ResponseVO;
import com.jf.projects.zmt.vo.farms.AppSearch;

public interface BrandService {
	/**
	 * 激活生猪标签
	 * 
	 * @param sign
	 * @return
	 */
	ResponseVO activeBrandBySign(String sign, String userId);

	/**
	 * 删除标签
	 * 
	 * @param sign
	 * @return
	 */
	ResponseVO deleteBrandBySign(String sign);

	/**
	 * 养殖户输入标签进行判断该标签是否激活是否有和生猪关联
	 * 
	 * @param Sign
	 * @return
	 */
	ResponseVO findSignDetail(String sign);

	/**
	 * 查找某一个人建立的档案
	 * 
	 * @param vo
	 * @return
	 */
	ResponseVO appFindBrandInfo(AppSearch vo);

	/**
	 * 通过区域获取15位的sign
	 * 
	 * @param code
	 *            区域编码
	 * @return
	 */
	ResponseVO createSign(Integer id, HttpServletResponse response,
			String address);
}
