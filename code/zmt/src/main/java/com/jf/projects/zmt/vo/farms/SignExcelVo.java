package com.jf.projects.zmt.vo.farms;

public class SignExcelVo {
	/**
	 * 主键
	 */
	private String id;
	/**
	 * 地址
	 */
	private String address;
	/**
	 * excel 保存地址
	 */
	private String url;
	/**
	 * 创建时间
	 */
	private String createTime;

	public SignExcelVo() {
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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

}
