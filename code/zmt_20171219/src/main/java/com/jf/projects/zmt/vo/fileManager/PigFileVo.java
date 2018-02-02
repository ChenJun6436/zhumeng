package com.jf.projects.zmt.vo.fileManager;

/**
 * 
 * 
 * @className:
 * 
 * @description:生猪档案Vo
 * 
 * @author wzw
 * 
 * @date 2017年10月24日
 * 
 */
public class PigFileVo {
	/*
	 * 主键
	 */
	private String id;
	/*
	 * 生猪唯一标志
	 */
	private String sign;
	/*
	 * 创建时间
	 */

	private String createTime;
	/*
	 * 用户地址
	 */
	private String address;
	/*
	 * 备注
	 */
	private String remark;
	/*
	 * 养殖户名字
	 */
	private String name;
	/**
	 * 养殖户id
	 */
	private String farmId;

	public String getFarmId() {
		return farmId;
	}

	public void setFarmId(String farmId) {
		this.farmId = farmId;
	}

	public PigFileVo() {
		super();
	}

	public PigFileVo(String id, String sign, String createTime, String address,
			String remark, String name) {
		super();
		this.id = id;
		this.sign = sign;
		this.createTime = createTime;
		this.address = address;
		this.remark = remark;
		this.name = name;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
