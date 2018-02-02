package com.jf.projects.zmt.model;

import java.util.Date;
/**
 * 
 * @className: SDepartment
 *
 * @description:部门
 *
 * @author wj
 *
 * @date 2017年10月23日下午3:48:30
 *
 */
public class SDepartment {
    /**
     * 主键UUID
     */
    private String id;
    /**
     * 部门编码
     */
    private String code;
    /**
     * 部门名称
     */
    private String name;
    /**
     * 联系方式
     */
    private String contact;
    /**
     * 负责人
     */
    private String chargePerson;
    /**
     * 生成时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;
    /**
     * 状态enable->启用；disable->禁用
     */
    private String status;
    /**
     * 部门类型主键
     */
    private String typeId;
    
    /**
     * 部门类型 1->管理；2->监控
     */
    private Integer type;
    
    


    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

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

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getChargePerson() {
        return chargePerson;
    }

    public void setChargePerson(String chargePerson) {
        this.chargePerson = chargePerson;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }
}