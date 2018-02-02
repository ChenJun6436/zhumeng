package com.zmt.zmtofficialwebsite.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zmt.zmtofficialwebsite.dao.CaseDao;
import com.zmt.zmtofficialwebsite.model.Case;
import com.zmt.zmtofficialwebsite.service.CaseService;
import com.zmt.zmtofficialwebsite.vo.CaseVo;
import com.zmt.zmtofficialwebsite.vo.Home_CaseVo;

/**
 * 描述: 案例管理
 *
 * @author dengpeng
 * @create 2018-01-09 14:43
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class CaseServiceImpl implements CaseService {

    @Autowired
    private CaseDao dao;

    @Override
    public List<CaseVo> findByAanvraagTypeId(Long aanvraagTypeId, Integer page, Integer size) {

        return dao.findByAanvraagTypeId(aanvraagTypeId, new PageRequest(page, size,
                                                                        Sort.Direction.ASC,
                                                                        "createTime"));
    }

    @Override
    public Case save(Case pojo) {
        Date now = new Date();
        if (pojo.getId() == null) pojo.setCreateTime(now);
        pojo.setLastUpdateTime(now);
        return dao.save(pojo);
    }

    @Override
    public void del(Long id) {
        dao.delete(id);

    }

    @Override
    public CaseVo findVoByAanvraagTypeId(Long aanvraagTypeId) {
        List<CaseVo> vos = dao.findVoByAanvraagTypeId(aanvraagTypeId);
        return vos != null && vos.size() > 0 ? vos.get(0) : null;
    }

    /**
     * 首页成功案例查询
     */
    @Override
    public List<Home_CaseVo> findByHomePage() {
        return dao.findByHomePage();
    }

    @Override
    public Case findDetails(Long id) {
        return dao.findOne(id);
    }

    @Override
    public Integer getCount(Long aanvraagTypeId) {

        return dao.getCount(aanvraagTypeId);
    }

}
