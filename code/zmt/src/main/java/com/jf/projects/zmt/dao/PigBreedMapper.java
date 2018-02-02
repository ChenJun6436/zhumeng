package com.jf.projects.zmt.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jf.projects.zmt.model.PigBreed;
import com.jf.projects.zmt.vo.pigBreed.PigBreedEnableVo;
import com.jf.projects.zmt.vo.pigBreed.PigBreedVo;

public interface PigBreedMapper extends BaseMapper<PigBreed> {

	/**
	 * 根据名称查看是否有重复数据
	 * 
	 * @param name
	 * @return
	 */
	public PigBreed isRepetition(@Param(value = "id") String id,
			@Param(value = "name") String name);

	/**
	 * 获取所有
	 * 
	 * @return
	 */
	public List<PigBreedVo> findAllPigBreed();

	/**
	 * 获取没有禁用的品种返回id和名字
	 * 
	 * @return
	 */
	public List<PigBreedEnableVo> findPigBreedOfEnable();

}