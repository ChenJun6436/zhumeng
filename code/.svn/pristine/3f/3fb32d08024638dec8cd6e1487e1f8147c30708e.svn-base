package com.jf.projects.zmt.service.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jf.projects.zmt.dao.AndRoleResourceMapper;
import com.jf.projects.zmt.dao.SResourceMapper;
import com.jf.projects.zmt.model.SResource;
import com.jf.projects.zmt.service.ResourceService;
import com.jf.projects.zmt.vo.resource.ResourceVo;

/**
 * 
 * @className: ResourceServiceImpl
 *
 * @description:资源实现
 *
 * @author wj
 *
 * @date 2017年10月31日下午4:00:39
 *
 */

@Service
public class ResourceServiceImpl implements ResourceService {

    @Autowired
    private SResourceMapper sResourceMapper;
    @Autowired
    private AndRoleResourceMapper AndRoleResourceMapper;

    @Override
    public List<SResource> findAll() {
        return sResourceMapper.findAll();
    }

    @Override
    public List<ResourceVo> findResourceByRoleId(String roleId) {
        return AndRoleResourceMapper.findResourceByRoleId(roleId);
    }


}
