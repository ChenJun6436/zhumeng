package com.zmt.zmtofficialwebsite.service;

import java.util.List;

import com.zmt.zmtofficialwebsite.model.News;
import com.zmt.zmtofficialwebsite.util.result.PageResultVo;
import com.zmt.zmtofficialwebsite.vo.AanvraagTypeVo;
import com.zmt.zmtofficialwebsite.vo.Home_NewsVo;
import com.zmt.zmtofficialwebsite.vo.NewsVo;

public interface NewsService {

	/**
	 * 新闻列表
	 */
	List<NewsVo> findVos(Integer page, Integer size);

	/**
	 * 新闻总条数
	 */
	Integer getCount();

	/**
	 * 新增案例
	 */
	News save(News pojo);

	/**
	 * 删除案例
	 */
	void del(Long id);

	/**
	 * 首页新闻查询
	 * 
	 * @return ResultVo
	 */
	List<Home_NewsVo> findNewsByHome();

	AanvraagTypeVo[] findTypes();

	/**
	 * 新闻分类分页查询
	 * 
	 * @param type
	 * @param pageable
	 * @return
	 */
	PageResultVo findNewsByType(Integer type, Integer page, Integer size);

	News findDetails(Long id);

}
