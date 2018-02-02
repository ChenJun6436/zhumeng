package com.jf.projects.zmt.vo.farms;

import com.jf.projects.zmt.vo.RequestPageParam;

public class AppSearch extends RequestPageParam {
	private String id;
	private String beginDate;
	private String endDate;
	private String keyWords;
	private String pigType;
	private Integer pigStatus;

	public AppSearch() {
		super();
	}

	public String getPigType() {
		return pigType;
	}

	public void setPigType(String pigType) {
		this.pigType = pigType;
	}

	public Integer getPigStatus() {
		return pigStatus;
	}

	public void setPigStatus(Integer pigStatus) {
		this.pigStatus = pigStatus;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(String beginDate) {
		this.beginDate = beginDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getKeyWords() {
		return keyWords;
	}

	public void setKeyWords(String keyWords) {
		this.keyWords = keyWords;
	}

}
