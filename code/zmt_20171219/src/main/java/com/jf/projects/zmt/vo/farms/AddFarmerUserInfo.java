package com.jf.projects.zmt.vo.farms;

import com.jf.projects.zmt.vo.account.AddUserInfoVo;

public class AddFarmerUserInfo extends AddUserInfoVo {
	/**
	 * 0个人1企业
	 */
	private Integer farmType;
	/**
	 * 饲料
	 */
	private String feed;

	public AddFarmerUserInfo() {
		super();
	}

	public AddFarmerUserInfo(Integer farmType) {
		super();
		this.farmType = farmType;
	}

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

}
