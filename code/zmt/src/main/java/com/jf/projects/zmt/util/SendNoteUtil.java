package com.jf.projects.zmt.util;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @className: SendNoteUtil
 *
 * @description:短信调用接口
 *
 * @author wj
 *
 * @date 2017年10月24日下午3:49:42
 *
 */

public class SendNoteUtil {
    
    private static final String ACCOUNT = "CDLK00780";

    private static final String PASSWORD = "ss1103@";

    private static final String SMSURL = "http://yzm.mb345.com/ws/BatchSend2.aspx?";
    

    /*
     * 发送方法  
     */
	public static String sendNoteMessage(String tel,String content){
	    Map<String, String> params = new HashMap<String, String>();
        params.put("CorpID", ACCOUNT);
        params.put("Pwd", PASSWORD);
        params.put("Mobile", tel);
        params.put("Content", content + "【减负科技】");
        params.put("Cell", "");
        params.put("SendTime", "");
        String result = HttpClientUtil.postHttp(SMSURL, params);
//       System.out.println("------------");
//       System.out.println(result);
        return result;
    }
	
	/*public static void main(String[] args) {
        try {
            sendNoteMessage("18384235850","Java Http方式短信调试！");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/
	
}
