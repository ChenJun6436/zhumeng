package com.zmt.zmtofficialwebsite.util;

import com.github.tobato.fastdfs.domain.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import java.io.IOException;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

/**
 * 描述: 文件上传
 *
 * @author Administrator
 * @create 2018-01-09 9:46
 */
@Component
public class FastDFSClientWrapper {

  @Autowired
  private FastFileStorageClient storageClient;

  @Value("${fdfs.resthost}")
  private String resthost;

  /**
   * 文件上传
   *
   * @param file 文件
   * @return string
   */
  public String upload(MultipartFile file) throws IOException {
    StorePath path = storageClient
        .uploadFile(file.getInputStream(), file.getSize(), FilenameUtils.getExtension(file.getOriginalFilename()),
            null);
    return getResAccessUrl(path);
  }

  // 封装文件完整URL地址
  private String getResAccessUrl(StorePath storePath) {
    return "http://" + resthost + "/" + storePath.getFullPath();
  }
}
