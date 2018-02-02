package com.jf.projects.zmt.vo.role;

import java.util.List;

import com.jf.projects.zmt.model.AndRoleResource;

public class AddRoleRequestVo {
    
    /*  角色ID   */
    private String roleId;
    /*  部门ID  */
    private String departmentId;
    /*  类型ID  */
    private String typeId;
    /*  角色名称   */
    private String roleName;
    /*   角色资源  */
    private List<AndRoleResource> resourceIds;
    
    
    
    
    
    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public List<AndRoleResource> getResourceIds() {
        return resourceIds;
    }

    public void setResourceIds(List<AndRoleResource> resourceIds) {
        this.resourceIds = resourceIds;
    }


}
