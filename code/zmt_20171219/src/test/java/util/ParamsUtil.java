package util;

import java.util.Map;



public class ParamsUtil {
	private static final String key = "0635e79ed5468ab06ec0e5cd8cb5f8e4";
	public static String createToken(Map<String,Object> params){
		
		StringBuffer buffer = new StringBuffer();
		buffer.append(key);
		buffer.append(params.get("timestamp"));
		
	
		return MD5Util.MD5(buffer.toString());
		
	}
}
