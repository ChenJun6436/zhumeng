package com.jf.projects.zmt.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jf.projects.zmt.model.LCarInfo;
import com.jf.projects.zmt.vo.deal.CarInfoVo;

public interface LCarInfoMapper extends BaseMapper<LCarInfo> {
    
	/**
	 * 根据单据id获取相关车辆信息
	 * @param codeId
	 * @return
	 */
	public List<CarInfoVo> findByCodeId(@Param(value = "codeId")String codeId);

	
}