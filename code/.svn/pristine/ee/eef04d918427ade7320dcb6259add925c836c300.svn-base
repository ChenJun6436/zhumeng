package com.zmt.zmtofficialwebsite.service.impl;

import com.zmt.zmtofficialwebsite.dao.ImageDao;
import com.zmt.zmtofficialwebsite.model.Image;
import com.zmt.zmtofficialwebsite.service.ImageService;
import com.zmt.zmtofficialwebsite.util.result.ResultVo;
import com.zmt.zmtofficialwebsite.vo.ImageVo;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 描述: 图片管理
 *
 * @author dengpeng
 * @create 2018-01-09 14:43
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class ImageServiceImpl implements ImageService {

  @Autowired
  private ImageDao imageDao;


  /**
   * 获取图片信息
   *
   * @return List
   */
  @Override
  public ResultVo findImage() {
    return new ResultVo(imageDao.findImageVoByAll());
  }


  /**
   * 保存图片信息
   *
   * @param id 图片id
   * @param name 图片名
   * @param url 图片地址
   * @return ImageVo
   */
  @Override
  public ImageVo save(Long id, String url, String name) {
    Image image = new Image();
    Date date = new Date();

    List<Image> images = imageDao.findAll();
    if (null != images && images.size() == 5 && null == id) {
      throw new RuntimeException("首页图片最多为5张，不能继续添加");
    }

    if (null != id) {//编辑
      image = imageDao.findOne(id);
      image.setName(name);
    } else {//新增
      image.setCreateTime(date);
      image.setName(name);
    }

    if (null != url) {
      image.setUrl(url);
    }
    image.setLastUpdateTime(date);
    imageDao.save(image);

    return new ImageVo(image.getId(), image.getName(), image.getUrl(), image.getLastUpdateTime());
  }

  /**
   * 删除图片信息
   *
   * @param id 图片id
   */
  @Override
  public void delete(Long id) {
    Image image = imageDao.findOne(id);
    if (null == image) {
      throw new RuntimeException("删除失败");
    }
    imageDao.delete(id);
  }

  /**
   * 查询图片的访问地址
   *
   * @return List
   */
  @Override
  public List<String> findUrlByAll() {
    List<Image> images = imageDao.findAll();
    List<String> list = new ArrayList<>();
    if (null != images && images.size() > 0) {
      for (Image image : images) {
        list.add(image.getUrl());
      }
    }
    return list;
  }

}

