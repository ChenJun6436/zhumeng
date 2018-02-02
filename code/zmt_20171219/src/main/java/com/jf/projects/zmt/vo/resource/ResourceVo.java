package com.jf.projects.zmt.vo.resource;

public class ResourceVo {
    
    /**
     * 资源ID
     */
    private String resourceId;
    /**
     * 资源名称
     */
    private String resourceName;
    /**
     * 父ID
     */
    private String parentId;
    /**
     * 0->查看使用权限；1->查看
     */
    private String type;

    /**
     * 角色代码
     */
    private String code;
    
    
    public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getPraentId() {
        return parentId;
    }

    public void setPraentId(String praentId) {
        this.parentId = praentId;
    }

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    
    

}
