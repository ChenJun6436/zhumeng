package com.jf.projects.zmt.model;

import java.util.Date;

/**
 * @className: Checkout
 * @description:检验表
 * @author wzw
 * @date 2017年10月23日
 */
public class Checkout {
    /**
     * UUID
     */
    private String id;

    /**
     * 生成时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 操作者id
     */
    private String operaterId;

    /**
     * 猪id
     */
    private String pigId;

    /**
     * 类型 0.生猪检查 1接种疫苗 2生猪处理
     */
    private Integer type;

    /**
     * 类型 0.生猪检查 1接种疫苗 2生猪处理
     */
    private Integer checkType;

    /**
     * 检疫结果 0 不正常 1正常
     */

    private Integer quarantineResult;

    /**
     * 是否处理 0不处理 1处理',
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getPigId() {
        return pigId;
    }

    public void setPigId(String pigId) {
        this.pigId = pigId;
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

    public String getOperaterId() {
        return operaterId;
    }

    public void setOperaterId(String operaterId) {
        this.operaterId = operaterId;
    }

}