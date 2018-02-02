package com.jf.projects.zmt.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jf.projects.zmt.model.HikVideo;

public interface HikVideoMapper extends BaseMapper<HikVideo>{
  /**
   * 根据屠宰场ID获取视频地址信息  
   * @param slaughterhouseId
   * @return
   */
  List<HikVideo>  findBySlaughterhouseId(@Param("slaughterhouseId") String slaughterhouseId);
  
}