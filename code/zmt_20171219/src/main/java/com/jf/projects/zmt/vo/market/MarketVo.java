package com.jf.projects.zmt.vo.market;

import com.jf.projects.zmt.vo.user.UserVo;

public class MarketVo extends UserVo {
    public MarketVo() {

    }

    public MarketVo(UserVo userVo) {
        this.departmentName = userVo.getDepartmentName();
        this.typeName = userVo.getTypeName();
        this.account = userVo.getAccount();
        this.userId = userVo.getUserId();
        this.userName = userVo.getUserName();
        this.phone = userVo.getPhone();
        this.status = userVo.getStatus();
    }

    private String id;

    private String operaterId;

    private Integer number;

    private String address;

    public String getOperaterId() {
        return operaterId;
    }

    public void setOperaterId(String operaterId) {
        this.operaterId = operaterId;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
