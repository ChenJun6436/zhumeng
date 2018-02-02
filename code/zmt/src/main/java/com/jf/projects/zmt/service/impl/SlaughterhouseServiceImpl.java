package com.jf.projects.zmt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.jf.projects.zmt.dao.AndSlaughterhouseUserMapper;
import com.jf.projects.zmt.dao.SUserMapper;
import com.jf.projects.zmt.dao.SlaughterhouseMapper;
import com.jf.projects.zmt.model.AndSlaughterhouseUser;
import com.jf.projects.zmt.model.SUser;
import com.jf.projects.zmt.model.Slaughterhouse;
import com.jf.projects.zmt.service.AndSlaughterhouseUserService;
import com.jf.projects.zmt.service.SlaughterhouseService;
import com.jf.projects.zmt.service.UserService;
import com.jf.projects.zmt.util.ConstantsUtil;
import com.jf.projects.zmt.util.UUIDUtil;
import com.jf.projects.zmt.vo.OptionVo;
import com.jf.projects.zmt.vo.slaughterhouse.SlaughterhouseDetailsVo;
import com.jf.projects.zmt.vo.slaughterhouse.SlaughterhouseListVo;
import com.jf.projects.zmt.vo.slaughterhouse.SlaughterhouseUserDetailsVo;
import com.jf.projects.zmt.vo.slaughterhouse.SlaughterhouseVo;
import com.jf.projects.zmt.vo.user.UserSearch;

/**
 * @className: MarketServiceImpl
 * @description:用户实现
 * @author yt
 * @date 2017年10月19日下午5:11:18
 */

@Service
public class SlaughterhouseServiceImpl implements SlaughterhouseService {
    @Autowired
    private SlaughterhouseMapper dao;

    @Autowired
    private AndSlaughterhouseUserMapper andSlaughterhouseUserdao;

    @Autowired
    private SUserMapper userDao;

    @Autowired
    private UserService userService;

    @Autowired
    private AndSlaughterhouseUserService andSlaughterhouseUserService;

    @Override
    public List<SlaughterhouseVo> findSlaughterHouseUserByKey(UserSearch search) {
        List<SlaughterhouseVo> vos = userDao.findSlaughterHouseUserByKey(search);
        for (SlaughterhouseVo vo : vos) {
            if (vo.getUserId() != null) {
                vo.setAddress(userService.getAddressById(vo.getUserId()));
                Integer number = andSlaughterhouseUserdao.findCountByUserId(vo.getUserId());
                vo.setNumber(number == null ? 0 : number);
            }
        }
        return vos;
    }

    @Override
    public boolean add(Slaughterhouse vo) {
        try {

            vo.setId(UUIDUtil.getUUID());
            vo.setStatus(ConstantsUtil.STATUS_ENABLE);
            boolean flag = dao.insert(vo) > 0;
            AndSlaughterhouseUser avo = new AndSlaughterhouseUser();
            avo.setSlaughterhouseId(vo.getId());
            avo.setUserId(vo.getCreatorId());
            andSlaughterhouseUserService.addUserSlaughter(avo);
            return flag;
        } catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return false;
        }
    }

    @Override
    public List<SlaughterhouseListVo> findListByKey(UserSearch search) {
        List<SlaughterhouseListVo> vos = dao.findListByKey(search);
        for (SlaughterhouseListVo vo : vos) {
            Long number = andSlaughterhouseUserdao.findPeopleNumBySlaughterhouseId(vo.getId());
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
            Slaughterhouse s = new Slaughterhouse();
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
    public boolean update(Slaughterhouse vo) {
        try {
            return dao.update(vo) > 0;
        } catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return false;
        }
    }

    @Override
    public SlaughterhouseDetailsVo findDetailsById(String id) {
        SlaughterhouseDetailsVo vo = dao.findDetailsById(id);
        return vo;
    }

    @Override
    public SlaughterhouseUserDetailsVo findUserDetailsByKey(String userId) {
        SUser user = userDao.findById(userId);
        SlaughterhouseUserDetailsVo vo = new SlaughterhouseUserDetailsVo(user);
        Integer count = andSlaughterhouseUserdao.findCountById(userId);
        String address = userService.getAddressById(userId);
        vo.setSlaughterhouseId(andSlaughterhouseUserdao.getSlaughterhouseIdByUserId(userId));
        if (vo.getSlaughterhouseId() != null) {
            Slaughterhouse slaughterhouse = dao.findById(vo.getSlaughterhouseId());
            if (slaughterhouse != null) {
                String slaughterhouseName = slaughterhouse.getName();
                vo.setSlaughterhouseName(slaughterhouseName);
            }
        }
        vo.setAddress(address);
        vo.setCount(count == null ? 0 : count);
        return vo;
    }

    @Override
    public List<OptionVo> findOption() {

        return dao.findOption();
    }

    @Override
    public List<OptionVo> findUserOption(String userId) {
        return dao.findUserOption(userId);
    }

}
