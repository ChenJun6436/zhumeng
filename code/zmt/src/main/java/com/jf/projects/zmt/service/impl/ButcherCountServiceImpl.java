package com.jf.projects.zmt.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jf.projects.zmt.dao.LButcherCountMapper;
import com.jf.projects.zmt.model.LButcherCount;
import com.jf.projects.zmt.service.ButcherCountService;
import com.jf.projects.zmt.util.UUIDUtil;

@Service
public class ButcherCountServiceImpl implements ButcherCountService {
	
	@Autowired
	private LButcherCountMapper mapper;

	@Override
	public Integer add(LButcherCount bean) {
		
		//查询该屠宰场当天是否有数据 如果有则删除，如果没有直接添加数据
		List<LButcherCount> list = mapper.findBySlaughterhouseId(bean.getSlaughterhouseId());
		if(list.size() > 0){//判断当天是否有数据
			List<String> ids = new ArrayList<String>();
			for(LButcherCount lc : list){
				ids.add(lc.getId());
			}
			mapper.deleteByIds(ids);
		}
		bean.setId(UUIDUtil.getUUID());
		bean.setCreateTime(new Date());
		bean.setUpdateTime(new Date());
		Integer result = mapper.insert(bean);
		return result;
	}

	
	
}
