package com.jf.projects.zmt.model;

import java.util.Date;

/**
 * 
 * 
 * @className: PigCheck
 * 
 * @description:生猪检查
 * 
 * @author wzw
 * 
 * @date 2017年10月23日
 * 
 */
public class PigCheck {
	/**
	 * 主键
	 */
	private String id;
	/**
	 * 检查类型 检查类型1入场2屠宰前3屠宰后
	 */
	private Integer checkType;
	/**
	 * 检查状态0未通过1通过
	 */
	private Integer checkStatus;
	/**
	 * 处理状态0未处理1处理
	 */
	private Integer dealwith;
	/**
	 * 处理方法
	 */
	private String dealmethod;
	/**
	 * 检查人id
	 */
	private String checkPeopleId;
	/**
	 * 检查时间
	 */
	private Date checkTime;
	/**
	 * 生猪唯一标志
	 */
	private String pigSign;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getCheckType() {
		return checkType;
	}

	public void setCheckType(Integer checkType) {
		this.checkType = checkType;
	}

	public Integer getCheckStatus() {
		return checkStatus;
	}

	public void setCheckStatus(Integer checkStatus) {
		this.checkStatus = checkStatus;
	}

	public Integer getDealwith() {
		return dealwith;
	}

	public void setDealwith(Integer dealwith) {
		this.dealwith = dealwith;
	}

	public String getDealmethod() {
		return dealmethod;
	}

	public void setDealmethod(String dealmethod) {
		this.dealmethod = dealmethod;
	}

	public String getCheckPeopleId() {
		return checkPeopleId;
	}

	public void setCheckPeopleId(String checkPeopleId) {
		this.checkPeopleId = checkPeopleId;
	}

	public Date getCheckTime() {
		return checkTime;
	}

	public void setCheckTime(Date checkTime) {
		this.checkTime = checkTime;
	}

	public String getPigSign() {
		return pigSign;
	}

	public void setPigSign(String pigSign) {
		this.pigSign = pigSign;
	}
}