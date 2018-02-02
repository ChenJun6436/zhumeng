package com.zmt.zmtofficialwebsite.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zmt.zmtofficialwebsite.dao.FriendLinkRepository;
import com.zmt.zmtofficialwebsite.model.FriendLink;
import com.zmt.zmtofficialwebsite.service.FriendLinkService;
import com.zmt.zmtofficialwebsite.util.result.ResultVo;

@Service
@Transactional(rollbackFor = Exception.class)
public class FriendLinkServiceImpl implements FriendLinkService {

  @Autowired
  private FriendLinkRepository friendLinkRepository;

  @Override
  public List<FriendLink> findAll() {
    return friendLinkRepository.findAll();
  }

  @Override
  public ResultVo deleteFriendLink(Long id) {
    friendLinkRepository.delete(id);
    return ResultVo.ok();
  }

  /**
   * 官网首页查询
   *
   * @return Home_SeoVo
   */
  @Override
  public List<Map<String,String>> findConfiguration() {
    List<FriendLink> friendLinks = friendLinkRepository.findAll();
    List<Map<String,String>> maps = new ArrayList<>();
    if (null != friendLinks && friendLinks.size() > 0) {
      Map<String, String> map = new HashMap<>();
      for (FriendLink friendLink : friendLinks) {
        map.put("name", friendLink.getName());
        map.put("url",friendLink.getUrl());
        maps.add(map);
      }
      return maps;
    }
    return null;
  }
}
