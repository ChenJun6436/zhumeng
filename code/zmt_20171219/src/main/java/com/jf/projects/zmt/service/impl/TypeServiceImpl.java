package com.jf.projects.zmt.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jf.projects.zmt.dao.TypeMapper;
import com.jf.projects.zmt.model.Type;
import com.jf.projects.zmt.service.TypeService;
import com.jf.projects.zmt.util.ConstantsUtil;
import com.jf.projects.zmt.vo.ResponseVO;

/**
 * @className: TypeServiceImpl
 * @description:角色类型实现
 * @author wj
 * @date 2017年10月19日下午5:11:18
 */

@Service
public class TypeServiceImpl implements TypeService {

    @Autowired
    private TypeMapper typeMapper;

    @Override
    public List<Type> findAll() {
        return typeMapper.findAll();
    }

    @Override
    public List<Type> findByName(String name) {
        return typeMapper.findByName(name);
    }

    @Override
    public ResponseVO updateType(String typeId, String name) {
        // 查询数据库是否已存在此name的数据
        ResponseVO resVO = new ResponseVO();
        try {
            List<Type> list = typeMapper.findByName(name);
            if (list != null && list.size() > 0) {
                resVO.setCode(ConstantsUtil.RES_PARAMER_FAIL_CODE);
                resVO.setMessage("已存在此类型！");
                return resVO;
            } else {
                // 查询是否存在此ID数据
                Type typeVO = typeMapper.findById(typeId);
                if (typeVO == null) {
                    resVO.setCode(ConstantsUtil.RES_PARAMER_FAIL_CODE);
                    resVO.setMessage(ConstantsUtil.RES_PARAMER_FAIL_MESSAGE);
                    return resVO;
                }
                // 更新用户角色类型名称
                typeVO.setName(name);
                typeMapper.update(typeVO);
                resVO.setCode(ConstantsUtil.RES_SUCCESS_CODE);
                resVO.setMessage(ConstantsUtil.RES_SUCCESS_MESSAGE);
                return resVO;
            }
        } catch (Exception e) {
            e.printStackTrace();
            resVO.setCode(ConstantsUtil.RES_FAIL_CODE);
            resVO.setMessage(ConstantsUtil.RES_FAIL_MESSAGE);
            return resVO;
        }
    }
      


    @Override
    public ResponseVO addType(String name) {
        
        // 查询数据库是否已存在此name的数据
        ResponseVO resVO = new ResponseVO();
        Type type = new Type();
        try{
            List<Type> list = typeMapper.findByName(name);
            if (list != null && list.size() > 0) {
                resVO.setCode(ConstantsUtil.RES_PARAMER_FAIL_CODE);
                resVO.setMessage("已存在此类型！");
                return resVO;
            } else {
                // 新增用户角色类型
                type.setId(UUID.randomUUID().toString());
                type.setName(name);
                typeMapper.insert(type);
                resVO.setCode(ConstantsUtil.RES_SUCCESS_CODE);
                resVO.setMessage(ConstantsUtil.RES_SUCCESS_MESSAGE);
                return resVO;
            }
        } catch (Exception e) {
            e.printStackTrace();
            resVO.setCode(ConstantsUtil.RES_FAIL_CODE);
            resVO.setMessage(ConstantsUtil.RES_FAIL_MESSAGE);
            return resVO;
        }
        
    }

}
