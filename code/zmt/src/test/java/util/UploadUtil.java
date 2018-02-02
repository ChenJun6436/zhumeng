package util;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;

import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;

public class UploadUtil {
    private static final String TAG = "uploadFile";
    private static final int TIME_OUT = 10 * 1000; // 超时时间
    private static final String CHARSET = "utf-8"; // 设置编码
    /**
     * 上传文件到服务器
     * @param file 需要上传的文件
     * @param RequestURL 请求的rul
     * @return 返回响应的内容
     */
    public static int uploadFile(File file, String RequestURL,Map<String, String> param) {
        int res=0;
       
        String BOUNDARY = UUID.randomUUID().toString(); // 边界标识 随机生成
        String PREFIX = "--", LINE_END = "\r\n";
        String CONTENT_TYPE = "multipart/form-data"; // 内容类型
 
        try {
            URL url = new URL(RequestURL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setReadTimeout(TIME_OUT);
            conn.setConnectTimeout(TIME_OUT);
            conn.setDoInput(true); // 允许输入流
            conn.setDoOutput(true); // 允许输出流
            conn.setUseCaches(false); // 不允许使用缓存
            conn.setRequestMethod("POST"); // 请求方式
            conn.setRequestProperty("Charset", CHARSET); // 设置编码
            conn.setRequestProperty("connection", "keep-alive");
            conn.setRequestProperty("Content-Type", CONTENT_TYPE + ";boundary="+ BOUNDARY);
            DataOutputStream dos = new DataOutputStream(conn.getOutputStream());
            /***
    		* 以下是用于上传参数
    		*/
    		if (param != null && param.size() > 0) {
    		Iterator<String> it = param.keySet().iterator();
    		while (it.hasNext()) {
    		StringBuffer buffer = new StringBuffer();
    		String key = it.next();
    		String value = param.get(key);
    		buffer.append(PREFIX).append(BOUNDARY).append(LINE_END);
    		buffer.append("Content-Disposition: form-data; name=\"").append(key).append("\"").append(LINE_END).append(LINE_END);
    		buffer.append(value).append(LINE_END);	
    		dos.write(buffer.toString().getBytes());
    		// dos.flush();
    		}
    		}
            if (file != null) {
                /**
                 * 当文件不为空时执行上传
                 */
              
                StringBuffer sb = new StringBuffer();
                sb.append(PREFIX);
                sb.append(BOUNDARY);
                sb.append(LINE_END);
                /**
                 * 这里重点注意： name里面的值为服务器端需要key 只有这个key 才可以得到对应的文件
                 * filename是文件的名字，包含后缀名
                 */
 
                sb.append("Content-Disposition: form-data; name=\"file\"; filename=\""
                        + file.getName() + "\"" + LINE_END);
                sb.append("Content-Type: application/octet-stream; charset="
                        + CHARSET + LINE_END);
                sb.append(LINE_END);
                dos.write(sb.toString().getBytes());
                InputStream is = new FileInputStream(file);
                byte[] bytes = new byte[1024];
                int len = 0;
                while ((len = is.read(bytes)) != -1) {
                    dos.write(bytes, 0, len);
                }
                is.close();
                dos.write(LINE_END.getBytes());
                byte[] end_data = (PREFIX + BOUNDARY + PREFIX + LINE_END).getBytes();
                dos.write(end_data);
                dos.flush();
                /**
                 * 获取响应码 200=成功 当响应成功，获取响应的流
                 */
                 res = conn.getResponseCode();
               
                if (res == 200) {
                    
                    InputStream input = conn.getInputStream();
                    StringBuffer sb1 = new StringBuffer();
                    int ss;
                    while ((ss = input.read()) != -1) {
                        sb1.append((char) ss);
                    }
                   System.out.println(sb1.toString());
                   
                  
                } 
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }
public static InputStream http(File file,String RequestURL, byte[] PostData) {
		
		
		InputStream inputStream = null;
		// 尝试发送请求
		try {
			URL url = new URL(RequestURL);
            HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
            httpURLConnection.setConnectTimeout(3000);   //设置连接超时时间
            httpURLConnection.setDoInput(true);                  //打开输入流，以便从服务器获取数据
            httpURLConnection.setDoOutput(true);                 //打开输出流，以便向服务器提交数据
            httpURLConnection.setRequestMethod("POST");    //设置以Post方式提交数据
            httpURLConnection.setUseCaches(false);               //使用Post方式不能使用缓存
            httpURLConnection.setRequestProperty("Content-Type", "binary/octet-stream");
			OutputStream outStream = httpURLConnection.getOutputStream();
			 InputStream is = new FileInputStream(file);
             byte[] bytes = new byte[1024];
             int len = 0;
             while ((len = is.read(bytes)) != -1) {
            	 outStream.write(bytes, 0, len);
             }
//			outStream.write(PostData);
			outStream.flush();
			outStream.close();
			httpURLConnection.disconnect();
			inputStream = httpURLConnection.getInputStream();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return inputStream;
	}
    
   
}