package com.jf.projects.zmt.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.jf.projects.zmt.dao.AndMarketUserMapper;
import com.jf.projects.zmt.dao.MarketMapper;
import com.jf.projects.zmt.dao.PigFlowMapper;
import com.jf.projects.zmt.dao.SUserMapper;
import com.jf.projects.zmt.model.AndMarketUser;
import com.jf.projects.zmt.model.Market;
import com.jf.projects.zmt.model.PigFile;
import com.jf.projects.zmt.model.PigFlow;
import com.jf.projects.zmt.service.AndMarketUserService;
import com.jf.projects.zmt.service.PigFileService;
import com.jf.projects.zmt.service.UserService;
import com.jf.projects.zmt.util.UUIDUtil;
import com.jf.projects.zmt.vo.BaseParam;
import com.jf.projects.zmt.vo.OptionVo;
import com.jf.projects.zmt.vo.market.MarketPigVo;

/**
 * @className: MarketServiceImpl
 * @description:用户实现
 * @author yt
 * @date 2017年10月19日下午5:11:18
 */

@Service
public class AndMarketUserServiceImpl implements AndMarketUserService {

    @Autowired
    private AndMarketUserMapper dao;

    @Autowired
    private MarketMapper MarketDao;

    @Autowired
    private PigFileService pigFileService;

    @Autowired
    private PigFlowMapper pigFlowDao;

    @Autowired
    private SUserMapper userMapper;

    @Autowired
    private UserService userService;

    @Override
    public boolean add(AndMarketUser vo) {

        try {

            vo.setId(UUIDUtil.getUUID());
            vo.setCreateTime(new Date());
            vo.setUpdateTime(new Date());
            PigFile p = new PigFile();
            p.setPigId(vo.getPigId());
            p.setMarketId(vo.getMarketId());
            pigFileService.updateAllByPigId(p);
            pigFileService.updateStatus(vo.getPigId(), 7);

            PigFlow pigFlow = new PigFlow();
            pigFlow.setId(UUIDUtil.getUUID());

            if (vo.getUserId() != null) pigFlow.setAddress(userService.getAddressById(vo.getUserId()));
            pigFlow.setCreateId(vo.getUserId());
            if (vo.getUserId() != null) pigFlow.setCreaterName(userMapper.findById(vo.getUserId())
                                                                         .getName());
            pigFlow.setDescription("生猪销售");
            pigFlow.setPigId(vo.getPigId());
            pigFlow.setStatus("已销售");
            pigFlow.setThing("已销售");
            pigFlow.setType("4");
            pigFlow.setUserId(vo.getMarketId());
            pigFlowDao.insert(pigFlow);
            return dao.insert(vo) > 0;
        } catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return false;
        }
    }

    @Override
    public List<MarketPigVo> findListByPid(BaseParam param) {

        return dao.findListByPid(param);
    }

    @Override
    public Long findListCountByPid(BaseParam param) {

        return dao.findListCountByPid(param);
    }

    @Override
    public Long findNumberById(String id) {
        return dao.findNumberById(id);
    }

    @Override
    public boolean addUserMarket(AndMarketUser vo) {
        try {
            vo.setId(UUIDUtil.getUUID());
            vo.setCreateTime(new Date());
            vo.setUpdateTime(new Date());
            Market market = MarketDao.findById(vo.getMarketId());
            Integer number = market.getNumber();
            market.setNumber(number == null ? 1 : ++number);
            MarketDao.update(market);
            return dao.insert(vo) > 0;
        } catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return false;
        }
    }

    @Override
    public boolean existPigId(String pigId) {
        // TODO Auto-generated method stub
        return dao.existPigId(pigId);
    }

    @Override
    public List<OptionVo> getMaketPersons(String marketId) {
        // TODO Auto-generated method stub
        return dao.getMaketPersons(marketId);
    }

    @Override
    public List<OptionVo> findUserOption(String userId) {
        // TODO Auto-generated method stub
        return dao.findUserOption(userId);
    }

    @Override
    public Market getMaketByUser(String userId) {
        List<OptionVo> ops = dao.findUserOption(userId);
        if (ops != null && ops.size() > 0) {
            Market market = MarketDao.findById(ops.get(0).getKey());
            return market;
        }
        return null;
    }

    @Override
    public List<MarketPigVo> findList(BaseParam param) {
        // TODO Auto-generated method stub
        return dao.findList(param);
    }
}
