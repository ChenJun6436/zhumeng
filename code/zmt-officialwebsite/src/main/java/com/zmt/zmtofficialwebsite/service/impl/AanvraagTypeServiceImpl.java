package com.zmt.zmtofficialwebsite.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zmt.zmtofficialwebsite.dao.AanvraagTypeDao;
import com.zmt.zmtofficialwebsite.dao.CaseDao;
import com.zmt.zmtofficialwebsite.model.AanvraagType;
import com.zmt.zmtofficialwebsite.service.AanvraagTypeService;
import com.zmt.zmtofficialwebsite.util.result.ResultVo;
import com.zmt.zmtofficialwebsite.vo.AanvraagTypeVo;
import com.zmt.zmtofficialwebsite.vo.CaseNumVo;

/**
 * 描述: 案例管理
 *
 * @author dengpeng
 * @create 2018-01-09 14:43
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class AanvraagTypeServiceImpl implements AanvraagTypeService {

    @Autowired
    private AanvraagTypeDao dao;

    @Autowired
    private CaseDao caseDao;

    @Override
    public ResultVo findAll() {
        List<AanvraagType> pojos = dao.findAll();
        List<AanvraagTypeVo> vos = new ArrayList<AanvraagTypeVo>();
        List<CaseNumVo> cvos = caseDao.findCaseNum();

        for (AanvraagType pojo : pojos) {
            AanvraagTypeVo vo = new AanvraagTypeVo();
            vo.setId(pojo.getId());
            vo.setName(pojo.getName());
            for (CaseNumVo caseNumVo : cvos) {
                if (pojo.getId() != null && pojo.getId().equals(caseNumVo.getId())) {
                    vo.setNum(caseNumVo.getNum().intValue());
                }
            }
            vos.add(vo);
        }

        return new ResultVo(vos);
    }
}
