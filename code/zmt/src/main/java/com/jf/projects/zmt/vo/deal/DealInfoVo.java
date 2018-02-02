package com.jf.projects.zmt.vo.deal;

/**
 * 出入库列表信息
 * @author dqh
 *
 */
public class DealInfoVo {
	/* id */
	private String id;
	/* 单据标号 */
	private String code;
	/* 供货商或批发商名字 */
	private String merchantName;
	/* 联系电话 */
	private String tel;
	/* 生猪数量 */
	private Integer pigNum;
	/* 生猪重量 */
	private Double pigWeight;
	/* 车辆数量 */
	private Integer carNum = 0;
	/* 时间 */
	private String createTime;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMerchantName() {
		return merchantName;
	}
	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
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
	public Integer getCarNum() {
		return carNum;
	}
	public void setCarNum(Integer carNum) {
		this.carNum = carNum;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	
}
