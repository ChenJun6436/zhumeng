package com.jf.projects.zmt.model;

/**
 * 
 * 
 * @className: farms
 * 
 * @description:养殖场
 * 
 * @author wzw
 * 
 * @date 2017年10月23日
 * 
 */
public class Farms {
	/**
	 * 养殖场主键
	 */
	private String id;
	/**
	 * 养殖场名字
	 */

	private String farmsName;
	/**
	 * 养殖户ID
	 */
	private String farmerId;
	/**
	 * 养殖场地址
	 */
	private String farmsAdress;
	/**
	 * 养殖场类型 0 个体 1养殖场
	 */
	private Integer farmsType;
	/**
	 * 饲料名字
	 */
	private String food;

	public String getFood() {
		return food;
	}

	public void setFood(String food) {
		this.food = food;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFarmsName() {
		return farmsName;
	}

	public void setFarmsName(String farmsName) {
		this.farmsName = farmsName;
	}

	public String getFarmerId() {
		return farmerId;
	}

	public void setFarmerId(String farmerId) {
		this.farmerId = farmerId;
	}

	public String getFarmsAdress() {
		return farmsAdress;
	}

	public void setFarmsAdress(String farmsAdress) {
		this.farmsAdress = farmsAdress;
	}

	public Integer getFarmsType() {
		return farmsType;
	}

	public void setFarmsType(Integer farmsType) {
		this.farmsType = farmsType;
	}
}