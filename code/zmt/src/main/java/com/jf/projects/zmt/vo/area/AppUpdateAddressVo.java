package com.jf.projects.zmt.vo.area;

/**
 * App修改用户id userId为必传
 * @author dqh
 *
 */
public class AppUpdateAddressVo {
	/* userId */
	private String userId;
	/* 省份id */
	private Integer provinceId;
	/* 市id */
	private Integer cityId;
	/* 区县id */
	private Integer districtId;
	/* 镇id */
	private Integer townId;
	/* 村id */
	private Integer villageId;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
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
	
}
