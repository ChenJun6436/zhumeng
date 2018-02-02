package com.jf.projects.zmt.vo.pigBreed;

/**
 * 生猪品种返回vo
 * @author dqh
 *
 */
public class PigBreedVo {
	/* id */
	private String id;
	/* 名称 */
	private String name;
	/* 创建时间 */
	private String createTime;
	/* 状态 */
	private String status;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

}
