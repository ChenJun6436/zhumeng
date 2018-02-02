package com.jf.projects.zmt.service;

import java.util.List;

import com.jf.projects.zmt.vo.deal.CarInfoVo;

/**
 * 车辆信息
 * @author dqh
 *
 */
public interface CarInfoService {

	/**
	 * 添加车辆信息
	 * @param vo
	 * @return
	 */
	public Integer add(CarInfoVo vo);
	
	/**
	 * 根据单据id获取相关车辆信息
	 * @param codeId
	 * @return
	 */
	public List<CarInfoVo> findByCodeId(String codeId);
	
}
