package com.zmt.zmtofficialwebsite.vo;

/**
 * 描述: 首页seo配置
 *
 * @author Administrator
 * @create 2018-01-15 14:58
 */
public class Home_SeoVo {

  /*
   * 官网首页标题
   */
  private String title;

  /*
   * 关键字
   */
  private String keywords;

  /*
   * 描述
   */
  private String description;

  public Home_SeoVo() {
  }

  public Home_SeoVo(String title, String keywords, String description) {
    this.title = title;
    this.keywords = keywords;
    this.description = description;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getKeywords() {
    return keywords;
  }

  public void setKeywords(String keywords) {
    this.keywords = keywords;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }
}
