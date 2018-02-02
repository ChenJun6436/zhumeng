package com.jf.projects.zmt.vo.slaughterhouse;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jf.projects.zmt.vo.user.UserVo;

public class SlaughterhouseVo extends UserVo {
    public SlaughterhouseVo() {

    }

    public SlaughterhouseVo(UserVo userVo) {
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

    /**
     * 生成时间
     */
    private Date createTime;

    private String creatorName;

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

    public String getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    @JsonFormat(pattern = "yyyy-MM-dd")
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
