package com.jf.projects.zmt.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.jf.projects.zmt.dao.CheckoutMapper;
import com.jf.projects.zmt.dao.SUserMapper;
import com.jf.projects.zmt.model.Checkout;
import com.jf.projects.zmt.model.SUser;
import com.jf.projects.zmt.service.CheckoutService;
import com.jf.projects.zmt.service.EntryAreaService;
import com.jf.projects.zmt.service.UserService;
import com.jf.projects.zmt.vo.BaseParam;
import com.jf.projects.zmt.vo.checkout.CheckoutDetailsVo;
import com.jf.projects.zmt.vo.checkout.CheckoutVo;
import com.jf.projects.zmt.vo.user.UserSearch;
import com.jf.projects.zmt.vo.user.UserVo;

/**
 * @className: UserServiceImpl
 * @description:用户实现
 * @author yt
 * @date 2017年10月19日下午5:11:18
 */

@Service
public class CheckoutServiceImpl implements CheckoutService {
    @Autowired
    private CheckoutMapper dao;

    @Autowired
    private UserService userService;

    @Autowired
    private SUserMapper userDao;

    @Autowired
    private EntryAreaService entryAreaService;

    @Override
    public List<CheckoutVo> findUserByKey(UserSearch search) {
        List<UserVo> vos = userService.findUserByKey(search);

        List<String> ids = new ArrayList<String>();

        for (UserVo userVo : vos) {
            ids.add(userVo.getUserId());
        }
        List<CheckoutVo> newVos = new ArrayList<CheckoutVo>();
        if (ids == null || ids.size() == 0) {
            for (UserVo userVo : vos) {
                CheckoutVo vo = new CheckoutVo(userVo);
                vo.setOperaterId(userVo.getUserId());
                vo.setCount(0);
                vo.setId(userVo.getUserId());
                newVos.add(vo);
            }
            return newVos;

        }
        List<CheckoutVo> cvos = dao.findCount(ids);

        for (UserVo userVo : vos) {
            for (CheckoutVo checkoutVo : cvos) {
                CheckoutVo vo = new CheckoutVo(userVo);
                if (userVo.getUserId() != null && checkoutVo != null
                    && userVo.getUserId().equals(checkoutVo.getOperaterId())) {
                    vo.setOperaterId(checkoutVo.getOperaterId());
                    vo.setCount(checkoutVo.getCount());
                    vo.setId(checkoutVo.getOperaterId());
                }
                newVos.add(vo);
            }
        }
        return newVos;
    }

    @Override
    public CheckoutDetailsVo findUserDetailsByKey(String userId) {
        SUser user = userDao.findById(userId);
        CheckoutDetailsVo vo = new CheckoutDetailsVo(user);
        CheckoutVo cvo = dao.findCountById(userId);
        vo.setCount(cvo == null ? 0 : cvo.getCount());
        return vo;
    }

    @Override
    public List<Checkout> findListByPid(String id, String pigId, Integer start, Integer length) {

        return dao.findListByPid(new BaseParam(id, pigId, start, length));
    }

    @Override
    public Integer findCountById(String id) {
        // TODO Auto-generated method stub
        CheckoutVo vo = dao.findCountById(id);
        Integer count = 0;
        if (vo != null) {
            count = vo.getCount();
        }

        return count;
    }

    @Override
    public boolean add(Checkout vo) {
        try {
            vo.setId(UUID.randomUUID().toString());
            return dao.insert(vo) > 0;
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return false;
        }
    }

    @Override
    public boolean update(Checkout vo) {
        try {
            return dao.update(vo) > 0;
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return false;
        }
    }
}
