package com.zmt.zmtofficialwebsite.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 
 * 
 * @className:
 * 
 * @description:seo
 * 
 * @author wzw
 * 
 * @date 2018年1月10日
 * 
 */
@Entity
@Table(name = "seo_info")
public class SeoInfo extends BaseMode {
	/*
	 * 官网首页标题
	 */
	@Column(name = "title", length = 100)
	private String title;
	/*
	 * 关键字
	 */
	@Column(name = "keywords", length = 200)
	private String keywords;
	/*
	 * 描述
	 */
	@Column(name = "description", length = 400)
	private String description;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
