package com.zmt.zmtofficialwebsite.service.impl;

import com.zmt.zmtofficialwebsite.service.FileUploadService;
import com.zmt.zmtofficialwebsite.util.FastDFSClientWrapper;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * 描述: 文件上传
 *
 * @author Administrator
 * @create 2018-01-09 9:56
 */
@Service
public class FileUploadServiceImpl implements FileUploadService {

  @Autowired
  private FastDFSClientWrapper wrapper;

  /**
   * 文件上传
   *
   * @param file 文件信息
   * @return url 图片访问地址
   */
  @Override
  public String upload(MultipartFile file) throws IOException {
    return wrapper.upload(file);
  }
}
