package com.jf.projects.zmt.vo.pig;

/**
 * 
 * @ClassName: OverviewTypeVO
 *
 * @Description:总览数据
 *
 * @author wj
 *
 * @date 2018年1月10日
 *
 */
public class OverviewTypeVO {
	/**
	 * 名称
	 */
	private String name;
	/**
	 * 数量
	 */
	private String num;
	/**
	 * 类型 ,up->同比上升;down->同比下降
	 */
	private String type;
	/**
	 * 百分比
	 */
	private String percentage;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getPercentage() {
		return percentage;
	}
	public void setPercentage(String percentage) {
		this.percentage = percentage;
	}
	
	
	
}
