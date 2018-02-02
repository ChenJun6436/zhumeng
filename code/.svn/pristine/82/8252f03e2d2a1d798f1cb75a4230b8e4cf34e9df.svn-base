package com.jf.projects.zmt.service;

import java.util.List;

import com.jf.projects.zmt.model.AndCheckoutPig;
import com.jf.projects.zmt.vo.BaseParam;
import com.jf.projects.zmt.vo.checkout.CheckoutPigsVo;
import com.jf.projects.zmt.vo.checkout.CheckoutPigtVo;

/**
 * @className: CheckoutService
 * @description:检验中心
 * @author yt
 * @date 2017年10月19日下午5:09:39
 */
public interface CheckoutPigService {

    CheckoutPigtVo findInfoByPigId(String pigId);

    boolean add(AndCheckoutPig vo);

    List<CheckoutPigsVo> findListByPid(BaseParam param);

    Long findListCountByPid(BaseParam param);

}
