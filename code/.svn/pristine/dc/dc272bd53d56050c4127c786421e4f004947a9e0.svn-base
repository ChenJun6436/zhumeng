package com.zmt.zmtofficialwebsite.vo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class WebNewsVo {

	private Long id;
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date createTime;

	/**
	 * 新闻标题
	 */

	private String headline;

	/**
	 * 类型(1公司新闻,2行业新闻)
	 */

	private Integer type;

	/**
	 * 标题
	 */

	private String title;

	/**
	 * 关键字
	 */

	private String keywords;

	/**
	 * 描述
	 */

	private String description;

	/**
	 * 内容
	 */

	private String content;

	private String imgUrl;

	public Long getId() {
		return id;
	}

	public WebNewsVo() {
		super();
	}

	public WebNewsVo(Date createTime, String title, String content) {
		super();
		this.createTime = createTime;
		this.title = title;
		this.content = content;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getHeadline() {
		return headline;
	}

	public void setHeadline(String headline) {
		this.headline = headline;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

}
