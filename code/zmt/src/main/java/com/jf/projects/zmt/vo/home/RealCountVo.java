package com.jf.projects.zmt.vo.home;

/**
 * 实时数据
 * @author dqh
 *
 */
public class RealCountVo {
	
	/**
	 * 生猪总数
	 */
	private Integer number;
	
	/**
	 * 今日建档数量
	 */
	private Integer archivesNumbers;
	
	/**
	 * 今日屠宰数量
	 */
	private Integer slaughterNumbers;
	
	/**
	 * 今日销售数量
	 */
	private Integer sellNumbers;

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Integer getArchivesNumbers() {
		return archivesNumbers;
	}

	public void setArchivesNumbers(Integer archivesNumbers) {
		this.archivesNumbers = archivesNumbers;
	}

	public Integer getSlaughterNumbers() {
		return slaughterNumbers;
	}

	public void setSlaughterNumbers(Integer slaughterNumbers) {
		this.slaughterNumbers = slaughterNumbers;
	}

	public Integer getSellNumbers() {
		return sellNumbers;
	}

	public void setSellNumbers(Integer sellNumbers) {
		this.sellNumbers = sellNumbers;
	}

}
