package com.jf.projects.zmt.service;

import com.jf.projects.zmt.vo.ResponseVO;
import com.jf.projects.zmt.vo.deal.SupplierVo;

/**
 * 供货商（入库） service
 * @author dqh
 *
 */
public interface SupplierServcie {

	/**
	 * 添加入库单
	 * @param vo
	 * @return
	 */
	public Integer add(SupplierVo vo);
	
	/**
	 * 根据入库单id获取详情
	 * @param id
	 * @return
	 */
	public SupplierVo findById(String id);
	
	/**
	 * 根据用户id查询该用户屠宰场当日入库数据
	 * @param userId 
	 * @return
	 */
	public ResponseVO findPageByUserId(String userId,Integer start,Integer length);
	
	/**
	 * 根据屠宰场id查询该屠宰场当日入库数据
	 * @param slId 
	 * @return
	 */
	public ResponseVO findPageBySlId(String slId,Integer start,Integer length);
}
