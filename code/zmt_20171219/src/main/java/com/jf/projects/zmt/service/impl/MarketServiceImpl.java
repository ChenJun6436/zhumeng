package com.jf.projects.zmt.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.jf.projects.zmt.dao.AndMarketUserMapper;
import com.jf.projects.zmt.dao.MarketMapper;
import com.jf.projects.zmt.dao.SUserMapper;
import com.jf.projects.zmt.model.Market;
import com.jf.projects.zmt.model.SUser;
import com.jf.projects.zmt.service.MarketService;
import com.jf.projects.zmt.service.UserService;
import com.jf.projects.zmt.util.ConstantsUtil;
import com.jf.projects.zmt.vo.BaseParam;
import com.jf.projects.zmt.vo.OptionVo;
import com.jf.projects.zmt.vo.market.MarketDetailsVo;
import com.jf.projects.zmt.vo.market.MarketListVo;
import com.jf.projects.zmt.vo.market.MarketPigVo;
import com.jf.projects.zmt.vo.market.MarketUserDetailsVo;
import com.jf.projects.zmt.vo.market.MarketVo;
import com.jf.projects.zmt.vo.user.UserSearch;

/**
 * @className: MarketServiceImpl
 * @description:用户实现
 * @author yt
 * @date 2017年10月19日下午5:11:18
 */

@Service
public class MarketServiceImpl implements MarketService {
    @Autowired
    private MarketMapper dao;

    @Autowired
    private SUserMapper userDao;

    @Autowired
    private AndMarketUserMapper andMarketUserDao;

    @Autowired
    private UserService userService;

    @Override
    public List<MarketVo> findMarketUserByKey(UserSearch search) {
        List<MarketVo> vos = userDao.findMarketUserByKey(search);
        for (MarketVo marketVo : vos) {

            if (marketVo.getUserId() != null) {
                marketVo.setAddress(userService.getAddressById(marketVo.getUserId()));
                Integer number = andMarketUserDao.findCountByUserId(marketVo.getUserId());
                marketVo.setNumber(number == null ? 0 : number);
            }
        }
        return vos;
    }

    @Override
    public MarketUserDetailsVo findUserDetailsByKey(String userId) {
        SUser user = userDao.findById(userId);
        MarketUserDetailsVo vo = new MarketUserDetailsVo(user);
        Integer count = andMarketUserDao.findCountById(userId);
        vo.setCount(count == null ? 0 : count);
        return vo;
    }

    @Override
    public List<MarketPigVo> findListByPid(String id, String pigBreed, String pigId, Integer start,
                                           Integer length) {

        return dao.findListByPid(new BaseParam(id, pigBreed, pigId, start, length));
    }

    @Override
    public long findCountById(String id) {
        MarketVo vo = dao.findCountById(id);
        Integer count = 0;
        if (vo != null) {
            count = vo.getNumber();
        }

        return count;
    }

    @Override
    public boolean add(Market vo) {
        try {
            vo.setId(UUID.randomUUID().toString());
            vo.setStatus(ConstantsUtil.STATUS_ENABLE);
            vo.setNumber(0);
            return dao.insert(vo) > 0;
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return false;
        }
    }

    @Override
    public boolean update(Market vo) {
        try {

            return dao.update(vo) > 0;
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return false;
        }
    }

    @Override
    public long findListCountByPid(String id, String pigBreed, String pigId, Integer start,
                                   Integer length) {
        return dao.findListCountByPid(new BaseParam(id, pigBreed, pigId, start, length));
    }

    @Override
    public List<MarketListVo> findListByKey(UserSearch search) {
        List<MarketListVo> vos = dao.findListByKey(search);
        for (MarketListVo vo : vos) {
            Long number = andMarketUserDao.findPeopleNumByMarketId(vo.getId());
            vo.setNumber(number == null ? 0 : number);
        }
        return vos;
    }

    @Override
    public Long findListCountByKey(UserSearch search) {
        return dao.findListCountByKey(search);
    }

    @Override
    public boolean updateStatus(String id, String status) {
        try {
            Market s = new Market();
            s.setId(id);
            s.setStatus(status);
            return dao.update(s) > 0;
        } catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return false;
        }
    }

    @Override
    public MarketDetailsVo findDetailsById(String id) {
        MarketDetailsVo vo = dao.findDetailsById(id);
        Long number = andMarketUserDao.findPeopleNumByMarketId(vo.getId());
        vo.setNumber(number == null ? 0 : number.intValue());
        return vo;
    }

    @Override
    public List<OptionVo> findOption() {

        return dao.findOption();
    }

    @Override
    public List<Market> findComListByKey(String key) {

        return dao.findComListByKey(key);
    }
}
