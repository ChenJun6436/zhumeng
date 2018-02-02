package com.jf.projects.zmt.service;

import java.util.List;

import com.jf.projects.zmt.model.EntryArea;
import com.jf.projects.zmt.vo.OptionVo;
import com.jf.projects.zmt.vo.ResponseVO;
import com.jf.projects.zmt.vo.area.EntryAreaSearch;
import com.jf.projects.zmt.vo.area.EntryAreaUpdateVo;

public interface EntryAreaService {

	/**
	 * 根据条件查询乡村列表
	 */
	public ResponseVO findPage(EntryAreaSearch searchVo);
	
	/**
	 * 增加
	 * @param entryArea
	 * @return
	 */
	public ResponseVO add(EntryArea entryArea);
	
	/**
	 * 乡村修改
	 * @param updateVo
	 * @return
	 */
	public ResponseVO update(EntryAreaUpdateVo updateVo);
	
	/**
	 * 启用禁用  有用户使用的地址不可禁用和修改
	 * @param villageId
	 * @return
	 */
	public Integer updateStatus(Integer villageId);
	
	/**
	 * 删除
	 * @param villageId 乡村id
	 * @return
	 */
	public Integer delete(Integer villageId);
	
	/**
	 * 根据区县id获取镇下拉数据
	 * @param districtId 区县id
	 * @return
	 */
	public List<OptionVo> getTownOption(Integer districtId);
	
	/**
	 * 根据乡镇id获取村下拉数据
	 * @param districtId 区县id
	 * @return
	 */
	public List<OptionVo> getVillageOption(Integer townId);
	
	/**
	 * 根据区县id获取所有村id
	 * @param districtIds
	 * @return
	 */
	public List<Integer> getVillageIdByDistrictIds(List<Integer> districtIds);
}
