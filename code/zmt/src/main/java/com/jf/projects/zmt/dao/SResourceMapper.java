package com.jf.projects.zmt.dao;

import java.util.List;




import org.apache.ibatis.annotations.Param;

import com.jf.projects.zmt.model.SResource;
import com.jf.projects.zmt.vo.resource.ResourceVo;

public interface SResourceMapper extends BaseMapper<SResource>{
    
    List<ResourceVo> findResourcesByRoleId(@Param("roleId") String roleId);
    
}