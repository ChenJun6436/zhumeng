package com.jf.projects.zmt.service.impl;

import java.util.Iterator;

import org.dom4j.Element;
import org.springframework.stereotype.Service;

import com.jf.projects.zmt.service.CultureService;
import com.jf.projects.zmt.util.Dom4jUtil;
import com.jf.projects.zmt.util.ParamUtil;
import com.jf.projects.zmt.vo.pig.FarmerCountVo;

@Service
public class CultureServiceImpl implements CultureService {

	@Override
	public FarmerCountVo countCulture(Integer type) {
		FarmerCountVo vo = new FarmerCountVo();
		//根据根节点名称获取xml配置信息
		 Element element =Dom4jUtil.Dom4j_xml( type==null?ParamUtil.getXmlFileAddress():ParamUtil.getCityXmlFileAddress(), "culture");
		 if(element == null) return vo;
		 Element foo;
        for (Iterator i = element.elementIterator("value"); i.hasNext();) {  
            foo = (Element) i.next();
            //获取根节点元素
            vo.setChampion(foo.elementText("champion"));
            vo.setNum(foo.elementText("num"));
            vo.setCulturist(foo.elementText("culturist"));
            vo.setFarm(foo.elementText("farm"));
/*          //总数
            vo.setCountFarmer(vo.getCulturist() + vo.getFarm());
            //比例 保留两位数
            BigDecimal cul = new BigDecimal(vo.getCulturist());
            BigDecimal farm = new BigDecimal(vo.getFarm());
            BigDecimal divEnd = new BigDecimal(vo.getCountFarmer());
            vo.setCulturistRatio(cul.divide(divEnd,2,BigDecimal.ROUND_HALF_UP).doubleValue() * 100);
            vo.setFarmRatio(farm.divide(divEnd,2,BigDecimal.ROUND_HALF_UP).doubleValue() * 100);
*/            
            break;
        }  
		
		return vo;
	}

}
