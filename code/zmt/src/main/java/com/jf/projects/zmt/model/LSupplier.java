package com.jf.projects.zmt.model;

import java.util.Date;

/**
 * 供货商信息（猪贩子）
 * @author dqh
 *
 */
public class LSupplier {
	/**
	 * id
	 */
    private String id;

    /**
     * 进货单号
     */
    private String code;

    /**
     * 供货商名字
     */
    private String name;

    /**
     * 联系电话
     */
    private String tel;

    /**
     * 地址
     */
    private String address;

    /**
     * 生猪数量
     */
    private Integer pigNum;

    /**
     * 生猪重量
     */
    private Double pigWeight;

    /**
     * 屠宰场id
     */
    private String slaughterId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 最后更新时间
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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