package com.jf.projects.zmt.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jf.projects.zmt.dao.LCarInfoMapper;
import com.jf.projects.zmt.model.LCarInfo;
import com.jf.projects.zmt.service.CarInfoService;
import com.jf.projects.zmt.util.UUIDUtil;
import com.jf.projects.zmt.vo.deal.CarInfoVo;

@Service
public class CarInfoServiceImpl implements CarInfoService {
	
	@Autowired
	public LCarInfoMapper mapper;

	@Override
	public Integer add(CarInfoVo vo) {
		LCarInfo cf = new LCarInfo();
		cf.setCarNo(vo.getCarNo());
		cf.setCreateTime(new Date());
		cf.setUpdateTime(new Date());
		cf.setDriver(vo.getDriver());
		cf.setMerchantId(vo.getMerchantId());
		cf.setTel(vo.getTel());
		cf.setId(UUIDUtil.getUUID());
		return mapper.insert(cf);
	}

	@Override
	public List<CarInfoVo> findByCodeId(String codeId) {
		
		return mapper.findByCodeId(codeId);
	}

}
