package com.jf.projects.zmt.service;

import java.util.List;

import com.jf.projects.zmt.model.Type;
import com.jf.projects.zmt.vo.ResponseVO;
/**
 * 
 * @className: TypeService
 *
 * @description:角色类型
 *
 * @author wj
 *
 * @date 2017年10月19日下午5:09:39
 *
 */
public interface TypeService {

	/**
	 * @Title: findAll
	 * @Description 获取所有角色类型
	 * @return List<Type>
	 */
	List<Type> findAll();
	
	/**
	 * 新增用户角色类型
	 * @param name
	 * @return
	 */
	ResponseVO addType(String name);
	
	/**
	 * 根据类型名称获取数据
	 * @param name
	 * @return List<Type>
	 */
	List<Type> findByName(String name);
	
	/**
	 * 更新角色类型名称
	 * @param typeId
	 * @param name
	 * @return
	 */
	ResponseVO updateType(String typeId,String name);


}
