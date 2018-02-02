package com.jf.projects.zmt.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jf.projects.zmt.model.LWholesaler;
import com.jf.projects.zmt.vo.deal.DealInfoVo;

public interface LWholesalerMapper extends BaseMapper<LWholesaler> {
    
	/**
	 * 根据屠宰场id统计当日出库条数
	 * @param slId
	 * @return
	 */
	long findTotal(@Param(value = "slId") String slId);
	
	/**
	 * 根据屠宰场id获取当日出库列表
	 * @param slId
	 * @return
	 */
	List<DealInfoVo> findPageBySlId(@Param(value = "slId") String slId,
									@Param(value = "start") Integer start,
									@Param(value = "length") Integer length);
	
	/**
	 * 根据屠宰场id统计今日出库数量
	 * @param slId
	 * @return
	 */
	Integer countToday(@Param(value = "slId") String slId);
}