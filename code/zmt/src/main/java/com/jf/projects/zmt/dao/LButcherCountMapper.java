package com.jf.projects.zmt.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jf.projects.zmt.model.LButcherCount;

/**
 * 屠宰场宰杀统计
 * @author dqh
 *
 */
public interface LButcherCountMapper extends BaseMapper<LButcherCount> {
    
	/**
	 * 根据屠宰场id获取当日数据
	 * @param slaughterId 屠宰场id
	 * @return
	 */
	public List<LButcherCount> findBySlaughterhouseId(@Param(value = "slaughterId") String slaughterId);
	
	/**
	 * 根据id批量删除
	 * @param ids
	 */
	public void deleteByIds(@Param(value = "ids") List<String> ids);
	
	/**
	 * 统计今日屠宰数
	 * @param slaughterId
	 * @return
	 */
	public Integer countToday(@Param(value = "slaughterId") String slaughterId);
	
}