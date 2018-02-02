package com.jf.projects.zmt.dao;

import java.util.List;

import com.jf.projects.zmt.model.AndMarketUser;
import com.jf.projects.zmt.vo.BaseParam;
import com.jf.projects.zmt.vo.OptionVo;
import com.jf.projects.zmt.vo.market.MarketPigVo;

public interface AndMarketUserMapper extends BaseMapper<AndMarketUser> {

    Long findNumberById(String id);

    Integer findCountById(String userId);

    List<MarketPigVo> findListByPid(BaseParam param);

    Long findListCountByPid(BaseParam param);

    Integer findCountByUserId(String userId);

    boolean existPigId(String pigId);

    /**
     * 根据人员统计市场
     * 
     * @param userId
     * @return
     */
    Integer findCountByUser(String userId);

    /**
     * 根据市场id获取市场人员列表
     * 下拉列表使用
     * 
     * @param marketId
     * @return
     */
    List<OptionVo> getMaketPersons(String marketId);

    /**
     * 查询市场人数
     * 
     * @param marketId
     *            市场id
     * @return
     */
    Long findPeopleNumByMarketId(String marketId);

    /**
     * 根据人员获取市场列表 combox用
     * 
     * @param userId
     * @return
     */
    List<OptionVo> findUserOption(String userId);

    List<MarketPigVo> findList(BaseParam param);

}