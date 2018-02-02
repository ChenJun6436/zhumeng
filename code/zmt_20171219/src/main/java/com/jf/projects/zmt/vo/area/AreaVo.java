package com.jf.projects.zmt.vo.area;

import java.util.List;

/**
 * 地址返回类
 * @author dqh
 *
 */
public class AreaVo {
	
	/**
	 * 地址id
	 */
	private String id;
	
	/**
	 * 地址名称
	 */
	private String name;
	
	/**
	 * 省份对下级的统计
	 */
	private Integer num;
	
	/**
	 * 子类
	 */
	private List<AreaVo> children;

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

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public List<AreaVo> getChildren() {
		return children;
	}

	public void setChildren(List<AreaVo> children) {
		this.children = children;
	}
}
