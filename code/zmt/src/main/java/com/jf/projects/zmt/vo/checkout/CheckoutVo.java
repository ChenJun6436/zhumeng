package com.jf.projects.zmt.vo.checkout;

import com.jf.projects.zmt.vo.user.UserVo;

public class CheckoutVo extends UserVo {
    public CheckoutVo() {

    }

    public CheckoutVo(UserVo userVo) {
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

    private int count;

    public String getOperaterId() {
        return operaterId;
    }

    public void setOperaterId(String operaterId) {
        this.operaterId = operaterId;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
