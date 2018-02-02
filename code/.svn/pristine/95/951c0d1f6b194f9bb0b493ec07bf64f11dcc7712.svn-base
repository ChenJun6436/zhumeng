package util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.PostMethod;



	public class Http { 


	        public static final String POST_URL = "http://127.0.0.1:8080/zmt/";
//	        public static final String POST_URL = "http://192.168.5.154:8085/zmt/";


	        /**
	         * 
	        * @Title: Post 
	        * @Description: TODO(这里用一句话描述这个方法的作用) 
	        * @param @param method 请求方法
	        * @param @param params 参数集合
	        * @param @throws IOException    设定文件 
	        * @return void    返回类型 
	        * @throws
	         */
	        public static String post(String method,Map<String,Object> params) throws IOException { 

	               // Post请求的url，与get不同的是不需要带参数 

	               URL postUrl = new URL(POST_URL+method); 
	             
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

	               connection.setRequestProperty(" Content-Type "," application/xml "); 
	              
	               // 连接，从postUrl.openConnection()至此的配置必须要在 connect之前完成， 

	               // 要注意的是connection.getOutputStream()会隐含的进行调用 connect()，所以这里可以省略 

	               //connection.connect(); 
	               
	               BufferedWriter out = new BufferedWriter(new OutputStreamWriter(connection.getOutputStream(), "UTF-8")); 

	               //正文内容其实跟get的URL中'?'后的参数字符串一致 
	              // String content = "messageId=2004&xml="; 
	               StringBuffer buffer = new StringBuffer();
	               params.put("timestamp", System.currentTimeMillis());
	               params.put("token", ParamsUtil.createToken(params));
	             //  params.put("token", ParamsUtil.createToken(params));
	               for (String key : params.keySet()) {
	            	   buffer.append(key).append("=").append(params.get(key)).append("&");
	            	   System.out.println("key= "+ key + " and value= " + params.get(key));
	            	}
	               if(buffer.length()>0){
	            	   String content =  buffer.substring(0, buffer.lastIndexOf("&"));
	            	   out.write(content);
	               }
	               // DataOutputStream.writeBytes将字符串中的16位的 unicode字符以8位的字符形式写道流里面 
	               out.flush(); 

	               out.close(); // flush and close 

	               BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream())); 
	               String line; 

	               while ((line = reader.readLine()) != null) { 

	                       System.out.println(line.toString()); 
	                     
	               } 
	               reader.close();
				return line; 
	              
	        } 
	        /** 
	         * post方式  
	         * @param param1  
	         * @param param2 
	         * @return 
	    */  
	        public static String postHttp(String method,Map<String,Object> params) {  
	            String responseMsg = "";  
	              
	            //1.构造HttpClient的实例  
	            HttpClient httpClient=new HttpClient();  
	              
	            httpClient.getParams().setContentCharset("utf-8");  
	              
	           
	              
	            //2.构造PostMethod的实例  
	            PostMethod postMethod=new PostMethod(POST_URL+method);  
	              
	            //3.把参数值放入到PostMethod对象中  
	            for (String key : params.keySet()) {
	            	postMethod.addParameter(key, String.valueOf(params.get(key)));  
	                System.out.println("key= "+ key + " and value= " + params.get(key));
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
	
	      
}
