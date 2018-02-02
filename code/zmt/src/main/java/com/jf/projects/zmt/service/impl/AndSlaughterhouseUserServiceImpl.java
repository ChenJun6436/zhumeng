package com.jf.projects.zmt.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.jf.projects.zmt.dao.AndSlaughterhouseUserMapper;
import com.jf.projects.zmt.dao.PigFlowMapper;
import com.jf.projects.zmt.dao.SUserMapper;
import com.jf.projects.zmt.dao.SlaughterhouseMapper;
import com.jf.projects.zmt.model.AndSlaughterhouseUser;
import com.jf.projects.zmt.model.PigFile;
import com.jf.projects.zmt.model.PigFlow;
import com.jf.projects.zmt.model.Slaughterhouse;
import com.jf.projects.zmt.service.AndSlaughterhouseUserService;
import com.jf.projects.zmt.service.PigFileService;
import com.jf.projects.zmt.service.UserService;
import com.jf.projects.zmt.util.UUIDUtil;
import com.jf.projects.zmt.vo.BaseParam;
import com.jf.projects.zmt.vo.slaughterhouse.SlaughterhousePigVo;

/**
 * @className: MarketServiceImpl
 * @description:用户实现
 * @author yt
 * @date 2017年10月19日下午5:11:18
 */

@Service
public class AndSlaughterhouseUserServiceImpl implements AndSlaughterhouseUserService {

    @Autowired
    private AndSlaughterhouseUserMapper dao;

    @Autowired
    private SlaughterhouseMapper slaughterhouseDao;

    @Autowired
    private PigFileService pigFileService;

    @Autowired
    private PigFlowMapper pigFlowDao;

    @Autowired
    private SUserMapper userMapper;

    @Autowired
    private UserService userService;

    @Override
    public boolean add(AndSlaughterhouseUser vo) {
        try {
            vo.setId(UUIDUtil.getUUID());

            PigFile p = new PigFile();
            p.setPigId(vo.getPigId());
            p.setSlaughterhouseId(vo.getSlaughterhouseId());
            pigFileService.updateAllByPigId(p);
            pigFileService.updateStatus(vo.getPigId(), 2);
            // 插入流程表
            PigFlow pigFlow = new PigFlow();
            pigFlow.setId(UUIDUtil.getUUID());
            if (vo.getUserId() != null) pigFlow.setAddress(userService.getAddressById(vo.getUserId()));
            pigFlow.setCreateId(vo.getUserId());
            if (vo.getUserId() != null) pigFlow.setCreaterName(userMapper.findById(vo.getUserId())
                                                                         .getName());
            pigFlow.setDescription("屠宰录入");
            pigFlow.setPigId(vo.getPigId());
            pigFlow.setStatus("宰前待检验");
            pigFlow.setThing("屠宰录入");
            pigFlow.setType("2");
            pigFlow.setUserId(vo.getSlaughterhouseId());
            pigFlowDao.insert(pigFlow);
            return dao.insert(vo) > 0;
        } catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return false;
        }
    }

    @Override
    public List<SlaughterhousePigVo> findListByPid(BaseParam param) {

        return dao.findListByPid(param);
    }

    @Override
    public Long findListCountByPid(BaseParam param) {

        return dao.findListCountByPid(param);
    }

    @Override
    public boolean slaughter(String id, String slaughterhouseId) {
        try {
            Slaughterhouse slaughterhouse = slaughterhouseDao.findById(slaughterhouseId);
            slaughterhouse.setNumber(slaughterhouse.getNumber() == null ? 0
                                                                       : slaughterhouse.getNumber() + 1);
            slaughterhouseDao.update(slaughterhouse);
            AndSlaughterhouseUser vo = dao.findById(id);
            vo.setUpdateTime(new Date());
            dao.update(vo);
            pigFileService.updateStatus(vo.getPigId(), 4);

            PigFlow pigFlow = new PigFlow();
            pigFlow.setId(UUIDUtil.getUUID());
            pigFlow.setAddress(slaughterhouse.getAddress());
            pigFlow.setCreateId(vo.getUserId());
            pigFlow.setCreaterName(userMapper.findById(vo.getUserId()).getName());
            pigFlow.setDescription("生猪屠宰");
            pigFlow.setPigId(vo.getPigId());
            pigFlow.setStatus("宰后待检验");
            pigFlow.setThing("生猪屠宰");
            pigFlow.setType("2");
            pigFlow.setUserId(slaughterhouseId);

            return pigFlowDao.insert(pigFlow) > 0;
        } catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return false;
        }
    }

    @Override
    public Long findPeopleNumBySlaughterhouseId(String slaughterhouseId) {
        return dao.findPeopleNumBySlaughterhouseId(slaughterhouseId);
    }

    @Override
    public boolean addUserSlaughter(AndSlaughterhouseUser vo) {
        try {
            vo.setId(UUIDUtil.getUUID());
            vo.setCreateTime(new Date());
            vo.setUpdateTime(new Date());

            return dao.insert(vo) > 0;
        } catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return false;
        }
    }

    @Override
    public boolean existPigId(String pigId) {
        boolean res = dao.existPigId(pigId);
        return res;
    }

    @Override
    public List<SlaughterhousePigVo> findList(BaseParam param) {

        return dao.findList(param);
    }

    @Override
    public boolean existByUserId(String userId) {
        return dao.existByUserId(userId);
    }
}
