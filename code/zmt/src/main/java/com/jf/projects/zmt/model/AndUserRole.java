package com.jf.projects.zmt.model;

import java.util.Date;

/**
 * 
 * 
 * @className: andUserRole
 * 
 * @description:用户角色
 * 
 * @author wzw
 * 
 * @date 2017年10月23日
 * 
 */
public class AndUserRole {
	/**
	 * UUID
	 */
	private String id;
	/**
	 * 用户ID
	 */
	private String userId;
	/**
	 * 用户角色ID
	 */
	private String roleId;
	/**
	 * 生成时间
	 */
	private Date createTime;
	/**
	 * 更新时间
	 */
	private Date updateTime;
	/**
	 * 操作人
	 */
	private String creator;

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

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
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

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}
}