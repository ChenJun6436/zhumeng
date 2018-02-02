package com.zmt.zmtofficialwebsite.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;

/**
 * 描述: 首页新闻查询
 *
 * @author Administrator
 * @create 2018-01-15 14:40
 */
public class Home_NewsVo {

  private Long id;

  private String title;

  private String description;

  @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
  private Date createTime;

  private String imgUrl;

  public Home_NewsVo(Long id, String title, String description, Date createTime, String imgUrl) {
    this.id = id;
    this.title = title;
    this.description = description;
    this.createTime = createTime;
    this.imgUrl = imgUrl;
  }

  public Home_NewsVo() {
    super();
  }

  public String getImgUrl() {
    return imgUrl;
  }

  public void setImgUrl(String imgUrl) {
    this.imgUrl = imgUrl;
  }


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }
}
