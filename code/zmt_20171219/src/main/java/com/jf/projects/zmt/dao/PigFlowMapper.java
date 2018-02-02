package com.jf.projects.zmt.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jf.projects.zmt.model.PigFlow;
import com.jf.projects.zmt.vo.RequestPageParam;
import com.jf.projects.zmt.vo.home.HomePigVo;
import com.jf.projects.zmt.vo.home.HomeSearchVo;
import com.jf.projects.zmt.vo.pigFlow.PigFlowVo;

public interface PigFlowMapper extends BaseMapper<PigFlow> {
	
	/**
     * 根据生猪id获取该生猪流程信息
     * 
     * @param pigId
     * @return
     */
	public List<PigFlowVo> findAllByPigId(@Param(value = "pigId")String pigId);

    /**
     * 根据生猪id获取该生猪流程信息
     * 
     * @param pigId
     * @return
     */
	public List<PigFlowVo> findByPigId(@Param(value = "pigId")String pigId,@Param(value = "pageParam")RequestPageParam pageParam);

	/**
     * 统计流程条数
     * 
     * @param pigId
     * @return
     */
	public long countByPigId(@Param(value = "pigId")String pigId);
    /**
     * 统计区域下符合条件生猪总条数
     * 
     * @param home
     * @return
     */
    public long findtotal(HomeSearchVo home);

    /**
     * 分页查询
     * 
     * @param home
     * @return
     */
    public List<HomePigVo> findPage(HomeSearchVo home);

    /**
     * 获取流程表该猪id的最后记录
     * 
     * @param pigId
     * @return
     */
    PigFlow findLastByPigId(String pigId);

}
