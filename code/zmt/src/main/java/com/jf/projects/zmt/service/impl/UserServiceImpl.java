package com.jf.projects.zmt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.jf.projects.zmt.dao.AreaMapper;
import com.jf.projects.zmt.dao.EntryAreaMapper;
import com.jf.projects.zmt.dao.SUserMapper;
import com.jf.projects.zmt.model.Area;
import com.jf.projects.zmt.model.EntryArea;
import com.jf.projects.zmt.model.SUser;
import com.jf.projects.zmt.service.UserService;
import com.jf.projects.zmt.vo.user.UserSearch;
import com.jf.projects.zmt.vo.user.UserVo;

/**
 * @className: UserServiceImpl
 * @description:用户实现
 * @author yt
 * @date 2017年10月19日下午5:11:18
 */

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private SUserMapper dao;

    @Autowired
    private AreaMapper areaMapper;

    @Autowired
    private EntryAreaMapper entryMapper;

    @Override
    public List<UserVo> findUserByKey(UserSearch search) {
        // TODO Auto-generated method stub
        return dao.findUserByKey(search.getAccount(), search.getPhone(), search.getKey(),
                                 search.getTypeId(), search.getDepartmentId(), search.getRoleId(),
                                 search.getStart(), search.getLength());
    }

    @Override
    public Long findUserCountByKey(UserSearch search) {
        // TODO Auto-generated method stub
        return dao.findUserCountByKey(search.getAccount(), search.getPhone(), search.getKey(),
                                      search.getTypeId(), search.getDepartmentId(),
                                      search.getRoleId());
    }

    @Override
    public String getAddressById(String userId) {
        StringBuffer address = new StringBuffer();
        SUser user = dao.findById(userId);
        if (!StringUtils.isEmpty(user.getProvinceId())) {// 省
            Area pro = areaMapper.findById(user.getProvinceId());
            address.append(pro.getProvince());
        }
        if (!StringUtils.isEmpty(user.getCityId())) {// 市
            Area city = areaMapper.findById(user.getCityId());
            address.append(city.getCity());
        }
        if (!StringUtils.isEmpty(user.getDistrictId())) {// 区县
            Area dis = areaMapper.findById(user.getDistrictId());
            address.append(dis.getDistrict());
        }
        if (!StringUtils.isEmpty(user.getTownId())) {// 乡镇
            EntryArea town = entryMapper.findById(user.getTownId());
            address.append(town.getTown());
        }
        if (!StringUtils.isEmpty(user.getVillageId())) {// 村
            EntryArea vill = entryMapper.findById(user.getVillageId());
            address.append(vill.getVillage());
        }
        return address.toString();
    }

    @Override
    public Long findMarketUserCountByKey(UserSearch search) {
        return dao.findMarketUserCountByKey(search);
    }

    @Override
    public Long findSlaughterHouseUserCountByKey(UserSearch search) {
        return dao.findSlaughterHouseUserCountByKey(search);
    }
}
