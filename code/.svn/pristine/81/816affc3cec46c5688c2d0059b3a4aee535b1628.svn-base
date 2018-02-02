package com.zmt.zmtofficialwebsite.service;


import com.zmt.zmtofficialwebsite.util.result.ResultVo;
import com.zmt.zmtofficialwebsite.vo.ImageVo;
import java.util.List;

public interface ImageService {

  /**
   * 获取图片信息
   *
   * @return List
   */
  ResultVo findImage();


  /**
   * 保存图片信息
   *
   * @param id 图片id
   * @param name 图片名
   * @param url 图片地址
   * @return ImageVo
   */
  ImageVo save(Long id, String url, String name);

  /**
   * 删除图片信息
   *
   * @param id 图片id
   */
  void delete(Long id);

  /**
   * 查询图片的访问地址
   *
   * @return List
   */
  List<String> findUrlByAll();
}
