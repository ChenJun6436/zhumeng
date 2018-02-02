package com.jf.projects.zmt.model;

import java.util.Date;

/**
 * 
 * 
 * @className: andRoleResource
 * 
 * @description:角色资源
 * 
 * @author wzw
 * 
 * @date 2017年10月23日
 * 
 */
public class AndRoleResource {
	/**
	 * UUID
	 */
	private String id;
	/**
	 * 角色ID
	 */
	private String roleId;
	/**
	 * 资源ID
	 */
	private String resourceId;
	/**
	 * 生成时间
	 */
	private Date createTime;
	/**
	 * 操作人
	 */
	private String creator;
	/**
	 * 更新时间
	 */
	private Date updateTime;
	/**
	 * 0->查看使用权限；1->查看'
	 */
	private Integer type;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getResourceId() {
		return resourceId;
	}

	public void setResourceId(String resourceId) {
		this.resourceId = resourceId;
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

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}
}