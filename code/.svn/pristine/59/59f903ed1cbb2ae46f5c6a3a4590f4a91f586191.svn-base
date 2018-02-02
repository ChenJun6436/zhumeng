package com.jf.projects.zmt.vo.slaughterhouse;

import com.jf.projects.zmt.model.SUser;
import com.jf.projects.zmt.vo.user.UserVo;

/**
 * 屠宰场详情
 * 
 * @description:zmt
 * @author yt
 * @date 2017年11月6日
 */
public class SlaughterhouseUserDetailsVo extends UserVo {
    public SlaughterhouseUserDetailsVo() {

    }

    public SlaughterhouseUserDetailsVo(SUser user) {
        this.account = user.getLoginName();
        this.userName = user.getName();
        this.phone = user.getTel();
        this.status = user.getStatus();
        this.provinceId = user.getProvinceId();
        this.cityId = user.getCityId();
        this.districtId = user.getDistrictId();
        this.townId = user.getTownId();
        this.villageId = user.getVillageId();
    }

    private String address;

    private String id;

    private String operaterId;

    private Integer count;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOperaterId() {
        return operaterId;
    }

    public void setOperaterId(String operaterId) {
        this.operaterId = operaterId;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

}
