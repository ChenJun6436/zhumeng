package com.jf.projects.zmt.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jf.projects.zmt.model.Slaughterhouse;
import com.jf.projects.zmt.vo.OptionVo;
import com.jf.projects.zmt.vo.home.SlaughterNumberVo;
import com.jf.projects.zmt.vo.slaughterhouse.SlaughterhouseDetailsVo;
import com.jf.projects.zmt.vo.slaughterhouse.SlaughterhouseListVo;
import com.jf.projects.zmt.vo.user.UserSearch;

public interface SlaughterhouseMapper extends BaseMapper<Slaughterhouse> {
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

    /**
     * 屠宰场详情
     * 
     * @param id
     * @return
     */
    SlaughterhouseDetailsVo findDetailsById(String id);

    /**
     * 根据区域和层级获取今日屠宰数
     * 
     * @param areaId
     *            区域id
     * @param type
     *            层级 1：省 2:市 3：区县 4：乡镇 5：村
     * @return
     */
    Integer countByAreaToday(@Param("areaId") Integer areaId, @Param("type") Integer type);

    /**
     * 统计一年每月的宰杀数
     * 
     * @param areaId
     *            区域id
     * @param type
     *            层级 1：省 2:市 3：区县 4：乡镇 5：村
     * @return
     */
    SlaughterNumberVo countSlaughterNumberForYear(@Param("areaId") Integer areaId,
                                                  @Param("type") Integer type);

    /**
     * 获取屠宰场下拉
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