package com.jf.projects.zmt.service;


import com.jf.projects.zmt.vo.ResponseVO;


/**
 * 
 * @className: UserBaseService
 *
 * @description:用户基础
 *
 * @author wj
 *
 * @date 2017年11月1日下午2:12:10
 *
 */
public interface UserBaseService {
   
    /**
     * 用户登录
     * @param account
     * @param pwd
     * @return
     */
    ResponseVO  loginUser(String account,String pwd);
    
    /**
     * 重置密码
     * @param tel
     * @param pwd
     * @return
     */
    ResponseVO  updatePwdBytel(String tel ,String pwd); 
    
    /**
     * 修改用户手机号
     * @param account
     * @param tel
     * @return
     */
    ResponseVO  updateTelByAccount(String account ,String tel);
    
    /**
     * 修改密码
     * @param account
     * @param pwd
     * @param newPwd
     * @return
     */
    ResponseVO updatePwdByAccount(String account ,String pwd,String newPwd); 
    
    /**
     * 根据用户ID获取用户类型部门角色信息
     * @param userId
     * @return
     */
    ResponseVO findUserInfoById(String userId);
    
}
