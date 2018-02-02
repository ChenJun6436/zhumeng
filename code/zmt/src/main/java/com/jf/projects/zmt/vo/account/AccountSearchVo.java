package com.jf.projects.zmt.vo.account;

import com.jf.projects.zmt.vo.RequestPageParam;

/**
 * 账户管理查询参数
 * @author dqh
 *
 */
public class AccountSearchVo extends RequestPageParam {
	
	/**
	 * 关键字查询  
	 */
	private String keywords;
	
	/**
	 * 类型id
	 */
	private String typeId;
	
	/**
	 * 部门id
	 */
	private String departmentId;
	
	/**
	 * 角色id
	 */
	private String roleId;

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
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

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

}
