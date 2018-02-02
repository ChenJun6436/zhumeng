package com.zmt.zmtofficialwebsite.service;

import java.io.IOException;
import org.springframework.web.multipart.MultipartFile;

public interface FileUploadService {

  /**
   * 文件上传
   *
   * @param file 文件信息
   * @return url 图片访问地址
   */
  String upload(MultipartFile file) throws IOException;
}
