package com.jf.projects.zmt.dao;

import org.apache.ibatis.annotations.Param;

import com.jf.projects.zmt.model.Fodder;

public interface FodderMapper extends BaseMapper<Fodder> {

	/**
	 * 通过养殖场id修改饲料的状态1
	 * 
	 * @param id
	 * @return
	 */
	Integer updateFodde(@Param(value = "id") String id);

	/**
	 * 通过养殖场id查找正在使用的饲料名字
	 */
	String getFodderInfo(@Param(value = "id") String id);
}