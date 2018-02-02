package com.jf.projects.zmt.vo.user;

public class UserVo {
    /**
     * 部门名称
     */
    protected String departmentName;

    /**
     * 类型名称
     */
    protected String typeName;

    /**
     * 账号
     */
    protected String account;

    /**
     * 用户id
     */
    protected String userId;
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
     * 姓名
     */
    protected String userName;

    /**
     * 联系方式
     */
    protected String phone;

    /**
     * 查询关键字
     */
    protected String key;

    /**
     * 状态 enable->启用；disable->禁用
     */
    protected String status;

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

	public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
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

}
