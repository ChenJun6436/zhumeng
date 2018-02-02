package com.jf.projects.zmt.vo.account;

/**
 * 用户列表返回数据
 * @author dqh
 *
 */
public class AccountVo {
	
	/* 用户id */
	private String id;
	/* 状态 */
	private String status;
	/* 账号 */
	private String account;
	/* 用户姓名 */
	private String name;
	/* 联系方式 */
	private String phone;
	/* 部门名称 */
	private String departmentName;
	/* 角色名称 */
	private String roleName;
	/* 创建人 */
	private String creator;
	/* 创建时间 */
	private String createTime;
	/* 角色id */
	private String roleId;
	
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
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
	
}
