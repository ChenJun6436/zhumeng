package com.jf.projects.zmt.model;

import java.util.Date;

/**
 * 
 * 
 * @className: PigFile
 * 
 * @description:生猪档案
 * 
 * @author wzw
 * 
 * @date 2017年10月23日
 * 
 */
public class PigFile {
	/**
	 * 主键
	 */
	private String id;
	/**
	 * 生猪唯一标志
	 */
	private String pigId;
	/**
	 * 养殖户id
	 */
	private String famerId;
	/**
	 * 生猪类型
	 */
	private String pigType;
	/**
	 * 备注
	 */
	private String mark;
	/**
	 * 生猪状态0死亡1正常 2已售
	 */
	private Integer pigStatus;
	/**
	 * 创建人id
	 */
	private String createPeopleId;
	/**
	 * 屠宰场id
	 */
	private String slaughterhouseId;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 修改时间
	 */
	private Date updateTime;
	
	/**
	 * 销售市场id
	 */
	private String marketId;

	public String getMarketId() {
		return marketId;
	}

	public void setMarketId(String marketId) {
		this.marketId = marketId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPigId() {
		return pigId;
	}

	public void setPigId(String pigId) {
		this.pigId = pigId;
	}

	public String getFamerId() {
		return famerId;
	}

	public void setFamerId(String famerId) {
		this.famerId = famerId;
	}

	public String getPigType() {
		return pigType;
	}

	public void setPigType(String pigType) {
		this.pigType = pigType;
	}

	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	public Integer getPigStatus() {
		return pigStatus;
	}

	public void setPigStatus(Integer pigStatus) {
		this.pigStatus = pigStatus;
	}

	public String getCreatePeopleId() {
		return createPeopleId;
	}

	public void setCreatePeopleId(String createPeopleId) {
		this.createPeopleId = createPeopleId;
	}

	public String getSlaughterhouseId() {
		return slaughterhouseId;
	}

	public void setSlaughterhouseId(String slaughterhouseId) {
		this.slaughterhouseId = slaughterhouseId;
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
}