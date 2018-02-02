package com.zmt.zmtofficialwebsite.dao;

import com.zmt.zmtofficialwebsite.model.Image;
import com.zmt.zmtofficialwebsite.vo.ImageVo;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ImageDao extends JpaRepository<Image, Long> {

  /**
   * 获取图片信息
   *
   * @return List
   */
  @Query("select new com.zmt.zmtofficialwebsite.vo.ImageVo(id,name,url,lastUpdateTime) from Image order by lastUpdateTime desc ")
  List<ImageVo> findImageVoByAll();


}