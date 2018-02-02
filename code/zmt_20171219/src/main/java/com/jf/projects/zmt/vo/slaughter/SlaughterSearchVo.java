package com.jf.projects.zmt.vo.slaughter;

import com.jf.projects.zmt.vo.RequestPageParam;

public class SlaughterSearchVo extends RequestPageParam {
	private String keyWords;
	private String typeId;
	private String id;
	private String account;

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getKeyWords() {
		return keyWords;
	}

	public void setKeyWords(String keyWords) {
		this.keyWords = keyWords;
	}

	public String getTypeId() {
		return typeId;
	}

	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
