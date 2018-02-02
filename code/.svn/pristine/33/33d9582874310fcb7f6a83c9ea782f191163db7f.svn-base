package com.zmt.zmtofficialwebsite.vo;

import com.zmt.zmtofficialwebsite.model.ContactInformation;
import java.util.List;
import java.util.Map;

/**
 * 描述: 底部配置
 *
 * @author Administrator
 * @create 2018-01-15 15:20
 */
public class Home_BottomVo {

  /*
   * 联系座机
   */
  private String tel;
  /*
   * 联系人手机
   */
  private String phone;
  /*
   * 公司地址
   */
  private String addres;
  /*
   * 备案号
   */
  private String record;
  /*
   * 微信图片名字
   */
  private String wxName;
  /*
   * 微信图片地址
   */
  private String wxImg;
  /*
   * 微博图片名字
   */
  private String wbName;
  /*
   * 微博图片地址
   */
  private String wbImg;

  /**
   * 友情链接
   */
  private List<Map<String,String>> friendLink;

  public Home_BottomVo() {
  }

  public Home_BottomVo(ContactInformation information) {
    this.addres = information.getAddres();
    this.phone = information.getPhone();
    this.record = information.getRecord();
    this.tel = information.getTel();
    this.wbImg = information.getWbImg();
    this.wbName = information.getWbName();
    this.wxImg = information.getWxImg();
    this.wxName = information.getWxName();
  }

  public List<Map<String, String>> getFriendLink() {
    return friendLink;
  }

  public void setFriendLink(List<Map<String, String>> friendLink) {
    this.friendLink = friendLink;
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

  public String getAddres() {
    return addres;
  }

  public void setAddres(String addres) {
    this.addres = addres;
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
}
