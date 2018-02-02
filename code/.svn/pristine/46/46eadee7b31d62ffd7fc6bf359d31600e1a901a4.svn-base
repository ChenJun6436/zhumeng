package com.jf.projects.zmt.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Element;
import org.springframework.stereotype.Service;

import com.jf.projects.zmt.service.PigService;
import com.jf.projects.zmt.util.Dom4jUtil;
import com.jf.projects.zmt.util.ParamUtil;
import com.jf.projects.zmt.vo.pig.OverviewTypeVO;
import com.jf.projects.zmt.vo.pig.PigTop5ListVO;
import com.jf.projects.zmt.vo.pig.PigTop5VO;
import com.jf.projects.zmt.vo.pig.PigTypeVO;


/**
 * 
 * @ClassName: PigServiceImpl
 *
 * @Description:生猪实现层
 *
 * @author wj
 *
 * @date 2018年1月8日
 *
 */

@Service
public class PigServiceImpl implements PigService {


	@Override
	public List<PigTypeVO> findPigType(Integer type) {
		List<PigTypeVO>  list = new ArrayList<PigTypeVO>();
		 //根据根节点名称获取xml配置信息
		 Element element =Dom4jUtil.Dom4j_xml( type==null?ParamUtil.getXmlFileAddress():ParamUtil.getCityXmlFileAddress(), "pig_type");
		 Element foo;
         for (Iterator i = element.elementIterator("value"); i.hasNext();) {  
             foo = (Element) i.next();
             PigTypeVO vo = new PigTypeVO();
             //获取根节点元素
             vo.setTypeName(foo.elementText("type_name"));    //猪品种
             vo.setNum(foo.elementText("num"));				 //数量
             list.add(vo);
         }  
		return list;
	}

	@Override
	public List<OverviewTypeVO> findOverview(Integer type) {
		List<OverviewTypeVO>  list = new ArrayList<OverviewTypeVO>();
		 //根据根节点名称获取xml配置信息
		 Element element =Dom4jUtil.Dom4j_xml( type==null?ParamUtil.getXmlFileAddress():ParamUtil.getCityXmlFileAddress(), "overview");
		 Element foo;
        for (Iterator i = element.elementIterator("value"); i.hasNext();) {  
            foo = (Element) i.next();
            OverviewTypeVO vo = new OverviewTypeVO();
            //获取根节点元素
            vo.setName(foo.elementText("name"));        //名称
            vo.setNum(foo.elementText("num"));          //数量
            vo.setType(foo.elementText("type"));		//环比增降 up->增；down->降
            vo.setPercentage(foo.elementText("percentage")); //百分比
            list.add(vo);
        }  
		return list;
	}

	@Override
	public PigTop5VO findPigTop5(Integer type) {
		PigTop5VO  topVo = new PigTop5VO();
		List<PigTop5ListVO>  list = new ArrayList<PigTop5ListVO>();
	    //type==null获取县级生猪总数,type==1获取市级数据
	    Element element =Dom4jUtil.Dom4j_xml( type==null?ParamUtil.getXmlFileAddress():ParamUtil.getCityXmlFileAddress(), "overview");
		 
		 Element foo;
       for (Iterator i = element.elementIterator("value"); i.hasNext();) {  
           foo = (Element) i.next();
           //获取根节点元素
           if(foo.elementText("name").equals("生猪总数")) {
        	   topVo.setTotal(foo.elementText("num"));
           	break;
           }
       }  
		 //获取top5集合
		 Element element1 =Dom4jUtil.Dom4j_xml(type==null?ParamUtil.getXmlFileAddress():ParamUtil.getCityXmlFileAddress(), "pig_top");  
		 Element foo1;
		 //遍历节点中内容
       for (Iterator i = element1.elementIterator("value"); i.hasNext();) {  
    	   foo1 = (Element) i.next();
           PigTop5ListVO vo = new PigTop5ListVO();
           //获取根节点元素
           vo.setName(foo1.elementText("name"));        //镇名
           vo.setNum(foo1.elementText("num"));          //生猪数量
           list.add(vo);
       }  
        topVo.setTop5(list);
		return topVo;
	}

   
}
