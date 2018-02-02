package com.zmt.zmtofficialwebsite.controller.admin;

import com.zmt.zmtofficialwebsite.service.FileUploadService;
import com.zmt.zmtofficialwebsite.service.ImageService;
import com.zmt.zmtofficialwebsite.util.result.ResultVo;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * 描述: 图片管理
 *
 * @author Administrator
 * @create 2018-01-09 14:42
 */
@RestController
@RequestMapping("/image")
public class ImageController {

  @Autowired
  private ImageService imageService;

  @Autowired
  FileUploadService uploadService;

  /**
   * 获取图片信息
   *
   * @return List
   */
  @RequestMapping("/findImage")
  public ResultVo findImage() {

    try {
      return imageService.findImage();
    } catch (Exception e) {
      e.printStackTrace();
      return ResultVo.error(e.getMessage());
    }
  }

  /**
   * 新增或修改图片
   *
   * @param id 图片id
   * @return ResultVo
   */
  @RequestMapping("/save")
  public ResultVo save(
      @RequestParam(value = "id", required = false) Long id, MultipartFile file,
      @RequestParam(value = "name", required = false) String name) throws IOException {

    String url = null;
    //获取图片访问路径
    if (file != null) {
      url = uploadService.upload(file);
    }
    try {
      return new ResultVo(imageService.save(id, url, name));
    } catch (Exception e) {
      e.printStackTrace();
      return ResultVo.error(e.getMessage());
    }
  }

  /**
   * 删除图片信息
   *
   * @param id 图片id
   * @return ResultVo
   */
  @RequestMapping("/delete")
  public ResultVo delete(@RequestParam(value = "id", required = false) Long id) {
    if (null == id) {
      return ResultVo.error("参数错误");
    }
    try {
      imageService.delete(id);
      return ResultVo.ok();
    } catch (Exception e) {
      e.printStackTrace();
      return ResultVo.error(e.getMessage());
    }
  }
}
