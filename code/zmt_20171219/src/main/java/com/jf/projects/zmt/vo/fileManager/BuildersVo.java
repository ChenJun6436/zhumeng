package com.jf.projects.zmt.vo.fileManager;

import java.io.Serializable;

public class BuildersVo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/*
	 * 建档者id
	 */
	private String id;
	/*
	 * 部门
	 */
	private String department;
	/*
	 * 角色
	 */
	private String role;
	/*
	 * 账号
	 */
	private String account;
	/*
	 * 电话
	 */
	private String phone;
	/*
	 * 建档者名字
	 */
	private String name;
	/*
	 * 建档者地址
	 */
	private String address;
	/*
	 * 建档者建立档案的总数
	 */
	private int archivesNumber;
	/*
	 * 建档者状态
	 */
	private String status;
	/**
	 * 省id
	 */
	private Integer provinceId;
	/* 市id */
	private Integer cityId;
	/* 区县id */
	private Integer districtId;
	/* 乡镇id */
	private Integer townId;
	/* 村id */
	private Integer villageId;

	public Integer getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(Integer provinceId) {
		this.provinceId = provinceId;
	}

	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public Integer getDistrictId() {
		return districtId;
	}

	public void setDistrictId(Integer districtId) {
		this.districtId = districtId;
	}

	public Integer getTownId() {
		return townId;
	}

	public void setTownId(Integer townId) {
		this.townId = townId;
	}

	public Integer getVillageId() {
		return villageId;
	}

	public void setVillageId(Integer villageId) {
		this.villageId = villageId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getArchivesNumber() {
		return archivesNumber;
	}

	public void setArchivesNumber(int archivesNumber) {
		this.archivesNumber = archivesNumber;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public BuildersVo() {
		super();
	}

	public BuildersVo(String id, String department, String role,
			String account, String phone, String name, String address,
			int archivesNumber, String status) {
		super();
		this.id = id;
		this.department = department;
		this.role = role;
		this.account = account;
		this.phone = phone;
		this.name = name;
		this.address = address;
		this.archivesNumber = archivesNumber;
		this.status = status;
	}

}
