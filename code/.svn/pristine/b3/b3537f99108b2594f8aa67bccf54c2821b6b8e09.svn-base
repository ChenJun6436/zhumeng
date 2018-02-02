package com.jf.projects.zmt.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jf.projects.zmt.model.SignExcel;
import com.jf.projects.zmt.vo.farms.SignExcelVo;

public interface SignExcelMapper extends BaseMapper<SignExcel> {
	/**
	 * 查找所有生产的生猪标签excel信息
	 * 
	 * @return
	 */
	List<SignExcelVo> findAllSignExcel(@Param(value = "start") Integer start,
			@Param(value = "length") Integer length);

	/**
	 * 统计总共有几个Exel
	 * 
	 * @return
	 */
	Integer countSignExcel();
}