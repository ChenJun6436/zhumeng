package com.jf.projects.zmt.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jf.projects.zmt.model.Type;
/**
 * 
 * @className: TypeMapper
 *
 * @description:角色类型
 *
 * @author wj
 *
 * @date 2017年10月25日下午2:56:06
 *
 */
public interface TypeMapper extends BaseMapper<Type>{
    
    /**
     * 根据name获取用户角色类型
     * @param name
     * @return
     */
    List<Type> findByName(@Param("name") String name);
}