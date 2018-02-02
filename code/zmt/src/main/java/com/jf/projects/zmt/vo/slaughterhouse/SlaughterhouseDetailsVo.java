package com.jf.projects.zmt.vo.slaughterhouse;

/**
 * 屠宰场详情
 * 
 * @description:zmt
 * @author yt
 * @date 2017年11月6日
 */
public class SlaughterhouseDetailsVo {
    private String id;

    /**
     * 屠宰场名称
     */
    private String name;

    /**
     * 
     */
    private int number;

    /**
     * 负责人名字
     */
    private String principalName;

    /**
     * 屠宰场地址
     */
    private String address;

    /**
     * 状态enable->启用；disable->禁用
     */
    private String status;

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

    private String phone;

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

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getPrincipalName() {
        return principalName;
    }

    public void setPrincipalName(String principalName) {
        this.principalName = principalName;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

}
