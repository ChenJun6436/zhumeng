package com.jf.projects.zmt.vo.home;

/**
 * 首页图表数据
 * @author dqh
 *
 */
public class PicCountVo {

	/* 建档 */
	private FilingNumberVo filingNumber;
	/* 录入 */
	private InputNumberVo inputNumber;
	/* 屠宰 */
	private SlaughterNumberVo slaughterNumber;
	/* 销售 */
	private SaleNumberVo saleNumber;
	
	public FilingNumberVo getFilingNumber() {
		return filingNumber;
	}
	public void setFilingNumber(FilingNumberVo filingNumber) {
		this.filingNumber = filingNumber;
	}
	public InputNumberVo getInputNumber() {
		return inputNumber;
	}
	public void setInputNumber(InputNumberVo inputNumber) {
		this.inputNumber = inputNumber;
	}
	public SlaughterNumberVo getSlaughterNumber() {
		return slaughterNumber;
	}
	public void setSlaughterNumber(SlaughterNumberVo slaughterNumber) {
		this.slaughterNumber = slaughterNumber;
	}
	public SaleNumberVo getSaleNumber() {
		return saleNumber;
	}
	public void setSaleNumber(SaleNumberVo saleNumber) {
		this.saleNumber = saleNumber;
	}
}
