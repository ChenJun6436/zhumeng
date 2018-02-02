package com.jf.projects.zmt.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jf.projects.zmt.dao.AndUserAreaMapper;
import com.jf.projects.zmt.dao.SResourceMapper;
import com.jf.projects.zmt.dao.SRoleMapper;
import com.jf.projects.zmt.dao.SUserMapper;
import com.jf.projects.zmt.model.SRole;
import com.jf.projects.zmt.model.SUser;
import com.jf.projects.zmt.service.UserBaseService;
import com.jf.projects.zmt.util.ConstantsUtil;
import com.jf.projects.zmt.util.UserInfoUtil;
import com.jf.projects.zmt.vo.ResponseVO;
import com.jf.projects.zmt.vo.account.UserInfoVO;
import com.jf.projects.zmt.vo.user.LoginUserInfoVo;

/**
 * @className: UserBaseServiceImpl
 * @description:用户基础实现
 * @author wj
 * @date 2017年11月1日下午2:12:47
 */

@Service
public class UserBaseServiceImpl implements UserBaseService {
    @Autowired
    private SUserMapper userMapper;

    @Autowired
    private SResourceMapper resourceMapper;

    @Autowired
    private AndUserAreaMapper andUserAreaMapper;

    @Autowired
    private SRoleMapper roleMapper;

    @Override
    public ResponseVO loginUser(String account, String pwd) {
        ResponseVO responseVO = new ResponseVO();

        try {
            SUser user = userMapper.findByAccount(account);
            if (user == null) { // 验证参数
                responseVO.setCode(ConstantsUtil.RES_NOT_EXIST_CODE);
                responseVO.setMessage(ConstantsUtil.RES_NOT_EXIST_MESSAGE);
                return responseVO;
            }
            if("disable".equals(user.getStatus())){
                responseVO.setCode(ConstantsUtil.RES_LAWYER_FROZEN_ACCOUNT_CODE);
                responseVO.setMessage(ConstantsUtil.RES_LAWYER_FROZEN_ACCOUNT_MESSAGE);
                return responseVO;
            }
            if (!pwd.equals(user.getPassword())) { // 验证密码
                responseVO.setCode(ConstantsUtil.RES_PWD_NO_MATCH_CODE);
                responseVO.setMessage(ConstantsUtil.RES_PWD_NO_MATCH_MESSAGE);
                return responseVO;
            }
            // 返回用户信息
            LoginUserInfoVo userVO = userMapper.findUserLoginInfo(account);
            SRole  roleVO = roleMapper.findById(userVO.getRoleId());
            if(roleVO != null){
                userVO.setRoleName(roleVO.getName());
                userVO.setRoleCode(roleVO.getCode());
            }
            // 获取用户资源权限
            userVO.setUserResources(resourceMapper.findResourcesByRoleId(userVO.getRoleId()));
            // 获取用户管理范围
            userVO.setUserArea(andUserAreaMapper.findUserArea(userVO.getUserId()));
            
            //缓存用户登录信息
            UserInfoUtil.storeUserInfo(user.getId(), userVO);
            
            responseVO.setData(userVO);
            responseVO.setCode(ConstantsUtil.RES_SUCCESS_CODE);
            responseVO.setMessage(ConstantsUtil.RES_SUCCESS_MESSAGE);
            return responseVO;
        } catch (Exception e) {
            e.printStackTrace();
            responseVO.setCode(ConstantsUtil.RES_FAIL_CODE);
            responseVO.setMessage(ConstantsUtil.RES_FAIL_MESSAGE);
            return responseVO;
        }

    }

    @Override
    public ResponseVO updatePwdBytel(String tel, String pwd) {
        ResponseVO responseVO = new ResponseVO();
        SUser user = userMapper.findByAccount(tel);
        //判断参数合法性
        if (user == null) {
            responseVO.setCode(ConstantsUtil.RES_NOT_EXIST_CODE);
            responseVO.setMessage(ConstantsUtil.RES_NOT_EXIST_MESSAGE);
            return responseVO;
        }
        user.setPassword(pwd);
        try {
            userMapper.update(user);
            // 返回用户信息
            LoginUserInfoVo userVO = userMapper.findUserLoginInfo(tel);
            userVO.setRoleName(roleMapper.findById(userVO.getRoleId()).getName());
            // 获取用户资源权限
            userVO.setUserResources(resourceMapper.findResourcesByRoleId(userVO.getRoleId()));
            // 获取用户管理范围
            userVO.setUserArea(andUserAreaMapper.findUserArea(userVO.getUserId()));
            responseVO.setData(userVO);
            responseVO.setCode(ConstantsUtil.RES_SUCCESS_CODE);
            responseVO.setMessage(ConstantsUtil.RES_SUCCESS_MESSAGE);
            return responseVO;
        } catch (Exception e) {
            e.printStackTrace();
            responseVO.setCode(ConstantsUtil.RES_FAIL_CODE);
            responseVO.setMessage(ConstantsUtil.RES_FAIL_MESSAGE);
            return responseVO;
        }

    }

    @Override
    public ResponseVO updatePwdByAccount(String account, String pwd, String newPwd) {
        ResponseVO responseVO = new ResponseVO();
        try {
            SUser user = userMapper.findByAccount(account);
            if (user == null) {
                responseVO.setCode(ConstantsUtil.RES_NOT_EXIST_CODE);
                responseVO.setMessage(ConstantsUtil.RES_NOT_EXIST_MESSAGE);
                return responseVO;
            }
            if (!pwd.equals(user.getPassword())) {                        // 验证密码
                responseVO.setCode(ConstantsUtil.RES_PWD_NO_MATCH_CODE);
                responseVO.setMessage(ConstantsUtil.RES_PWD_NO_MATCH_MESSAGE);
                return responseVO;
            }
            user.setPassword(newPwd);
            //更新用户信息
            userMapper.update(user);
            responseVO.setCode(ConstantsUtil.RES_SUCCESS_CODE);
            responseVO.setMessage(ConstantsUtil.RES_SUCCESS_MESSAGE);
            return responseVO;

        } catch (Exception e) {
            e.printStackTrace();
            responseVO.setCode(ConstantsUtil.RES_FAIL_CODE);
            responseVO.setMessage(ConstantsUtil.RES_FAIL_MESSAGE);
            return responseVO;
        }

    }

    @Override
    public ResponseVO updateTelByAccount(String account, String tel) {
        ResponseVO responseVO = new ResponseVO();
        try {
            SUser user = userMapper.findByAccount(tel);
            //判断手机号是否已被占用
            if (user != null) {
                responseVO.setCode(ConstantsUtil.RES_EXIST_CODE);
                responseVO.setMessage("该号码已存在！");
                return responseVO;
            }
            SUser suser = userMapper.findByAccount(account);
            suser.setTel(tel);
            //更换电话号码
            userMapper.update(suser);
            responseVO.setCode(ConstantsUtil.RES_SUCCESS_CODE);
            responseVO.setMessage(ConstantsUtil.RES_SUCCESS_MESSAGE);
            return responseVO;

        } catch (Exception e) {
            e.printStackTrace();
            responseVO.setCode(ConstantsUtil.RES_FAIL_CODE);
            responseVO.setMessage(ConstantsUtil.RES_FAIL_MESSAGE);
            return responseVO;
        }
    }

    @Override
    public ResponseVO findUserInfoById(String userId) {
        ResponseVO responseVO = new ResponseVO();
        try {
            UserInfoVO user = userMapper.findUserInfoByUserId(userId);
            //验证参数合法性
            if (user == null) {
                responseVO.setCode(ConstantsUtil.RES_PARAMER_FAIL_CODE);
                responseVO.setMessage(ConstantsUtil.RES_PARAMER_FAIL_MESSAGE);
                return responseVO;
            }
            responseVO.setData(user);
            responseVO.setCode(ConstantsUtil.RES_SUCCESS_CODE);
            responseVO.setMessage(ConstantsUtil.RES_SUCCESS_MESSAGE);
            return responseVO;
        } catch (Exception e) {
            e.printStackTrace();
            responseVO.setCode(ConstantsUtil.RES_FAIL_CODE);
            responseVO.setMessage(ConstantsUtil.RES_FAIL_MESSAGE);
            return responseVO;
        }
    }


}
