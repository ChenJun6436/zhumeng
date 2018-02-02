package com.jf.projects.zmt.service;

import java.util.List;

import com.jf.projects.zmt.model.AndMarketUser;
import com.jf.projects.zmt.model.Market;
import com.jf.projects.zmt.vo.BaseParam;
import com.jf.projects.zmt.vo.OptionVo;
import com.jf.projects.zmt.vo.market.MarketPigVo;

/**
 * @className: MarketService
 * @description：屠宰场
 * @author yt
 * @date 2017年10月19日下午5:09:39
 */
public interface AndMarketUserService {

    boolean add(AndMarketUser vo);

    /**
     * 用户管理的猪列表
     * 
     * @param param
     * @return
     */
    List<MarketPigVo> findListByPid(BaseParam param);

    /**
     * 猪列表总条数
     * 
     * @param search
     * @return
     */
    Long findListCountByPid(BaseParam param);

    /**
     * 查询市场人数
     * 
     * @param id
     *            屠宰场id
     * @return
     */
    Long findNumberById(String id);

    boolean addUserMarket(AndMarketUser vo);

    boolean existPigId(String pigId);

    /**
     * 根据市场id获取市场人员列表
     * 下拉列表使用
     * 
     * @param marketId
     * @return
     */
    List<OptionVo> getMaketPersons(String marketId);

    List<OptionVo> findUserOption(String userId);

    /**
     * 根据用户id获取市场
     * 
     * @param userId
     * @return
     */
    Market getMaketByUser(String userId);

    List<MarketPigVo> findList(BaseParam param);

}
