package com.jf.projects.zmt.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jf.projects.zmt.model.Area;
import com.jf.projects.zmt.vo.OptionVo;

public interface AreaMapper extends BaseMapper<Area>{
	
	/**
	 * 根据父类id获取下面的子类
	 * @param id
	 * @return
	 */
	public List<Area> findByParent(@Param(value = "id")Integer id);
	
	/**
	 * 根据id获取一条数据
	 * @param id
	 * @return
	 */
	
	public Area findById(@Param(value = "id") Integer id);
	
	/**
	 * 获取所有省份下拉列表
	 * @return
	 */
	public List<OptionVo> findProvinceOption();
	
	/**
	 * 根据省id获取所有市下拉列表
	 * @return
	 */
	public List<OptionVo> findCityOption(@Param(value = "provId") Integer provId);
	
	
	/**
	 * 根据市id获取所有区县下拉列表
	 * @return
	 */
	public List<OptionVo> findDistrictOption(@Param(value = "cityId") Integer cityId);
	
	/**
	 * 根据多id获取省（ztree使用）
	 * @param ids 区域id
	 * @return
	 */
	public List<OptionVo> findProByList(@Param(value = "ids")List<Integer> ids);
	
	/**
	 * 根据多id获取市（ztree使用）
	 * @param ids 区域id
	 * @return
	 */
	public List<OptionVo> findCityByList(@Param(value = "ids")List<Integer> ids);
	
	/**
	 * 根据多id获取区县（ztree使用）
	 * @param ids 区域id
	 * @return
	 */
	public List<OptionVo> findDisByList(@Param(value = "ids")List<Integer> ids);
}