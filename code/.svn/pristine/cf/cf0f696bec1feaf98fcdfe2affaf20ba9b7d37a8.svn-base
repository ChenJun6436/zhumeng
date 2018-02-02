package com.jf.projects.zmt.service;

import com.jf.projects.zmt.model.PigBreed;
import com.jf.projects.zmt.vo.ResponseVO;

public interface PigBreedService {

	/**
	 * 新增一条数据,不能重复，默认为禁用
	 * 
	 * @param pigBreed
	 * @return
	 */
	public ResponseVO add(PigBreed pigBreed);

	/**
	 * 获取所有
	 * 
	 * @return
	 */
	public ResponseVO findAll();

	/**
	 * 删除,如果改数据有被使用不能被删除
	 * 
	 * @param id
	 * @return
	 */
	public ResponseVO delete(String id);

	/**
	 * 禁用启用，如果该数据有被使用不能被禁用
	 * 
	 * @param id
	 * @return
	 */
	public ResponseVO updateStatus(String id);

	/**
	 * 获取可用的生猪类型
	 * 
	 * @return
	 */
	public ResponseVO findPigBreedEnable();

}
