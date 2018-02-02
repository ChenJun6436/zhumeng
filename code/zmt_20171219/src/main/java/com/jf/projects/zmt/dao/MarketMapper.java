package com.jf.projects.zmt.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jf.projects.zmt.model.Market;
import com.jf.projects.zmt.vo.BaseParam;
import com.jf.projects.zmt.vo.OptionVo;
import com.jf.projects.zmt.vo.home.SaleNumberVo;
import com.jf.projects.zmt.vo.market.MarketDetailsVo;
import com.jf.projects.zmt.vo.market.MarketListVo;
import com.jf.projects.zmt.vo.market.MarketPigVo;
import com.jf.projects.zmt.vo.market.MarketVo;
import com.jf.projects.zmt.vo.user.UserSearch;

public interface MarketMapper extends BaseMapper<Market> {

    MarketVo findCountById(String userId);

    List<MarketPigVo> findListByPid(BaseParam param);

    /**
     * 根据区域和层级获取销售总数
     * 
     * @param areaId
     *            区域id
     * @param type
     *            层级 1：省 2:市 3：区县 4：乡镇 5：村
     * @return
     */
    Integer countByArea(@Param("areaId") Integer areaId, @Param("type") Integer type);

    /**
     * 统计一年每月的销售数
     * 
     * @param areaId
     * @param type
     * @return
     */
    SaleNumberVo countSaleNumberForYear(@Param("areaId") Integer areaId, @Param("type") Integer type);

    long findListCountByPid(BaseParam baseParam);

    /**
     * 查询市场
     * 
     * @param search
     * @return
     */
    List<MarketListVo> findListByKey(UserSearch search);

    /**
     * 查询市场总条数
     * 
     * @param search
     * @return
     */
    Long findListCountByKey(UserSearch search);

    /**
     * 市场详情
     * 
     * @param id
     * @return
     */
    MarketDetailsVo findDetailsById(String id);

    /**
     * 获取市场下拉选择列表
     * 
     * @return
     */
    List<OptionVo> findOption();

    List<Market> findComListByKey(String key);
}