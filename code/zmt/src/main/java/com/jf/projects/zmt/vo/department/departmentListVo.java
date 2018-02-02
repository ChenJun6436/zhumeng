package com.jf.projects.zmt.vo.department;


public class departmentListVo {
    /**
     * 主键UUID
     */
    private String departmentId;
    /**
     * 部门编码
     */
    private String code;
    /**
     * 部门名称
     */
    private String departmentName;
    /**
     * 部门类型主键
     */
    private String typeId;
    /**
     * 类型名称
     */
    private String typeName;
    /**
     * 部门下角色数
     */
    private Integer countRole;
    public String getDepartmentId() {
        return departmentId;
    }
    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getDepartmentName() {
        return departmentName;
    }
    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
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
    public Integer getCountRole() {
        return countRole;
    }
    public void setCountRole(Integer countRole) {
        this.countRole = countRole;
    }
    
    
    
}
