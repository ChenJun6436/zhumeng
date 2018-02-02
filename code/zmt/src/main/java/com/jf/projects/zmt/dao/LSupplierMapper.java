package com.jf.projects.zmt.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jf.projects.zmt.model.LSupplier;
import com.jf.projects.zmt.vo.deal.DealInfoVo;

public interface LSupplierMapper extends BaseMapper<LSupplier> {
    
	/**
	 * 根据屠宰场id统计当日入库条数
	 * @param slId
	 * @return
	 */
	long findTotal(@Param(value = "slId") String slId);
	
	/**
	 * 根据屠宰场id获取当日入库列表
	 * @param slId
	 * @return
	 */
	List<DealInfoVo> findPageBySlId(@Param(value = "slId") String slId,
									@Param(value = "start") Integer start,
									@Param(value = "length") Integer length);
	
	/**
	 * 根据屠宰场id统计今日入库数量
	 * @param slId
	 * @return
	 */
	Integer countToday(@Param(value = "slId") String slId);
	
}