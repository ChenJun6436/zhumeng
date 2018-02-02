package com.jf.projects.zmt.vo.deal;

/**
 * 车辆VO
 * @author dqh
 *
 */
public class CarInfoVo {
	
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
	
}
