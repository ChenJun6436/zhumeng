package com.zmt.zmtofficialwebsite.vo;

import java.util.List;

/**
 * 前端传值实体信息
 *
 * @author wzw
 * @className:
 * @description:
 * @date 2018年1月11日
 */
public class FormVo {

  /**
   * 底部信息id
   */
  private Long id;
  /**
   * 座机
   */
  private String tel;
  /**
   * 联系手机
   */
  private String phone;
  /**
   * 联系地址
   */
  private String address;
  /**
   * 备案号
   */
  private String record;
  /**
   * 微信图片名字
   */
  private String wxName;
  /**
   * 微信图片地址
   */
  private String wxImg;
  /**
   * 微博图片名字
   */
  private String wbName;
  /**
   * 微博图片地址
   */
  private String wbImg;
  /**
   * 链接集合
   */
  private List<Links> liksList;

  public FormVo() {
    super();

  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTel() {
    return tel;
  }

  public void setTel(String tel) {
    this.tel = tel;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getRecord() {
    return record;
  }

  public void setRecord(String record) {
    this.record = record;
  }

  public String getWxName() {
    return wxName;
  }

  public void setWxName(String wxName) {
    this.wxName = wxName;
  }

  public String getWxImg() {
    return wxImg;
  }

  public void setWxImg(String wxImg) {
    this.wxImg = wxImg;
  }

  public String getWbName() {
    return wbName;
  }

  public void setWbName(String wbName) {
    this.wbName = wbName;
  }

  public String getWbImg() {
    return wbImg;
  }

  public void setWbImg(String wbImg) {
    this.wbImg = wbImg;
  }

  public List<Links> getLiksList() {
    return liksList;
  }

  public void setLiksList(List<Links> liksList) {
    this.liksList = liksList;
  }
}
