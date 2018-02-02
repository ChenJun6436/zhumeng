package com.jf.projects.zmt.model;

import java.util.Date;

/**
 * 
 * 
 * @className:PigBreed
 * 
 * @description:生猪品种
 * 
 * @author wzw
 * 
 * @date 2017年10月23日
 * 
 */
public class PigBreed {
	/**
	 * uuid
	 */
	private String id;
	/**
	 * 生成时间
	 */
	private Date createTime;
	/**
	 * 更新时间
	 */
	private Date updateTime;
	/**
	 * 品种名称
	 */
	private String name;
	/**
	 * 状态 enable>启用 disable>禁用
	 */
	private String status;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}