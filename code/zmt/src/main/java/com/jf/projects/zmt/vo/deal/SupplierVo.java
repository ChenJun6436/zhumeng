package com.jf.projects.zmt.vo.deal;

import java.util.List;

/**
 * 供货商(猪贩子)信息 vo
 * @author dqh
 *
 */
public class SupplierVo {

	/* 进货单号 */
    private String code;
    /* 供货商名字 */
    private String name;
    /* 联系电话 */
    private String tel;
    /* 地址 */
    private String address;
    /* 生猪数量 */
    private Integer pigNum;
    /* 生猪重量 */
    private Double pigWeight;
    /* 屠宰场id */
    private String slaughterId;
    /* 车辆信息 */
    private List<CarInfoVo> cars;
    /* 车辆信息字符串 */
    private String carInfo;
    /* 用户id */
    private String userId;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getCarInfo() {
		return carInfo;
	}

	public void setCarInfo(String carInfo) {
		this.carInfo = carInfo;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getPigNum() {
		return pigNum;
	}

	public void setPigNum(Integer pigNum) {
		this.pigNum = pigNum;
	}

	public Double getPigWeight() {
		return pigWeight;
	}

	public void setPigWeight(Double pigWeight) {
		this.pigWeight = pigWeight;
	}

	public String getSlaughterId() {
		return slaughterId;
	}

	public void setSlaughterId(String slaughterId) {
		this.slaughterId = slaughterId;
	}

	public List<CarInfoVo> getCars() {
		return cars;
	}

	public void setCars(List<CarInfoVo> cars) {
		this.cars = cars;
	}
}
