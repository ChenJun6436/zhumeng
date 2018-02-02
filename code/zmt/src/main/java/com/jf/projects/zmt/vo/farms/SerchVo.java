package com.jf.projects.zmt.vo.farms;

import com.jf.projects.zmt.vo.RequestPageParam;

public class SerchVo extends RequestPageParam {
	private String purview;

	private String account;

	private String phone;

	private String typeId;

	private String departmentId;

	private String roleId;

	private String keyWords;

	private Integer farmType;

	public Integer getFarmType() {
		return farmType;
	}

	public void setFarmType(Integer farmType) {
		this.farmType = farmType;
	}

	public String getPurview() {
		return purview;
	}

	public void setPurview(String purview) {
		this.purview = purview;
	}

	public String getKeyWords() {
		return keyWords;
	}

	public void setKeyWords(String keyWords) {
		this.keyWords = keyWords;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
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
