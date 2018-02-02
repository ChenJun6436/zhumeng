package com.jf.projects.zmt.model;

import java.util.Date;

/**
 * 车辆信息
 * @author dqh
 *
 */
public class LCarInfo {
	
	/**
	 * id
	 */
    private String id;

    /**
     * 关联入库单或出货单id
     */
    private String merchantId;

    /**
     * 司机名字
     */
    private String driver;

    /**
     * 司机联系电话
     */
    private String tel;

    /**
     * 车牌号
     */
    private String carNo;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 最后修改时间
     */
    private Date updateTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getCarNo() {
        return carNo;
    }

    public void setCarNo(String carNo) {
        this.carNo = carNo;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}