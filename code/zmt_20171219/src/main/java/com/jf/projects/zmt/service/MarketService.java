package com.jf.projects.zmt.service;

import java.util.List;

import com.jf.projects.zmt.model.Market;
import com.jf.projects.zmt.vo.OptionVo;
import com.jf.projects.zmt.vo.market.MarketDetailsVo;
import com.jf.projects.zmt.vo.market.MarketListVo;
import com.jf.projects.zmt.vo.market.MarketPigVo;
import com.jf.projects.zmt.vo.market.MarketUserDetailsVo;
import com.jf.projects.zmt.vo.market.MarketVo;
import com.jf.projects.zmt.vo.user.UserSearch;

/**
 * @className: MarketService
 * @description:市场中心
 * @author yt
 * @date 2017年10月19日下午5:09:39
 */
public interface MarketService {
    /**
     * 检验中心人员列表
     * 
     * @param search
     * @return
     */
    List<MarketVo> findMarketUserByKey(UserSearch search);

    /**
     * 根据用户id查询详情
     * 
     * @param userId
     *            用户id
     * @return
     */

    public MarketUserDetailsVo findUserDetailsByKey(String userId);

    List<MarketPigVo> findListByPid(String id, String pigBreed, String pigId, Integer start,
                                    Integer length);

    long findCountById(String id);

    boolean add(Market vo);

    boolean update(Market vo);

    long findListCountByPid(String id, String pigBreed, String pigId, Integer start, Integer length);

    List<MarketListVo> findListByKey(UserSearch search);

    Long findListCountByKey(UserSearch search);

    boolean updateStatus(String id, String status);

    MarketDetailsVo findDetailsById(String id);

    /**
     * 获取市场下拉列表
     * 
     * @return
     */
    List<OptionVo> findOption();

    List<Market> findComListByKey(String key);
}
