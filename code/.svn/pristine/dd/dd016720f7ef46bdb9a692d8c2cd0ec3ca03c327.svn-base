package com.jf.projects.zmt.dao;

import java.util.List;

import com.jf.projects.zmt.model.AndCheckoutPig;
import com.jf.projects.zmt.vo.BaseParam;
import com.jf.projects.zmt.vo.OptionVo;
import com.jf.projects.zmt.vo.checkout.CheckoutPigsVo;
import com.jf.projects.zmt.vo.checkout.CheckoutPigtVo;
import com.jf.projects.zmt.vo.checkout.PidDetailsVo;

public interface AndCheckoutPigMapper extends BaseMapper<AndCheckoutPig> {

    CheckoutPigtVo findInfoByPigId(String pigId);

    List<CheckoutPigsVo> findListByPid(BaseParam param);

    Long findListCountByPid(BaseParam param);

    /**
     * 根据用户id统计该用户关联条数
     * 
     * @param userId
     * @return
     */
    Integer findCountByUserId(String userId);

    PidDetailsVo findPidDetails(String pigId);

    /**
     * 获取所有检验人员
     * 
     * @return
     */
    List<OptionVo> getUsers();

}