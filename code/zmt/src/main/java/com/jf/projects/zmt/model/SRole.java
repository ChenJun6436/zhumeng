package com.jf.projects.zmt.model;

import java.util.Date;
/**
 * 
 * @className: SRole
 *
 * @description:角色
 *
 * @author wj
 *
 * @date 2017年10月23日下午3:53:52
 *
 */
public class SRole {
    /**
     * 主键UUID
     */
    private String id;
    /**
     * 角色名称
     */
    private String name;
    /**
     * 类型主键
     */
    private String typeId;
    /**
     * 部门主键
     */
    private String departmentId;
    /**
     * 生成日期
     */
    private Date createTime;
    /**
     * 生成者
     */
    private String creator;
    /**
     * 更新时间
     */
    private Date updateTime;
    /**
     * 状态enable->启用；disable->禁用
     */
    private String status;
    
    /**
     * 角色代码
     */
    private String code;

    public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
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
}