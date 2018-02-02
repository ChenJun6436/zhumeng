package com.jf.projects.zmt.vo.inspection;

public class InspectionListVo {
	private String id;

	/**
	 * 检验中心名称
	 */
	private String name;

	/**
	 * 检验中心地址
	 */
	private String address;

	/**
	 * 检验中心联系方式
	 */
	private String phone;

	/**
	 * 负责人名字
	 */
	private String principalName;

	private Long number;

	/**
	 * 省id
	 */
	protected Integer provinceId;

	/**
	 * 市id
	 */
	protected Integer cityId;

	/**
	 * 区县id
	 */
	protected Integer districtId;

	/**
	 * 乡镇id
	 */
	protected Integer townId;

	/**
	 * 村id
	 */
	protected Integer villageId;

	/**
	 * 创建人
	 */
	private String creatorId;

	/**
	 * 建号人名
	 */
	private String creatorName;

	/**
	 * 建号时间
	 */
	private String creatorTime;

	/**
	 * 状态enable->启用；disable->禁用
	 */
	private String status;
	/**
	 * 该检验中心账户数
	 */
	private Integer total;

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public InspectionListVo() {
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPrincipalName() {
		return principalName;
	}

	public void setPrincipalName(String principalName) {
		this.principalName = principalName;
	}

	public Long getNumber() {
		return number;
	}

	public void setNumber(Long number) {
		this.number = number;
	}

	public Integer getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(Integer provinceId) {
		this.provinceId = provinceId;
	}

	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public Integer getDistrictId() {
		return districtId;
	}

	public void setDistrictId(Integer districtId) {
		this.districtId = districtId;
	}

	public Integer getTownId() {
		return townId;
	}

	public void setTownId(Integer townId) {
		this.townId = townId;
	}

	public Integer getVillageId() {
		return villageId;
	}

	public void setVillageId(Integer villageId) {
		this.villageId = villageId;
	}

	public String getCreatorId() {
		return creatorId;
	}

	public void setCreatorId(String creatorId) {
		this.creatorId = creatorId;
	}

	public String getCreatorName() {
		return creatorName;
	}

	public void setCreatorName(String creatorName) {
		this.creatorName = creatorName;
	}

	public String getCreatorTime() {
		return creatorTime;
	}

	public void setCreatorTime(String creatorTime) {
		this.creatorTime = creatorTime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
