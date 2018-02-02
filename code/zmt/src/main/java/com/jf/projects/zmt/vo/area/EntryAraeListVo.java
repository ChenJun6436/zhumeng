package com.jf.projects.zmt.vo.area;

/**
 * 地址分页vo
 * @author dqh
 * 用于展示地址管理分页数据
 *
 */
public class EntryAraeListVo {

	/* 乡村id */
	private Integer villageId;
	/* 省份名称 */
	private String provinceName;
	/* 市名称 */
	private String cityName;
	/* 区县名称 */
	private String districtName;
	/* 镇名称 */
	private String townName;
	/* 乡村名称 */
	private String villageName;
	/* 状态 */
	private String status;
	/* 省id */
	private String provinceId;
	/* 市id */
	private String cityId;
	/* 区县id */
	private String districtId;
	/* 镇id */
	private String townId;
	
	public String getProvinceId() {
		return provinceId;
	}
	public void setProvinceId(String provinceId) {
		this.provinceId = provinceId;
	}
	public String getCityId() {
		return cityId;
	}
	public void setCityId(String cityId) {
		this.cityId = cityId;
	}
	public String getDistrictId() {
		return districtId;
	}
	public void setDistrictId(String districtId) {
		this.districtId = districtId;
	}
	public String getTownId() {
		return townId;
	}
	public void setTownId(String townId) {
		this.townId = townId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Integer getVillageId() {
		return villageId;
	}
	public void setVillageId(Integer villageId) {
		this.villageId = villageId;
	}
	public String getProvinceName() {
		return provinceName;
	}
	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getDistrictName() {
		return districtName;
	}
	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}
	public String getTownName() {
		return townName;
	}
	public void setTownName(String townName) {
		this.townName = townName;
	}
	public String getVillageName() {
		return villageName;
	}
	public void setVillageName(String villageName) {
		this.villageName = villageName;
	}
}
