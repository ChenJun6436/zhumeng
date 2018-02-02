package com.jf.projects.zmt.service;

import java.util.List;

import com.jf.projects.zmt.model.SRole;
import com.jf.projects.zmt.vo.ResponseVO;
/**
 * 
 * @className: RoleService
 *
 * @description:用户角色
 *
 * @author wj
 *
 * @date 2017年10月25日下午3:25:43
 *
 */
public interface RoleService {

	/**
	 * @Title: findAll
	 * @Description 获取所有角色类型
	 * @return List<SRole>
	 */
	List<SRole> findAll();
	
	/**
	 * 删除角色
	 * @param roleId
	 * @return
	 */
	ResponseVO deleteRole(String roleId);
	
	/**
	 * 根据部门ID获取角色下拉列表
	 * @param departmentId
	 * @return
	 */
	ResponseVO findRoleByDepartmentId(String departmentId);
	
	/**
	 * 
	 * 新增角色
	 * @param roleName
	 * @param departmentId
	 * @param typeId
	 * @param recourseIds
	 * @return
	 */
	ResponseVO addRole(String roleName,String departmentId,String typeId,String resourceIds,String code,String creator);
	
	/**
     * 
     * 更新角色信息
     * @param roleId
     * @param roleName
     * @param departmentId
     * @param recourseIds
     * @return
     */
    ResponseVO updateRole(String roleId,String roleName,String departmentId,String resourceIds,String code,String creator);
	
    /**
     * 获取角色列表
     * @param departmentId
     * @param roleId
     * @return
     */
    ResponseVO findRoleList(String typeId,String departmentId,String roleId,Integer start,Integer length);

}
