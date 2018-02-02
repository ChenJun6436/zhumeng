package com.jf.projects.zmt.vo.account;

/**
 * 根据用户id返回用户管理区域id
 * @author dev
 *
 */
public class UserAreaVo {

	/**
	 * 区域id
	 */
	private Integer areaId;
	
	/**
	 * 区域名称
	 */
	private String areaName;
	
	/**
	 * 所属级别1->省级2->市级3->区级,4-镇级，5-乡级
	 */
	private Integer type;
	
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

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public Integer getAreaId() {
		return areaId;
	}

	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}
}
