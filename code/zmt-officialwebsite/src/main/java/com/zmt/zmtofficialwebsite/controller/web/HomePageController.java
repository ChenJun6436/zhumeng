package com.zmt.zmtofficialwebsite.controller.web;

import com.zmt.zmtofficialwebsite.service.CaseService;
import com.zmt.zmtofficialwebsite.service.ContactInfoService;
import com.zmt.zmtofficialwebsite.service.FriendLinkService;
import com.zmt.zmtofficialwebsite.service.ImageService;
import com.zmt.zmtofficialwebsite.service.NewsService;
import com.zmt.zmtofficialwebsite.service.SeoInfoService;
import com.zmt.zmtofficialwebsite.util.result.ResultVo;
import com.zmt.zmtofficialwebsite.vo.Home_BottomVo;
import com.zmt.zmtofficialwebsite.vo.Home_CaseVo;
import com.zmt.zmtofficialwebsite.vo.Home_SeoVo;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 描述: 首页
 *
 * @author Administrator
 * @create 2018-01-15 10:06
 */
@RestController
@RequestMapping("/web/home")
public class HomePageController {

  @Autowired
  ImageService imageService;

  @Autowired
  CaseService caseService;

  @Autowired
  NewsService newsService;

  @Autowired
  SeoInfoService seoInfoService;

  @Autowired
  ContactInfoService contactInfoService;

  @Autowired
  FriendLinkService friendLinkService;

  /**
   * 首页banner 案例图片查询
   *
   * @return ResultVo
   */
  @RequestMapping("/findImage")
  public ResultVo findHomePage() {
    try {
      //banner图片
      List<String> banner = imageService.findUrlByAll();
      //成功案例
      List<Home_CaseVo> solution = caseService.findByHomePage();

      Map<String, Object> map = new HashMap<>();
      map.put("banner", banner);
      map.put("solution", solution);
      return new ResultVo(map);
    } catch (Exception e) {
      e.printStackTrace();
      return ResultVo.error(e.getMessage());
    }
  }

  /**
   * 首页新闻查询
   *
   * @return ResultVo
   */
  @RequestMapping("/findNews")
  public ResultVo findNews() {
    try {
      return new ResultVo(newsService.findNewsByHome());
    } catch (Exception e) {
      e.printStackTrace();
      return ResultVo.error(e.getMessage());
    }
  }

  /**
   * 首页基础配置查询
   *
   * @return ResultVo
   */
  @RequestMapping("/findConfiguration")
  public ResultVo findConfiguration() {
    try {
      //seo 配置
      Home_SeoVo seoVo = seoInfoService.findConfiguration();
      //底部配置
      Home_BottomVo vo = contactInfoService.findConfiguration();
      //友情链接
      List<Map<String, String>> link = friendLinkService.findConfiguration();
      if (null == vo) {
        vo = new Home_BottomVo();
      }
      vo.setFriendLink(link);

      Map<String, Object> map = new HashMap<>();
      map.put("seo", seoVo);
      map.put("bottom", vo);
      return new ResultVo(map);
    } catch (Exception e) {
      e.printStackTrace();
      return ResultVo.error(e.getMessage());
    }
  }
}
