package com.jf.projects.zmt.vo.pig;

/**
 * 生猪及屠宰总数（用于统计一年内生猪及屠宰总数的折线图）
 * @author dqh
 *
 */
public class CountNumVo {
	/* 生猪总数 */
	private String pigNum;
	/* 屠宰总数 */
	private String slaughterNum;
	public String getPigNum() {
		return pigNum;
	}
	public void setPigNum(String pigNum) {
		this.pigNum = pigNum;
	}
	public String getSlaughterNum() {
		return slaughterNum;
	}
	public void setSlaughterNum(String slaughterNum) {
		this.slaughterNum = slaughterNum;
	}
	
}
