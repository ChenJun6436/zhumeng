package com.jf.projects.zmt.vo.fileManager;

import com.jf.projects.zmt.vo.RequestPageParam;

public class FileSearch extends RequestPageParam {
	private String sign;
	private String name;
	private String keyWords;
	private String userId;

	public FileSearch() {
		super();
	}

	public FileSearch(String sign, String name, String userId) {
		super();
		this.sign = sign;
		this.name = name;
		this.userId = userId;
	}

	public FileSearch(String keyWords, String userId) {
		super();
		this.keyWords = keyWords;
		this.userId = userId;
	}

	public String getKeyWords() {
		return keyWords;
	}

	public void setKeyWords(String keyWords) {
		this.keyWords = keyWords;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public String getSign() {
		return sign;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

}
