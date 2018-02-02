package com.jf.projects.zmt.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jf.projects.zmt.model.AndRoleResource;
import com.jf.projects.zmt.vo.resource.ResourceVo;
import com.jf.projects.zmt.vo.role.RoleVo;

/**
 * 
 * @className: AndRoleResourceMapper
 * 
 * @description:角色资源
 * 
 * @author wj
 * 
 * @date 2017年10月30日下午4:50:46
 * 
 */
public interface AndRoleResourceMapper extends BaseMapper<AndRoleResource> {

	/**
	 * 批量新增角色资源
	 * 
	 * @param list
	 */
	void addRoleResourceBatch(List<AndRoleResource> list);

	/**
	 * 根据角色ID删除角色资源数据
	 * 
	 * @param roleId
	 */
	void deleteByRoleId(String roleId);

	/**
	 * 根据角色ID获取资源数据
	 * 
	 * @param roleId
	 * @return
	 */
	List<ResourceVo> findResourceByRoleId(@Param("roleId") String roleId);

	/**
	 * 根据资源获取角色
	 * 
	 * @param resource
	 * @return
	 */
	List<RoleVo> findRoleVoByResource(@Param("resource") String resource);
}