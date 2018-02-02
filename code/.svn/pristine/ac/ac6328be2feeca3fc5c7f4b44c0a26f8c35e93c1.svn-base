package com.zmt.zmtofficialwebsite.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 
 * 
 * @className:
 * 
 * @description:友情链接实体
 * 
 * @author wzw
 * 
 * @date 2018年1月10日
 * 
 */
@Entity
@Table(name = "friend_link")
public class FriendLink extends BaseMode {
	/*
	 * 链接名字
	 */
	@Column(name = "name", length = 10)
	private String name;
	/*
	 * 链接Url
	 */
	@Column(name = "url", length = 32)
	private String url;
	/**
	 * 前端能否编辑标志 true
	 */
	@Column(name = "falg", length = 10)
	private String falg;

	public String getFalg() {
		return falg;
	}

	public void setFalg(String falg) {
		this.falg = falg;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
