package com.jf.projects.zmt.service;

import java.util.List;

import com.jf.projects.zmt.model.Slaughterhouse;
import com.jf.projects.zmt.vo.OptionVo;
import com.jf.projects.zmt.vo.slaughterhouse.SlaughterhouseDetailsVo;
import com.jf.projects.zmt.vo.slaughterhouse.SlaughterhouseListVo;
import com.jf.projects.zmt.vo.slaughterhouse.SlaughterhouseUserDetailsVo;
import com.jf.projects.zmt.vo.slaughterhouse.SlaughterhouseVo;
import com.jf.projects.zmt.vo.user.UserSearch;

/**
 * @className: SlaughterhouseService
 * @description：屠宰场
 * @author yt
 * @date 2017年10月19日下午5:09:39
 */
public interface SlaughterhouseService {
    /**
     * 屠宰场人员列表
     * 
     * @param search
     * @return
     */
    List<SlaughterhouseVo> findSlaughterHouseUserByKey(UserSearch search);

    /**
     * 屠宰场列表
     * 
     * @param key
     *            屠宰场名称，负责人，联系方式
     * @return
     */
    List<SlaughterhouseListVo> findListByKey(UserSearch search);

    /**
     * 屠宰场列表总条数
     * 
     * @param search
     * @return
     */
    Long findListCountByKey(UserSearch search);

    boolean add(Slaughterhouse vo);

    boolean updateStatus(String id, String status);

    boolean update(Slaughterhouse vo);

    /**
     * 屠宰场详情
     * 
     * @param id
     * @return
     */
    SlaughterhouseDetailsVo findDetailsById(String id);

    /**
     * 用户详情
     * 
     * @param userId
     * @return
     */
    SlaughterhouseUserDetailsVo findUserDetailsByKey(String userId);

    /**
     * 获取屠宰场下拉数据
     * 
     * @return
     */
    List<OptionVo> findOption();

    /**
     * 获取用户的屠宰场下拉数据
     * 
     * @return
     */
    List<OptionVo> findUserOption(String userId);

}
