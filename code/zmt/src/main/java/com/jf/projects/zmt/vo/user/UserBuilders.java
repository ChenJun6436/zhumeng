package com.jf.projects.zmt.vo.user;

public class UserBuilders {
	/*
	 * 建档者id
	 */
	private String id;
	/*
	 * 部门
	 */
	private String department;
	/*
	 * 角色
	 */
	private String role;
	/*
	 * 账号
	 */
	private String account;
	/*
	 * 电话
	 */
	private String phone;
	/*
	 * 建档者名字
	 */
	private String name;
	/*
	 * 建档者地址
	 */
	private String address;
	/*
	 * 建档者状态
	 */
	private String status;

	public UserBuilders() {
		super();
	}

	public UserBuilders(String id, String department, String role,
			String account, String phone, String name, String address,
			String status) {
		super();
		this.id = id;
		this.department = department;
		this.role = role;
		this.account = account;
		this.phone = phone;
		this.name = name;
		this.address = address;
		this.status = status;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
