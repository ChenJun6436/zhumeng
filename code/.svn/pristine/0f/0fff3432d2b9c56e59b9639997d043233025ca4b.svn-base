package com.jf.projects.zmt.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jf.projects.zmt.model.Brand;
import com.jf.projects.zmt.vo.fileManager.AppBrandVo;

public interface BrandMapper extends BaseMapper<Brand> {
	/**
	 * 激活改标签
	 * 
	 * @param sign
	 * @return
	 */
	int activeBrand(@Param("sign") String sign, @Param("userId") String userId,
			@Param("creatDate") String creatDate);

	/**
	 * 查找标签状态
	 * 
	 * @param sign
	 * @return
	 */
	int findBrandStatus(@Param("sign") String sign);

	/**
	 * 删除激活的标签
	 * 
	 * @param sign
	 * @return
	 */
	int deleteSign(@Param("sign") String sign);

	/**
	 * 查找标签
	 * 
	 * @param sign
	 * @return
	 */
	Brand findBrand(@Param("sign") String sign);

	/**
	 * app端查找某一个人激活的生猪
	 * 
	 * @param id
	 * @param beginDate
	 * @param endDate
	 * @param keyWords
	 * @return
	 */
	List<AppBrandVo> findAppBrandInfoByCreater(@Param(value = "id") String id,
			@Param(value = "beginDate") String beginDate,
			@Param(value = "endDate") String endDate,
			@Param("keyWords") String keyWords);

	/**
	 * 批量插入生猪标签
	 * 
	 * @param list
	 * @return
	 */
	int insertBrand(List<Brand> list);
}