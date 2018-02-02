package com.jf.projects.zmt.util;


public class ConstantsUtil {

	
	
	/**
	 * 请求成功
	 */
	public static final String RES_SUCCESS_CODE = "0";
	public static final String RES_SUCCESS_MESSAGE = "成功";

	/**
	 * 非法请求
	 */
	public static final String RES_ILLEGAL_CODE = "900";
	public static final String RES_ILLEGAL_MESSAGE = "非法请求";
	/**
	 * 后台异常,请联系我们
	 */
	public static final String RES_FAIL_CODE = "500";
	public static final String RES_FAIL_MESSAGE = "操作失败";
	
	/**
     * 请求失败
     */
    public static final String RES_PARAMER_FAIL_CODE = "105";
    public static final String RES_PARAMER_FAIL_MESSAGE = "请求失败，错误参数"; 
    
	/**
	 * 该账号尚未注册
	 */
	public static final String RES_NOT_EXIST_CODE = "200";
	public static final String RES_NOT_EXIST_MESSAGE = "该账号尚未注册";
	
	/**
	 * 账号已被注册
	 */
    public static final String RES_EXIST_CODE = "201";
    public static final String RES_EXIST_MESSAGE = "该账号已被注册";
  
    /**
	 * 密码错误
	 */
	public static final String RES_PWD_NO_MATCH_CODE = "202";
	public static final String RES_PWD_NO_MATCH_MESSAGE = "密码错误";
	
    /**
	 * 验证码失效
	 */
	public static final String RES_CODE_LOSE_CODE = "204";
	public static final String RES_CODE_LOSE_MESSAGE = "验证码失效";
	/**
	 * 未获取验证码
	 */
	public static final String RES_NOT_GET_CODE_CODE = "205";
	public static final String RES_NOT_GET_CODE_MESSAGE = "请获取验证码";
	/**
	 * 验证码错误
	 */
	public static final String RES_CODE_NOT_CORRECT_CODE = "206";
	public static final String RES_CODE_NOT_CORRECT_MESSAGE = "验证码错误";
	
	/**
	 * 账户被冻结
	 */
	public static final String RES_LAWYER_FROZEN_ACCOUNT_CODE = "207";
	public static final String RES_LAWYER_FROZEN_ACCOUNT_MESSAGE = "该账户已被冻结，请联系我们";




	/**
	 * 表示状态为-1,删除
	 */
	public static final Integer status_d = -1;
	/**
	 * 表示状态为0
	 */
	public static final Integer status_0 = 0;
	
	/**
	 * 表示状态为1
	 */
	public static final Integer status_1 = 1;
	
	/**
	 * 表示状态为2
	 */
	public static final Integer status_2 = 2;
	
	/**
	 * 表示状态为3
	 */
	public static final Integer status_3 = 3;
	/**
	 * 表示状态为4
	 */
	public static final Integer status_4 = 4;
	
	/**
	 * 手机号正则
	 */
	public static final String REGEXP_PHONE = "^((13[0-9])|(15[^4])|(18[0,2,3,5-9])|(17[0-8])|(147))\\d{8}$";
	
	/**
     * 正整数正则
     */
	public static final String REGEXP_NUMBER = "^[0-9]*$";
	
	
}
