package com.zmt.zmtofficialwebsite.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.zmt.zmtofficialwebsite.model.News;
import com.zmt.zmtofficialwebsite.vo.Home_NewsVo;
import com.zmt.zmtofficialwebsite.vo.NewsVo;
import com.zmt.zmtofficialwebsite.vo.WebNewsVo;

public interface NewsDao extends JpaRepository<News, Long> {
	/**
	 * 分页查找新闻信息
	 * 
	 * @param pageable
	 * @return
	 */
	@Query("select new com.zmt.zmtofficialwebsite.vo.NewsVo(id,type,title,createTime) from News")
	List<NewsVo> findNews(Pageable pageable);

	/**
	 * 统计新闻类别的总条数
	 * 
	 * @param type
	 * @return
	 */
	@Query(value = "select COUNT(*) from t_news", nativeQuery = true)
	Integer getCount();

	/**
	 * 首页新闻查询
	 * 
	 * @return ResultVo
	 */
	@Query("select new com.zmt.zmtofficialwebsite.vo.Home_NewsVo(id,title,description,createTime,imgUrl) from News")
	Page<Home_NewsVo> findNewsByHome(Pageable pageable);

	/**
	 * 分页根据类型查找新闻信息
	 * 
	 * @param type
	 * @param pageable
	 * @return
	 */
	@Query(value = "from News n WHERE n.type=:type")
	Page<News> findNewsByType(@Param("type") Integer type, Pageable pageable);

	/**
	 * 统计新闻类别的总条数
	 * 
	 * @param type
	 * @return
	 */
	@Query(value = "select COUNT(*) from t_news WHERE t_news.type=?1 ", nativeQuery = true)
	Integer countNumber(Integer type);

	@Query(value = "select new com.zmt.zmtofficialwebsite.vo.WebNewsVo(createTime,title,content) from News  n where n.id=:id")
	WebNewsVo findNeWebNewsVoById(@Param("id") Long id);
}
