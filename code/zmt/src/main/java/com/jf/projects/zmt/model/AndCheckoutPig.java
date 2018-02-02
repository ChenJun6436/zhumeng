package com.jf.projects.zmt.model;

import java.util.Date;

/**
 * @className: andCheckoutPig
 * @description:检查和猪 中间表
 * @author wzw
 * @date 2017年10月23日
 */
public class AndCheckoutPig {
    /**
     * 主键
     */
    private String id;

    /**
     * 检查表id
     */
    private String userId;

    /**
     * 猪ids
     */
    private String pigId;

    /**
     * 存活状态 0.死亡1.正常
     */
    private Integer survivalState;

    /**
     * 是否处理 0不处理 1处理',
     */
    private Integer quarantineResult;

    /**
     * 检疫结果 0 不正常 1正常
     */
    private Integer isDispose;

    /**
     * 描述
     */
    private String describe;

    /**
     * 备注
     */
    private String remark;

    /**
     * 疫苗
     */
    private String vaccine;

    /**
     * 生成时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    private Integer type;

    /**
     * 检查类型 1常规检查2宰前检查3宰后检查
     */
    private Integer checkType;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPigId() {
        return pigId;
    }

    public void setPigId(String pigId) {
        this.pigId = pigId;
    }

    public Integer getSurvivalState() {
        return survivalState;
    }

    public void setSurvivalState(Integer survivalState) {
        this.survivalState = survivalState;
    }

    public Integer getQuarantineResult() {
        return quarantineResult;
    }

    public void setQuarantineResult(Integer quarantineResult) {
        this.quarantineResult = quarantineResult;
    }

    public Integer getIsDispose() {
        return isDispose;
    }

    public void setIsDispose(Integer isDispose) {
        this.isDispose = isDispose;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getVaccine() {
        return vaccine;
    }

    public void setVaccine(String vaccine) {
        this.vaccine = vaccine;
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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getCheckType() {
        return checkType;
    }

    public void setCheckType(Integer checkType) {
        this.checkType = checkType;
    }

}