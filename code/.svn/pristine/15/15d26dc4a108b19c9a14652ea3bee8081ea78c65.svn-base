package com.jf.projects.zmt.dao;

import java.util.List;

import com.jf.projects.zmt.model.AndSlaughterhouseUser;
import com.jf.projects.zmt.vo.BaseParam;
import com.jf.projects.zmt.vo.slaughterhouse.SlaughterhousePigVo;

public interface AndSlaughterhouseUserMapper extends BaseMapper<AndSlaughterhouseUser> {
    /**
     * 用户屠宰数量
     * 
     * @param userId
     * @return
     */
    Integer findCountById(String userId);

    /**
     * 根据用户统计屠宰场数据
     * 
     * @param userId
     * @return
     */
    Integer findCountByUser(String userId);

    /**
     * 用户管理的猪列表
     * 
     * @param param
     * @return
     */
    List<SlaughterhousePigVo> findListByPid(BaseParam param);

    /**
     * 猪列表总条数
     * 
     * @param search
     * @return
     */
    Long findListCountByPid(BaseParam param);

    /**
     * 查询屠宰场人数
     * 
     * @param slaughterhouseId
     *            屠宰场id
     * @return
     */
    Long findPeopleNumBySlaughterhouseId(String slaughterhouseId);

    /**
     * 根据用户id删除
     * 
     * @param userId
     */
    void deleteByUserId(String userId);

    Integer findCountByUserId(String userId);

    boolean existPigId(String pigId);

    List<SlaughterhousePigVo> findList(BaseParam param);

}