package com.jf.projects.zmt.vo.farms;

public class AppUpdateVo {
	/**
	 * 用户
	 */
	private String id;
	/**
	 * 用户名字
	 */
	private String name;
	/**
	 * 饲料
	 */
	private String food;

	public AppUpdateVo() {
		super();
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

	public String getFood() {
		return food;
	}

	public void setFood(String food) {
		this.food = food;
	}

}
