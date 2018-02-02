package com.jf.projects.zmt.util;



import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
//import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
//import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
//import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.params.HttpMethodParams;

/**
 * 
 *Module:       HttpClientUtil.java
 *Description:  以get/post的方式发送数据到指定的http接口---利用httpclient.jar包---HTTP接口的调用
 *Company:      
 */

public class HttpClientUtil {
    
    
    private static final String CHARSET = "GB2312";
    
	/** 
     * get方式 
     * @param param1 
     * @param param2 
     * @return 
*/  
    public static String getHttp(String param1,String param2){  
        String responseMsg = "";  
  
        // 1.构造HttpClient的实例  
        HttpClient httpClient = new HttpClient();  
  
        // 用于测试的http接口的url  
        String url="http://localhost:8080/UpDown/httpServer?param1="+param1+"&param2="+param2;  
  
        // 2.创建GetMethod的实例  
        GetMethod getMethod = new GetMethod(url);  
  
        // 使用系统系统的默认的恢复策略  
        getMethod.getParams().setParameter(HttpMethodParams.RETRY_HANDLER,  
                new DefaultHttpMethodRetryHandler());  
          
        try {  
            //3.执行getMethod,调用http接口  
            httpClient.executeMethod(getMethod);  
  
            //4.读取内容  
            byte[] responseBody = getMethod.getResponseBody();  
              
            //5.处理返回的内容  
            responseMsg = new String(responseBody);  
           
              
        } catch (HttpException e) {  
            e.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        }finally{  
            //6.释放连接  
            getMethod.releaseConnection();  
        }  
        return responseMsg;  
    }  

    /** 
     * post方式  
     * @param param1  
     * @param param2 
     * @return 
*/  
    public static String postHttp(String url,Map<String,String> params) {  
        String responseMsg = "";  
          
        //1.构造HttpClient的实例  
        HttpClient httpClient=new HttpClient();  
          
        httpClient.getParams().setContentCharset(CHARSET);  
          
        //2.构造PostMethod的实例  
        PostMethod postMethod=new PostMethod(url);  
          
        //3.把参数值放入到PostMethod对象中  
        for (String key : params.keySet()) {
        	postMethod.addParameter(key, params.get(key));  
     	}
          
        try {  
            // 4.执行postMethod,调用http接口  
            httpClient.executeMethod(postMethod);//200  
              
            //5.读取内容  
            responseMsg = postMethod.getResponseBodyAsString().trim();  
            //6.处理返回的内容  
        } catch (HttpException e) {  
            e.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        } finally {  
            //7.释放连接  
            postMethod.releaseConnection();  
        }  
        return responseMsg;  
    }  
    public static String postHttpXML(String url,String xml) throws Exception {  
    	URL postUrl = new URL(url); 
        
        // 打开连接 

        HttpURLConnection connection = (HttpURLConnection) postUrl.openConnection(); 

        //打开读写属性，默认均为false 

        connection.setDoOutput(true);                 

        connection.setDoInput(true); 

        // 设置请求方式，默认为GET 

        connection.setRequestMethod("POST"); 

        // Post 请求不能使用缓存 

        connection.setUseCaches(false); 	         

        connection.setInstanceFollowRedirects(true); 

        // 配置连接的Content-type，配置为application/x- www-form-urlencoded的意思是正文是urlencoded编码过的form参数，下面我们可以看到我们对正文内容使用URLEncoder.encode进行编码 

        connection.setRequestProperty(" Content-Type "," application/x-www-form-urlencoded "); 
       
        // 连接，从postUrl.openConnection()至此的配置必须要在 connect之前完成， 

        // 要注意的是connection.getOutputStream()会隐含的进行调用 connect()，所以这里可以省略 

        //connection.connect(); 
        
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(connection.getOutputStream(), "UTF-8")); 

 
        if(xml.length()>0){   	  
     	   out.write(xml);
        }
        // DataOutputStream.writeBytes将字符串中的16位的 unicode字符以8位的字符形式写道流里面 
        out.flush(); 

        out.close(); // flush and close 

        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream())); 
        String line; 
        StringBuffer buffer = new StringBuffer();
        while ((line = reader.readLine()) != null) { 
              buffer.append(line.toString());
        } 
        
        reader.close();
		return buffer.toString();  
    }  
  
}