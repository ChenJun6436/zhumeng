package com.jf.projects.zmt.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExVerify {

	/** 
     * 手机号验证 
     *  
     * @param  str 
     * @return 验证通过返回true 
     */  
    public static boolean isMobile(String str) {    
        Pattern p = Pattern.compile("^[1][3,4,5,7,8][0-9]{9}$"); // 验证手机号  
        Matcher m= p.matcher(str);  
        return m.matches();    
    }  
}
