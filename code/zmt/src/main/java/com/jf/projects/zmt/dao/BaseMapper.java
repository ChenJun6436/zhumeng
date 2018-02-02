package com.jf.projects.zmt.dao;


import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
 * 
* @ClassName: BaseMapper 
* @Description: 基础dao
* @author 
* @date 
* @param <T>
 */
public interface BaseMapper<T>
{
  
    /**
     * 
     * @Title: insert
     * @Description 插入数据
     * @param t
     * @return int
     */
    public int insert(T t);
   
    /**
     * 
     * @Title: delete
     * @Description 根据id删除数据
     * @param id
     * @return void
     */
    public void delete(@Param(value = "id") String id);


    /**
     * 
     * @Title: update
     * @Description 根据id更新不为null的数据
     * @param t
     * @return int
     */
    public int update(T t);


    /**
     * 
     * @Title: findById
     * @Description 根据id更新不为null的数据
     * @param id
     * @return T
     */
    public T findById(@Param(value = "id") String id);


    /**
     * 
     * @Title: findAll
     * @Description 查询所有的数据
     * @return
     * @return T
     */
    public List<T> findAll();
    
   
    
}
