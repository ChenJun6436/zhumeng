package com.jf.projects.zmt.model;

import java.util.Date;

/**
 * 
 * 
 * @className: brand
 * 
 * @description:生猪唯一标志
 * 
 * @author wzw
 * 
 * @date 2017年10月23日
 * 
 */
public class Brand {
	/**
	 * 主键
	 */
	private String id;
	/**
	 * 生猪唯一标志
	 */
	private String sign;
	/**
	 * 0未激活1以激活
	 */
	private Integer signStatus;
	/**
	 * 激活标签者id
	 */
	private String createrId;
	/**
	 * 标签激活时间
	 */
	private Date createTime;
	/**
	 * 标签修改时间
	 */
	private Date updateTime;

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

	public Integer getSignStatus() {
		return signStatus;
	}

	public void setSignStatus(Integer signStatus) {
		this.signStatus = signStatus;
	}

	public String getCreaterId() {
		return createrId;
	}

	public void setCreaterId(String createrId) {
		this.createrId = createrId;
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