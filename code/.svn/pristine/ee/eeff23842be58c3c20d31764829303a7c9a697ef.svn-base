package com.jf.projects.zmt.util;

import java.io.IOException;
import java.util.Properties;

public class ParamUtil
{
	/**
	 * xml配置物理地址（县级）
	 */
    private static String xmlFileAddress;
    
    /**
	 * xml配置物理地址（市级）
	 */
    private static String cityXmlFileAddress;
    
	static
    {
        Properties  props = new Properties();
      
        try
        {
            props.load(ParamUtil.class.getClassLoader().getResourceAsStream("config/param.properties"));
 
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        xmlFileAddress  = props.getProperty("xmlFile_address");
        
        cityXmlFileAddress  = props.getProperty("city_xmlFile_address");
    }

	public static String getXmlFileAddress() {
		return xmlFileAddress;
	}
	
	public static String getCityXmlFileAddress() {
		return cityXmlFileAddress;
	}
	
}
