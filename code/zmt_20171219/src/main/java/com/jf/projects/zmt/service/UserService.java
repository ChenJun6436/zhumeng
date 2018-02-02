package com.jf.projects.zmt.service;

import java.util.List;

import com.jf.projects.zmt.vo.user.UserSearch;
import com.jf.projects.zmt.vo.user.UserVo;

/**
 * @className: UserService
 * @description:用户
 * @author yt
 * @date 2017年10月19日下午5:09:39
 */
public interface UserService {
    /**
     * 检验中心用户列表
     * 
     * @param search
     * @return
     */
    List<UserVo> findUserByKey(UserSearch search);

    /**
     * 用户列表的总条数
     * 
     * @param search
     * @return
     */
    Long findUserCountByKey(UserSearch search);

    /**
     * 根据用户id获取地址全称
     * 
     * @param userId
     * @return
     */
    String getAddressById(String userId);

    /**
     * 市场用户列表的总条数
     * 
     * @param search
     * @return
     */
    Long findMarketUserCountByKey(UserSearch search);

    /**
     * 屠宰场用户列表的总条数
     * 
     * @param search
     * @return
     */
    Long findSlaughterHouseUserCountByKey(UserSearch search);
}
