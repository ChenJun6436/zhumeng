package com.jf.projects.zmt.model;

import java.util.Date;

/**
 * 销售商（肉贩子）
 * @author dqh
 *
 */
public class LWholesaler {
	/**
	 * id
	 */
    private String id;

    /**
     * 出货单号
     */
    private String code;

    /**
     * 商家名字
     */
    private String name;

    /**
     * 联系方式
     */
    private String tel;

    /**
     * 商家地址
     */
    private String companyAddress;

    /**
     * 生猪数量
     */
    private Integer pigNum;

    /**
     * 生猪重量
     */
    private Double pigWeight;

    /**
     * 销售地址
     */
    private String saleAddress;

    /**
     * 屠宰场id
     */
    private String slaughterId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    public Integer getPigNum() {
        return pigNum;
    }

    public void setPigNum(Integer pigNum) {
        this.pigNum = pigNum;
    }

    public Double getPigWeight() {
        return pigWeight;
    }

    public void setPigWeight(Double pigWeight) {
        this.pigWeight = pigWeight;
    }

    public String getSaleAddress() {
        return saleAddress;
    }

    public void setSaleAddress(String saleAddress) {
        this.saleAddress = saleAddress;
    }

    public String getSlaughterId() {
        return slaughterId;
    }

    public void setSlaughterId(String slaughterId) {
        this.slaughterId = slaughterId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}