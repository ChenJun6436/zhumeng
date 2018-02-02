package com.jf.projects.zmt.service;

import java.util.List;

import com.jf.projects.zmt.model.Checkout;
import com.jf.projects.zmt.vo.checkout.CheckoutDetailsVo;
import com.jf.projects.zmt.vo.checkout.CheckoutVo;
import com.jf.projects.zmt.vo.user.UserSearch;

/**
 * @className: CheckoutService
 * @description:检验中心
 * @author yt
 * @date 2017年10月19日下午5:09:39
 */
public interface CheckoutService {
    /**
     * 检验中心的查询
     * 当前页的数据
     * 
     * @param search
     * @return
     */
    public List<CheckoutVo> findUserByKey(UserSearch search);

    /**
     * 根据用户id查询详情
     * 
     * @param userId
     *            用户id
     * @return
     */
    public CheckoutDetailsVo findUserDetailsByKey(String userId);

    /**
     * 检验中心用户管理的猪列表
     * 
     * @param id
     *            用户id
     * @param start
     * @param length
     * @return
     */

    public List<Checkout> findListByPid(String id, String pigId, Integer start, Integer length);

    /**
     * 猪列表的总条数
     * 
     * @param id
     * @return
     */
    public Integer findCountById(String id);

    /**
     * 新增报告
     * 
     * @param vo
     * @return
     */
    public boolean add(Checkout vo);

    public boolean update(Checkout vo);

}
