package com.jf.projects.zmt.util;

import java.util.Hashtable;
import java.util.Map;
import java.util.Random;

import org.apache.commons.collections.map.HashedMap;

import com.jf.projects.zmt.vo.ResponseVO;


public class CheckCodeUtil
{
    private static Map<String, String> checkCodeMap = new Hashtable<String, String>();
    public static String newCheckCode(String phone)
    {
        StringBuffer checkCode = new StringBuffer();
        while(checkCode.length() < 6)
        {
            checkCode.append((int)(Math.random() * 10));
        }
        checkCodeMap.put(phone, checkCode + "-" + System.currentTimeMillis());
 //     System.out.println(checkCodeMap.get(phone));
        return checkCode.toString();
    }
    public static void removeCheckCode(String phone){
    	checkCodeMap.remove(phone);
    }
    public static String getCheckCode(String phone){
    	String checkCode = CheckCodeUtil.checkCodeMap.get(phone);
    	if(checkCode!=null){
    		
    		return checkCode;
    	}else{
    		return null;
    	}
    	
    }
    public static ResponseVO checkCodeValue(String bindTel,String checkCode){
    	String codeAndTime = (String) CheckCodeUtil.getCheckCode(bindTel);
    	ResponseVO responseVO = new ResponseVO();
		if (codeAndTime == null) {
			responseVO.setCode(ConstantsUtil.RES_NOT_GET_CODE_CODE);
			responseVO.setMessage(ConstantsUtil.RES_NOT_GET_CODE_MESSAGE);
			return responseVO;
		}
		String oldCode = String.valueOf(codeAndTime.split("-")[0]);
		Long oldTime = Long.valueOf(codeAndTime.split("-")[1]);
		Long newTime = System.currentTimeMillis();
		if ((newTime - oldTime) /  1000 / 60 > 15) // 15min失效
		{
			responseVO.setCode(ConstantsUtil.RES_CODE_LOSE_CODE);
			responseVO.setMessage(ConstantsUtil.RES_CODE_LOSE_MESSAGE);
			return responseVO;
		}
		if (!oldCode.equals(checkCode)) {
			responseVO.setCode(ConstantsUtil.RES_CODE_NOT_CORRECT_CODE);
			responseVO.setMessage(ConstantsUtil.RES_CODE_NOT_CORRECT_MESSAGE);
			return responseVO;
		}
		return null;
    }
    
   /* public static void main(String[] args){
           System.out.println(CheckCodeUtil.getCheckCode("18583688325"));
    }*/
}
