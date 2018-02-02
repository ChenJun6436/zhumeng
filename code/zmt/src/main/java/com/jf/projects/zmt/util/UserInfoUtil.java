package com.jf.projects.zmt.util;

import java.util.Hashtable;
import java.util.Map;

import org.apache.commons.collections.map.HashedMap;

import com.jf.projects.zmt.vo.user.LoginUserInfoVo;

/**
 * 
 * @className: UserInfoUtil
 *
 * @description:缓存登录信息
 *
 * @author wj
 *
 * @date 2017年11月17日上午10:29:20
 *
 */
public class UserInfoUtil
{
    private static Map<String, Object> UserInfoMap = new Hashtable<String, Object>();
    
    /**
     * 缓存用户登录信息
     * @param userId
     * @param userInfo
     */
    public static void storeUserInfo(String userId, LoginUserInfoVo userInfo)
    {
        UserInfoMap.put(userId, userInfo);
    }
    /**
     * 清除用户登录缓存
     * @param userId
     */
    public static void removeUserInfo(String userId){
        UserInfoMap.remove(userId);
    }
    
    /**
     * 获取用户登录信息
     * @param userId
     * @return
     */
    public static Object getUserInfo(String userId){
    	return UserInfoUtil.UserInfoMap.get(userId);
    }
  
    
  /*  public static void main(String[] args){
           System.out.println(UserInfoUtil.getUserInfo("3b5d833250f141a08bdf08efaa5a8938"));
    }*/
}
