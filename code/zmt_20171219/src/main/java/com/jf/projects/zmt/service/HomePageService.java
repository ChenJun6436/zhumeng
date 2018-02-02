package com.jf.projects.zmt.service;


import java.util.List;

import com.jf.projects.zmt.vo.RequestPageParam;
import com.jf.projects.zmt.vo.ResponseVO;
import com.jf.projects.zmt.vo.home.HomeSearchVo;
import com.jf.projects.zmt.vo.home.PicCountVo;
import com.jf.projects.zmt.vo.home.RealCountVo;
import com.jf.projects.zmt.vo.pigFlow.PigFlowVo;

/**
 * 首页接口
 * @author dqh
 *
 */
public interface HomePageService {
	
	/**
	 * 获取今日实时数据
	 * @param areaId 区域id
	 * @param type 层级  1：省  2：市  3：区县  4：乡镇  5：村
	 * @return
	 */
	public RealCountVo getTodayReal(Integer areaId,Integer type);
	
	/**
	 * 根据地址和层级id获取图表数据
	 * @param areaId 区域id
	 * @param type 层级  1：省  2：市  3：区县  4：乡镇  5：村
	 * @return
	 */
	public PicCountVo getPic(Integer areaId,Integer type);
	
	/**
	 * 根据条件搜索列表
	 * @param vo
	 * @return
	 */
	public ResponseVO getPigByFiled(HomeSearchVo vo);
	
	/**
	 * 根据生猪id获取流程
	 * @param pigId
	 * @return
	 */
	public ResponseVO findFlowByPigId(String pigId,RequestPageParam pageParam);
	
	/**
	 * 根据生猪id获取流程(APP查看  返回所有)
	 * @param pigId
	 * @return
	 */
	public List<PigFlowVo> findAllByPigId(String pigId);
}
