package com.jf.projects.zmt.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Element;
import org.springframework.stereotype.Service;

import com.jf.projects.zmt.service.SlaughterService;
import com.jf.projects.zmt.util.Dom4jUtil;
import com.jf.projects.zmt.util.ParamUtil;
import com.jf.projects.zmt.vo.pig.CountNumVo;
import com.jf.projects.zmt.vo.pig.SlaughterTop5Vo;
import com.jf.projects.zmt.vo.pig.SlaughterVo;
import com.jf.projects.zmt.vo.pig.YearCountNumVO;

@Service
public class SlaughterServiceImpl implements SlaughterService {

	@Override
	public YearCountNumVO findPigAndSlaughterForYear(Integer type) {
		 YearCountNumVO vo = new YearCountNumVO();
		 //根据根节点名称获取xml配置信息
		 Element element =Dom4jUtil.Dom4j_xml( type==null?ParamUtil.getXmlFileAddress():ParamUtil.getCityXmlFileAddress(), "pig_and_slaughter");
		 if(element == null) return vo;
		 //屠宰场数量
		 vo.setSlaughterHouse(element.elementText("slaughter_house"));
		 //屠宰榜首
		 vo.setSlaughterChampion(element.elementText("slaughter_champion"));
		 //榜首屠宰数量
		 vo.setSlaughterNum(element.elementText("slaughter_num"));
		 
		 //每月详细数据
		 Element foo;
		 List<CountNumVo> monthList = new ArrayList<CountNumVo>();
       for (Iterator i = element.elementIterator("value"); i.hasNext();) {
           CountNumVo month = new CountNumVo();
    	   foo = (Element) i.next();
           //每月数据
    	   month.setPigNum(foo.elementText("pig_num"));
    	   month.setSlaughterNum(foo.elementText("slaughter_num"));
    	   monthList.add(month);
       }
       vo.setMonthList(monthList);
       return vo;
	}

	@Override
	public SlaughterTop5Vo findTop5ToMonth(Integer type) {
		SlaughterTop5Vo vo = new SlaughterTop5Vo();
		//根据根节点名称获取xml配置信息(获取总览的生猪总数)
		Element element =Dom4jUtil.Dom4j_xml( type==null?ParamUtil.getXmlFileAddress():ParamUtil.getCityXmlFileAddress(), "overview");
		if(element == null) return vo;
		Element foo;
		for (Iterator i = element.elementIterator("value"); i.hasNext();) {
			foo = (Element) i.next();
			if("屠宰总数".equals(foo.elementText("name"))){
				vo.setSlaughterNum(foo.elementText("num"));
				break;
			}
		}
		
		//根据根节点名称获取xml配置信息(获取屠宰场及屠宰数量)
		Element slelement =Dom4jUtil.Dom4j_xml( type==null?ParamUtil.getXmlFileAddress():ParamUtil.getCityXmlFileAddress(), "slaughter_top5");
		if(slelement == null) return vo;
		List<SlaughterVo> list = new ArrayList<SlaughterVo>();
		for (Iterator i = slelement.elementIterator("value"); i.hasNext();) {
		   SlaughterVo slaught = new SlaughterVo();
		   foo = (Element) i.next();
           //屠宰场及屠宰场数量
		   slaught.setSlaughterName(foo.elementText("slaughter_name"));
		   slaught.setPigNum(foo.elementText("pig_num"));
		   list.add(slaught);
		}
		vo.setList(list);
		return vo;
	}
       
}
