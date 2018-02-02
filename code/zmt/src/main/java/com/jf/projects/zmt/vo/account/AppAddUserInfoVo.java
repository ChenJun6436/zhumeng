package com.jf.projects.zmt.vo.account;

/**
 * app 生猪建档app新建养殖户用户vo
 * 
 * @author dqh
 * 
 */
public class AppAddUserInfoVo {

	/* 姓名 */
	private String name;
	/* 电话 */
	private String tel;
	/* 省id */
	private Integer provinceId;
	/* 市id */
	private Integer cityId;
	/* 区县id */
	private Integer districtId;
	/* 乡镇id */
	private Integer townId;
	/* 村id */
	private Integer villageId;
	/* 当前登录用户 */
	private String currentUserId;
	/**
	 * 0个人1企业
	 */
	private Integer farmType;
	/**
	 * 饲料
	 */
	private String feed;

	public Integer getFarmType() {
		return farmType;
	}

	public void setFarmType(Integer farmType) {
		this.farmType = farmType;
	}

	public String getFeed() {
		return feed;
	}

	public void setFeed(String feed) {
		this.feed = feed;
	}

	public String getCurrentUserId() {
		return currentUserId;
	}

	public void setCurrentUserId(String currentUserId) {
		this.currentUserId = currentUserId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
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
