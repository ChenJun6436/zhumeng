package com.zmt.zmtofficialwebsite.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;

/**
 * 描述: 图片
 *
 * @author Administrator
 * @create 2018-01-09 15:12
 */
public class ImageVo {

  /**
   * id
   */
  private Long id;

  /**
   * 图片名
   */
  private String name;

  /**
   * 地址
   */
  private String url;

  /**
   * 修改时间
   */
  @JsonFormat(pattern = "yyyy-MM-dd HH:ss:mm", timezone = "GMT+8")
  private Date lastUpdateTime;

  public ImageVo() {
  }

  public ImageVo(Long id, String name, String url, Date lastUpdateTime) {
    this.id = id;
    this.name = name;
    this.url = url;
    this.lastUpdateTime = lastUpdateTime;
  }

  public Date getLastUpdateTime() {
    return lastUpdateTime;
  }

  public void setLastUpdateTime(Date lastUpdateTime) {
    this.lastUpdateTime = lastUpdateTime;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }
}
