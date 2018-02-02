package com.jf.projects.zmt.vo.pig;

import java.util.List;

/**
 * 市场销售数据
 * @author dqh
 *
 */
public class MarketSaleVo {
	
	/* 当月销售总量 */
	private String totalWeight;
	
	/* 市场 */
	private List<MarketVo> markets;

	public String getTotalWeight() {
		return totalWeight;
	}

	public void setTotalWeight(String totalWeight) {
		this.totalWeight = totalWeight;
	}

	public List<MarketVo> getMarkets() {
		return markets;
	}

	public void setMarkets(List<MarketVo> markets) {
		this.markets = markets;
	}
}
