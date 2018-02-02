package com.zmt.zmtofficialwebsite.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 描述: 图片
 *
 * @author Administrator
 * @create 2018-01-09 14:32
 */
@Entity
@Table(name = "t_image")
public class Image extends BaseMode {

  /**
   * 图片名称
   */
  @Column(name = "name")
  private String name;

  /**
   * 图片地址
   */
  @Column(name = "url")
  private String url;


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
