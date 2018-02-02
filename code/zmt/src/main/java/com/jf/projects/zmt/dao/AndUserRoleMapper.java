package com.jf.projects.zmt.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jf.projects.zmt.model.AndUserRole;
import com.jf.projects.zmt.model.SUser;

public interface AndUserRoleMapper extends BaseMapper<AndUserRole> {
    /**
     * 查询角色下用户数据
     * @param roleId
     * @return
     */
    List<SUser> findByRoleId(@Param(value = "roleId")String roleId);
    
    /**
     * 根据用户id删除
     * @param userId
     * @return
     */
    int deleteByUserId(@Param(value = "userId")String userId);
}