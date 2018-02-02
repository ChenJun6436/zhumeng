package com.jf.projects.zmt.util;
import java.io.*;  
import java.util.*;  
import org.dom4j.*;  
import org.dom4j.io.*;  

/**
 * 
 * @ClassName: Dom4jUtil
 *
 * @Description:Dom4j解析xml
 *
 * @author wj
 *
 * @date 2018年1月9日
 *
 */
public class Dom4jUtil {
//	private static final String path= "D:/xmlFile/city_data.xml";
	private static final String path= "D:/xmlFile/test.xml";
	
	 public static void Dom4j() {
		 try {  
	            File f = new File(path);  
	            //创建SAXReader对象 
	            SAXReader reader = new SAXReader();  
	           //读取文件 转换成Document 
	            Document doc = reader.read(f);  
	           //获取根节点元素对象
	            Element root = doc.getRootElement();  
	          //获取节点student1  
	            Element pigTypeElement = root.element("pig_type");
	            Element foo;  
	            for (Iterator i = pigTypeElement.elementIterator("value"); i.hasNext();) {  
	                foo = (Element) i.next();  
	                System.out.print("生猪品种：" + foo.elementText("type_name"));  
	                System.out.println("品种数量：" + foo.elementText("num"));  
	            }  
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }  
		 
	 }
	 
	 /**
	  * 获取相关根节点数据
	  * @param path  文件路径
	  * @param element  根节点
	  * @return
	  */
	 public static Element Dom4j_xml(String path,String element) {
		 Element xmlElement;
		 try {  
	            File f = new File(path);  
	            //创建SAXReader对象 
	            SAXReader reader = new SAXReader();  
	           //读取文件 转换成Document 
	            Document doc = reader.read(f);  
	           //获取根节点元素对象
	            Element root = doc.getRootElement();  
	          //获取节点student1  
	            xmlElement = root.element(element);
	            
	        } catch (Exception e) {  
	            e.printStackTrace();  
	            return null;
	        }  
		 
		 return xmlElement;
		 
	 }
	
	 
	/* public static void main(String arge[]) {  
		 
		 Element element = Dom4j_xml(path, "pig_top");
		 Element foo;
         for (Iterator i = element.elementIterator("value"); i.hasNext();) {  
             foo = (Element) i.next();  
             System.out.print("名称：" + foo.elementText("name"));  
             System.out.println("数量：" + foo.elementText("num"));  
         }  
		 
	    }  */
	}  

