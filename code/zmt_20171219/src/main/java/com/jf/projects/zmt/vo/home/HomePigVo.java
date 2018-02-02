package com.jf.projects.zmt.vo.home;

import org.codehaus.jackson.annotate.JsonIgnore;

public class HomePigVo {
	/* 生猪id */
	private String pigId;
	/* 生猪唯一标识 */
	private String pigNo;
	/* 品种 */
	private String pigBreed;
	/* 状态 */
	private String status;
	/* 建档地址 */
	private String address;
	/* 养殖场 */
	private String farmName;
	/* 屠宰场 */
	private String slaughter;
	/* 销售市场 */
	private String market;
	/* 建档人id */
	@JsonIgnore
	private String createPersonId;
	
	public String getCreatePersonId() {
		return createPersonId;
	}
	public void setCreatePersonId(String createPersonId) {
		this.createPersonId = createPersonId;
	}
	public String getPigId() {
		return pigId;
	}
	public void setPigId(String pigId) {
		this.pigId = pigId;
	}
	public String getPigNo() {
		return pigNo;
	}
	public void setPigNo(String pigNo) {
		this.pigNo = pigNo;
	}
	public String getPigBreed() {
		return pigBreed;
	}
	public void setPigBreed(String pigBreed) {
		this.pigBreed = pigBreed;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getFarmName() {
		return farmName;
	}
	public void setFarmName(String farmName) {
		this.farmName = farmName;
	}
	public String getSlaughter() {
		return slaughter;
	}
	public void setSlaughter(String slaughter) {
		this.slaughter = slaughter;
	}
	public String getMarket() {
		return market;
	}
	public void setMarket(String market) {
		this.market = market;
	}

}
