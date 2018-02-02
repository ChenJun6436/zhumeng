package util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

public class XMLUtil
{

    public static String createXML(Map map)
    {
        Document document = DocumentHelper.createDocument();
        document.setXMLEncoding("UTF-8");
        Element root = document.addElement("xml");
        Iterator iters = map.keySet().iterator();
        while (iters.hasNext())
        {
            String key = iters.next().toString(); // 拿到键

            String val = map.get(key).toString(); // 拿到值


            root.addElement(key).addText(val);
        }


        String xmlString = document.asXML();
        return xmlString;
    }
    public static Map<String, Object> xmlToMap(String xml) throws Exception
    {
        Map map = new HashMap();
        Document doc =  DocumentHelper.parseText(xml);
        Element root = doc.getRootElement();
       
        // 枚举根节点下所有子节点
        for (Iterator ie = root.elementIterator(); ie.hasNext();)
        {
            Element element = (Element) ie.next();
            map.put(element.getName(), element.getText());   
        }
        return map;

    }

}
