package com.jf.projects.zmt.vo.slaughter;

public class SlaughterVo {
	private String id;
	private String userName;
	private String account;
	private String phone;
	private String status;
	private String userAdddress;
	private String slaughName;
	private String creator;
	private String createTime;
	private String slaughAddress;
	private String userId;
	private Integer total;

	public SlaughterVo() {
		super();
	}

	public SlaughterVo(String id, String userName, String account,
			String phone, String status, String userAdddress,
			String slaughName, String creator, String createTime,
			String slaughAddress, String userId, Integer total) {
		super();
		this.id = id;
		this.userName = userName;
		this.account = account;
		this.phone = phone;
		this.status = status;
		this.userAdddress = userAdddress;
		this.slaughName = slaughName;
		this.creator = creator;
		this.createTime = createTime;
		this.slaughAddress = slaughAddress;
		this.userId = userId;
		this.total = total;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUserAdddress() {
		return userAdddress;
	}

	public void setUserAdddress(String userAdddress) {
		this.userAdddress = userAdddress;
	}

	public String getSlaughName() {
		return slaughName;
	}

	public void setSlaughName(String slaughName) {
		this.slaughName = slaughName;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getSlaughAddress() {
		return slaughAddress;
	}

	public void setSlaughAddress(String slaughAddress) {
		this.slaughAddress = slaughAddress;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

}
