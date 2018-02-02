package com.jf.projects.zmt.vo.area;

/**
 * 树行vo
 * @author dev
 *
 */
public class ZtreeVo {
	
	/**
	 * 区域id
	 */
	private String id;
	
	/**
	 * 显示名称
	 */
	private String name;
	
	/**
	 * 层级
	 */
	private Integer type;
	
	/**
	 * 是否还有子级
	 */
	private Boolean lean;

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

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Boolean getLean() {
		return lean;
	}

	public void setLean(Boolean lean) {
		this.lean = lean;
	}

}
