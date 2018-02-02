package com.jf.projects.zmt.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Element;
import org.springframework.stereotype.Service;

import com.jf.projects.zmt.service.MarketSaleService;
import com.jf.projects.zmt.util.Dom4jUtil;
import com.jf.projects.zmt.util.ParamUtil;
import com.jf.projects.zmt.vo.pig.MarketSaleVo;
import com.jf.projects.zmt.vo.pig.MarketVo;

@Service
public class MarketSaleServiceImpl implements MarketSaleService {

	@Override
	public MarketSaleVo findMarketToSale(Integer type) {
		MarketSaleVo vo = new MarketSaleVo();
		//根据根节点名称获取xml配置信息
		Element element =Dom4jUtil.Dom4j_xml( type==null?ParamUtil.getXmlFileAddress():ParamUtil.getCityXmlFileAddress(), "month_sale_top5");
		if(element == null) return vo;
		//获取总重量
		vo.setTotalWeight(element.elementText("total_weight"));
		Element foo;
		List<MarketVo> markets = new ArrayList<MarketVo>();
		for (Iterator i = element.elementIterator("value"); i.hasNext();) {  
            foo = (Element) i.next();
            MarketVo market = new MarketVo();
            //获取市场名称及销售数量
            market.setMarketName(foo.elementText("market_name"));
            market.setWeight(foo.elementText("weight"));
            markets.add(market);
        } 
		vo.setMarkets(markets);
		return vo;
	}

}
