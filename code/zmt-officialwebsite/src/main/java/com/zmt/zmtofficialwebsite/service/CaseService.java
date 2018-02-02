package com.zmt.zmtofficialwebsite.service;

import java.util.List;

import com.zmt.zmtofficialwebsite.model.Case;
import com.zmt.zmtofficialwebsite.vo.CaseVo;
import com.zmt.zmtofficialwebsite.vo.Home_CaseVo;

public interface CaseService {

    /**
     * 根据案例类型查案例
     */
    List<CaseVo> findByAanvraagTypeId(Long aanvraagTypeId, Integer page, Integer size);

    Integer getCount(Long aanvraagTypeId);

    /**
     * 新增案例
     */
    Case save(Case pojo);

    /**
     * 删除案例
     */
    void del(Long id);

    /**
     * 首页成功案例查询
     */
    List<Home_CaseVo> findByHomePage();

    CaseVo findVoByAanvraagTypeId(Long aanvraagTypeId);

    Case findDetails(Long id);
}
