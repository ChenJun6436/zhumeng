package com.jf.projects.zmt.vo.farms;

public class AppFileOfFamerVo {
	/**
	 * 档案主键
	 */
	private String id;
	/**
	 * 生猪标签
	 */
	private String sign;
	/**
	 * 生猪状态
	 */
	private Integer pigStatus;
	/**
	 * 生猪类型
	 */
	private String pigType;
	/**
	 * 时间
	 */
	private String createTime;

	public AppFileOfFamerVo() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public Integer getPigStatus() {
		return pigStatus;
	}

	public void setPigStatus(Integer pigStatus) {
		this.pigStatus = pigStatus;
	}

	public String getPigType() {
		return pigType;
	}

	public void setPigType(String pigType) {
		this.pigType = pigType;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

}
