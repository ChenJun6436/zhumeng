package com.jf.projects.zmt.service;

import com.jf.projects.zmt.vo.pig.SlaughterTop5Vo;
import com.jf.projects.zmt.vo.pig.YearCountNumVO;

/**
 * 屠宰
 * @author dev
 *
 */
public interface SlaughterService {
	
	/**
	 * 统计一年的生猪及屠宰数
	 * @return
	 */
	public YearCountNumVO findPigAndSlaughterForYear(Integer type);
	
	/**
	 * 获取当月屠宰数量前五名数据
	 * @return
	 */
	public SlaughterTop5Vo findTop5ToMonth(Integer type);

}
