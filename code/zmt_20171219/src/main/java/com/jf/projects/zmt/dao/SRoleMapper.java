package com.jf.projects.zmt.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jf.projects.zmt.model.SRole;
import com.jf.projects.zmt.vo.role.RoleListVo;

public interface SRoleMapper extends BaseMapper<SRole> {
	/**
	 * 通过userId查找角色名字
	 * 
	 * @param userId
	 * @return
	 */
	List<String> findRolesByUseId(@Param("userId") String userId);
    
	/**
	 * 根据部门ID查询角色信息
	 * @param departmentId
	 * @return
	 */
    List<SRole> findByDepartmentId(@Param("departmentId") String departmentId);
    
    /**
     * 查询该部门下是否存在角色数据
     * @param departmentId
     * @param roleName
     * @return
     */
    SRole findByNameAndDepartmentId(@Param("departmentId") String departmentId,@Param("roleName") String roleName);
    
    /**
     * 分页获取角色列表
     * @param typeId
     * @param departmentId
     * @param roleId
     * @param start
     * @param length
     * @return
     */
    List<RoleListVo> findRoleList(@Param("typeId") String typeId,
                                  @Param("departmentId") String departmentId,
                                  @Param("roleId") String roleId,
                                  @Param("start") Integer start,
                                  @Param("length") Integer length);
    
    /**
     * 根据用户id 获取角色
     * @param userId
     * @return
     */
    SRole findRoleByUserId(@Param("userId") String userId);
    
    /**
     * 根据角色code获取角色
     * @param code
     * @return
     */
    SRole findRoleByCode(@Param("code") String code);
}