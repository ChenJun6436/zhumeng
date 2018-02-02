package com.jf.projects.zmt.vo.user;

public class UserInfoVo {
	/**
	 * 用户id
	 */
	private String id;
	/**
	 * 地址
	 */
	private String address;
	/**
	 * 姓名
	 */
	private String name;

	public UserInfoVo() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
