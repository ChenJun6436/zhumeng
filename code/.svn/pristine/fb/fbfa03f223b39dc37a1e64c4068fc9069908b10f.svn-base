package com.jf.projects.zmt.service;

import com.jf.projects.zmt.vo.ResponseVO;
import com.jf.projects.zmt.vo.deal.CountNumberVo;
import com.jf.projects.zmt.vo.deal.WholesalerVo;

/**
 * 出货单（肉贩子）
 * @author dqh
 *
 */
public interface WholesalerService {

	/**
	 * 添加信息
	 * @param vo
	 * @return
	 */
	public Integer add(WholesalerVo vo);
	
	/**
	 * 根据出库单id获取详情
	 * @param id
	 * @return
	 */
	public WholesalerVo findById(String id);
	
	/**
	 * 根据用户id查询该用户屠宰场当日出库数据
	 * @param userId
	 * @return
	 */
	public ResponseVO findPageByUserId(String userId,Integer start,Integer length);
	
	/**
	 * 根据用户id查询屠宰场数据
	 * @param userId
	 * @return
	 */
	public CountNumberVo findNumberByUserId(String userId);
	
	/**
	 * 根据屠宰场id查询该屠宰场当日出库数据
	 * @param slId 
	 * @return
	 */
	public ResponseVO findPageBySlId(String slId,Integer start,Integer length);
	
	/**
	 * 根据屠宰场id查询屠宰场数据
	 * @param slId
	 * @return
	 */
	public CountNumberVo findNumberBySlId(String slId);
}
