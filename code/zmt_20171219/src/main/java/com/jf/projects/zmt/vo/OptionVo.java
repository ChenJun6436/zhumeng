package com.jf.projects.zmt.vo;

/**
 * 只返回id和名字 用于下拉框数据
 * @author dqh
 *
 */
public class OptionVo {

	/**
	 * id
	 */
	private String key; 
	
	/**
	 * 值
	 */
	private String value;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
