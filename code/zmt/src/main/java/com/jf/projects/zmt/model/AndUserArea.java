package com.jf.projects.zmt.model;

import java.util.Date;

/**
 * 
 * 
 * @className: andUserArea
 * 
 * @description:用户管理区域
 * 
 * @author wzw
 * 
 * @date 2017年10月23日
 * 
 */
public class AndUserArea {
	/**
	 * UUID
	 */
	private String id;
	/**
	 * 用户ID
	 */
	private String userId;
	/**
	 * 区域ID
	 */
	private Integer areaId;
	/**
	 * 区域名称
	 */
	private String areaName;
	/**
	 * 所属级别1->省级2->市级3->区级,4-镇级，5-乡级
	 */
	private Integer areaType;
	/**
	 * 生成日期
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

	public Integer getAreaId() {
		return areaId;
	}

	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public Integer getAreaType() {
		return areaType;
	}

	public void setAreaType(Integer areaType) {
		this.areaType = areaType;
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