package com.jf.projects.zmt.service;

import com.jf.projects.zmt.model.LButcherCount;

/**
 * 屠宰场宰杀数量
 * @author dqh
 *
 */
public interface ButcherCountService {
	
	/**
	 * 新增 每天只保留一条数据，后添加覆盖之前的数据
	 * @param bean
	 * @return
	 */
	public Integer add(LButcherCount bean);

}
