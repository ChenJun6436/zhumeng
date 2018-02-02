package com.zmt.zmtofficialwebsite.dao;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.zmt.zmtofficialwebsite.model.Case;
import com.zmt.zmtofficialwebsite.vo.CaseNumVo;
import com.zmt.zmtofficialwebsite.vo.CaseVo;
import com.zmt.zmtofficialwebsite.vo.Home_CaseVo;

public interface CaseDao extends JpaRepository<Case, Long> {

    /**
     * 获取每种类型的数量
     */
    @Query("select new com.zmt.zmtofficialwebsite.vo.CaseNumVo(aanvraagType.id,count(id)) from Case group by aanvraagType.id")
    List<CaseNumVo> findCaseNum();

    @Query("select new com.zmt.zmtofficialwebsite.vo.CaseVo(id,name,createTime) from Case  c where c.aanvraagType.id=:aanvraagTypeId")
    List<CaseVo> findByAanvraagTypeId(@Param("aanvraagTypeId") Long aanvraagTypeId,
                                      Pageable pageable);

    @Query("select count(id) from Case  c where c.aanvraagType.id=?")
    Integer getCount(Long aanvraagTypeId);

    /**
     * 首页成功案例查询
     */
    @Query("select new com.zmt.zmtofficialwebsite.vo.Home_CaseVo(c.id,c.name,c.imgUrl) from Case c group by c.aanvraagType.id")
    List<Home_CaseVo> findByHomePage();

    @Query("select new com.zmt.zmtofficialwebsite.vo.CaseVo(id,name,createTime,content) from Case where aanvraagType.id=?  ORDER BY createTime ASC")
    List<CaseVo> findVoByAanvraagTypeId(Long aanvraagTypeId);

}
