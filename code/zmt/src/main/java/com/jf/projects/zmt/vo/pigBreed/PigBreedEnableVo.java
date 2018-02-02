package com.jf.projects.zmt.vo.pigBreed;

public class PigBreedEnableVo {
	/* id */
	private String id;
	/* 名称 */
	private String name;

	public PigBreedEnableVo() {
		super();
	}

	public PigBreedEnableVo(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
