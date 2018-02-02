package com.zmt.zmtofficialwebsite.controller;

import com.zmt.zmtofficialwebsite.service.FileUploadService;
import com.zmt.zmtofficialwebsite.util.result.ResultVo;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

/**
 * 描述: 文件上传
 *
 * @author dengpeng
 * @create 2018-01-08 17:37
 */
@RestController
public class FileUploadController {

  @Autowired
  private FileUploadService uploadService;

  /**
   * 图片上传
   *
   * @return ResultVo
   */
  @RequestMapping("/upload/file")
  @ResponseBody
  public ResultVo upload(HttpServletRequest request) {
    try {
      // 创建一个通用的多部分解析器
      CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
          request.getSession().getServletContext());
      // 判断 request 是否有文件上传,即多部分请求
      if (multipartResolver.isMultipart(request)) {
        // 转换成多部分request
        MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
        // 取得request中的所有文件名
        Iterator<String> iter = multiRequest.getFileNames();
        while (iter.hasNext()) {
          // 取得上传文件
          MultipartFile file = multiRequest.getFile(iter.next());
          if (null != file) {
            String url = uploadService.upload(file);
            return new ResultVo(url);
          }
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
      return ResultVo.error(e.getMessage());
    }
    return ResultVo.error("参数错误");
  }

  /**
   * 编辑器图片上传
   *
   * @return ResultVo
   */
  @RequestMapping("/upload/editor")
  @ResponseBody
  public Map<Object, Object> uploadByEditor(HttpServletRequest request) {
    Map<Object, Object> map = new HashMap<>();
    try {
      // 创建一个通用的多部分解析器
      CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
          request.getSession().getServletContext());
      // 判断 request 是否有文件上传,即多部分请求
      if (multipartResolver.isMultipart(request)) {
        // 转换成多部分request
        MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
        // 取得request中的所有文件名
        Iterator<String> iter = multiRequest.getFileNames();
        while (iter.hasNext()) {
          // 取得上传文件
          MultipartFile file = multiRequest.getFile(iter.next());
          if (null != file) {
            String url = uploadService.upload(file);
            map.put("errno", 0);
            map.put("data", Collections.singletonList(url));
          }
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
      map.put("errno", -1);
    }
    return map;
  }

}
