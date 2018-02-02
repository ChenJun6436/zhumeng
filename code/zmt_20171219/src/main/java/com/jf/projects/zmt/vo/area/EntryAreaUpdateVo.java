package com.jf.projects.zmt.vo.area;

/**
 * 乡镇修改vo
 * @author dev
 *
 */
public class EntryAreaUpdateVo {

	/* 村id */
	private Integer villageId;
	/* 村名称 */
	private String villageName;
	/* 乡镇id */
	private Integer townId;
	/* 乡镇名称 */
	private String townName;
	/* 区县id */
	private Integer districtId;
	
	public Integer getDistrictId() {
		return districtId;
	}
	public void setDistrictId(Integer districtId) {
		this.districtId = districtId;
	}
	public Integer getVillageId() {
		return villageId;
	}
	public void setVillageId(Integer villageId) {
		this.villageId = villageId;
	}
	public String getVillageName() {
		return villageName;
	}
	public void setVillageName(String villageName) {
		this.villageName = villageName;
	}
	public Integer getTownId() {
		return townId;
	}
	public void setTownId(Integer townId) {
		this.townId = townId;
	}
	public String getTownName() {
		return townName;
	}
	public void setTownName(String townName) {
		this.townName = townName;
	}
}
