package com.jf.projects.zmt.vo.account;

/**
 * 
 * @className: UserInfoVO
 *
 * @description:根据用户类型部门角色信息
 *
 * @author wj
 *
 * @date 2017年11月24日下午2:52:46
 *
 */
public class UserInfoVO {
    
    /**
     * 类型ID
     */
    private String typeId;
    /**
     * 类型名称
     */
    private String typeName;
    /**
     * 部门Id
     */
    private String departmentId;
    /**
     * 部门名称
     */
    private String departmentName;
    /**
     * 角色ID
     */
    private String roleId;
    /**
     * 角色名称
     */
    private String roleName;
    public String getTypeId() {
        return typeId;
    }
    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }
    public String getTypeName() {
        return typeName;
    }
    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
    public String getDepartmentId() {
        return departmentId;
    }
    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }
    public String getDepartmentName() {
        return departmentName;
    }
    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
    public String getRoleId() {
        return roleId;
    }
    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }
    public String getRoleName() {
        return roleName;
    }
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
    

}
