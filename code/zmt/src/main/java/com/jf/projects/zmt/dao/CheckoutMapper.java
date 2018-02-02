package com.jf.projects.zmt.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jf.projects.zmt.model.Checkout;
import com.jf.projects.zmt.vo.BaseParam;
import com.jf.projects.zmt.vo.checkout.CheckoutVo;

public interface CheckoutMapper extends BaseMapper<Checkout> {
    public List<CheckoutVo> findCount(@Param(value = "ids") List<String> ids);

    public CheckoutVo findCountById(@Param(value = "id") String id);

    public List<Checkout> findListByPid(BaseParam param);

}