package com.zmt.zmtofficialwebsite.service.impl;

import com.zmt.zmtofficialwebsite.dao.NewsDao;
import com.zmt.zmtofficialwebsite.model.News;
import com.zmt.zmtofficialwebsite.service.NewsService;
import com.zmt.zmtofficialwebsite.util.result.PageResultVo;
import com.zmt.zmtofficialwebsite.vo.AanvraagTypeVo;
import com.zmt.zmtofficialwebsite.vo.Home_NewsVo;
import com.zmt.zmtofficialwebsite.vo.NewsVo;
import com.zmt.zmtofficialwebsite.vo.WebNewsVo;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 描述: 新闻管理
 *
 * @author dengpeng
 * @create 2018-01-09 14:43
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class NewsServiceImpl implements NewsService {

  @Autowired
  private NewsDao dao;

  @Value("${com.zmt.new.type.companynews}")
  private Long companynews;

  @Value("${com.zmt.new.type.tradenews}")
  private Long tradenews;

  @Override
  public News save(News pojo) {
    Date now = new Date();
    if (pojo.getId() == null) {
      pojo.setCreateTime(now);
    }
    pojo.setLastUpdateTime(now);
    return dao.save(pojo);
  }

  @Override
  public void del(Long id) {
    dao.delete(id);
  }

  /**
   * 首页新闻查询
   *
   * @return ResultVo
   */
  @Override
  public List<Home_NewsVo> findNewsByHome() {
    Page<News> news = dao.findAll(new PageRequest(0, 3, Direction.DESC,
        "createTime"));
    List<Home_NewsVo> vos = new ArrayList<>();
    for (News news1 : news.getContent()) {
      Home_NewsVo vo = new Home_NewsVo(news1.getId(), news1.getTitle(),
          news1.getDescription(), news1.getCreateTime(),
          news1.getImgUrl());
      vos.add(vo);
    }
    return vos;
  }

  @Override
  public List<NewsVo> findVos(Integer page, Integer size) {
    List<NewsVo> vos = dao.findNews(new PageRequest(page, size,
        Sort.Direction.ASC, "createTime"));
    return vos;
  }

  @Override
  public AanvraagTypeVo[] findTypes() {
    AanvraagTypeVo[] vos = new AanvraagTypeVo[2];
    AanvraagTypeVo vo = new AanvraagTypeVo();
    vo.setId(companynews);
    vo.setName("公司新闻");
    vos[0] = vo;
    vo = new AanvraagTypeVo();
    vo.setId(tradenews);
    vo.setName("行业新闻");
    vos[1] = vo;
    return vos;
  }

  @Override
  public PageResultVo findNewsByType(Integer type, Integer page, Integer size) {
    Page<News> pg = dao.findNewsByType(type, new PageRequest(page, size,
        Sort.Direction.ASC, "createTime"));
    Integer count = dao.countNumber(type);
    PageResultVo vo = new PageResultVo();
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    List<WebNewsVo> list = new ArrayList<>();
    List<News> list2 = pg.getContent();
    for (News news : list2) {
      WebNewsVo webNewsVo = new WebNewsVo();
      webNewsVo.setId(news.getId());
      webNewsVo.setCreateTime(news.getCreateTime());
      webNewsVo.setImgUrl(news.getImgUrl());
      webNewsVo.setDescription(news.getDescription());
      webNewsVo.setKeywords(news.getKeywords());
      webNewsVo.setTitle(news.getTitle());
      webNewsVo.setType(news.getType());
      list.add(webNewsVo);
    }
    vo.setList(list);
    vo.setRecordsTotal(count);
    vo.setRecordsFiltered(pg.getContent().size());
    return vo;
  }

  @Override
  public Integer getCount() {
    return dao.getCount();
  }

  @Override
  public News findDetails(Long id) {
    return dao.findOne(id);
  }
}
