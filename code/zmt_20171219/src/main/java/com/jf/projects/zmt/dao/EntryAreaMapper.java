package com.jf.projects.zmt.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jf.projects.zmt.model.EntryArea;
import com.jf.projects.zmt.vo.OptionVo;
import com.jf.projects.zmt.vo.area.EntryAraeListVo;
import com.jf.projects.zmt.vo.area.EntryAreaSearch;

public interface EntryAreaMapper extends BaseMapper<EntryArea>{
	
	/**
	 * 根据区县id获取 获取总条数
	 * @param distructIds 区县id
	 * @return
	 */
	public long findtotalByDistrictIds(@Param(value = "distructIds")List<Integer> distructIds);
	
	/**
	 * 根据乡镇id获取总条数
	 * @param id
	 * @return
	 */
	public long findtotalByTownId(@Param(value = "id")Integer id);
	
	/**
	 * 根据乡镇id获取下面的村
	 * @param id
	 * @return
	 */
	public List<EntryArea> findByParent(@Param(value = "id")Integer id);
	
	/**
	 * 根据区县id获取列表
	 * @param distructIds 区县id
	 * @return
	 */
	public List<EntryAraeListVo> findByDistrictIds(@Param(value = "distructIds")List<Integer> distructIds,
												   @Param(value = "start")Integer start,
												   @Param(value = "length")Integer length);
	
	/**
	 * 根据乡镇id获取该乡镇下的村列表
	 * @param townId
	 * @return
	 */
	public List<EntryAraeListVo> findBytownId(@Param(value = "townId")Integer townId,
											  @Param(value = "start")Integer start,
											  @Param(value = "length")Integer length);
	
	/**
	 * 根据区县id获取乡镇
	 * @param distructId
	 * @return
	 */
	public List<EntryArea> findByDistrictId(@Param(value = "distructId")Integer distructId);
	
	/**
	 * 获取当前区域下最大的code
	 * @param distructId
	 * @return
	 */
	public Integer findMaxCodeByDistrictId(@Param(value = "distructId")Integer distructId);
	
	/**
	 * 修改乡镇名称
	 * @param town 乡镇名称 
	 * @param ids 需求修改的列
	 * @return
	 */
	public Integer updateTown(@Param(value = "town")String town,@Param(value = "ids")List<Integer> ids);
	
	/**
	 * 修改村名称
	 * @param id 村id
	 * @param village 村id 
	 * @return
	 */
	public Integer updateVillage(@Param(value = "id")Integer id,@Param(value = "village")String village);
	
	/**
	 * 根据镇id获取该镇级相关村的所有id
	 * @param id
	 * @return
	 */
	public List<Integer> getTownASId(@Param(value = "id")Integer id);
	
	/**
	 * 根据id获取一条数据
	 * @param id
	 * @return
	 */
	public EntryArea findById(@Param(value = "id")Integer id);
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	public Integer delete(@Param(value = "id")Integer id);
	
	/**
	 * 根据区县id获取镇下拉列表数据
	 * @param districtId 区县id
	 * @return
	 */
	public List<OptionVo> getTownOption(@Param(value = "id")Integer districtId);
	
	/**
	 * 根据乡镇id获取村下拉数据
	 * @param townId 乡镇id
	 * @return
	 */
	public List<OptionVo> getVillageOption(@Param(value = "id")Integer townId);
	
	/**
	 * 判断区县下的镇名字是否重复
	 * @param id 镇id 新增可不传
	 * @param districtId 区县id
	 * @param townName 镇名称
	 * @return
	 */
	public EntryArea townIsRepetition(@Param(value = "id")Integer id,
								  @Param(value = "districtId")Integer districtId,
								  @Param(value = "townName")String townName);
	
	/**
	 * 判断乡镇下的村名字是否重复
	 * @param id 村id 新增可不传
	 * @param townId 镇id
	 * @param name 村名称
	 * @return
	 */
	public EntryArea villageIsRepetition(@Param(value = "id")Integer id,
								  @Param(value = "townId")Integer townId,
								  @Param(value = "name")String name);
	
	/**
	 * 根据村id获取镇id
	 * @param id
	 * @return
	 */
	public Integer findTownIdById(Integer id);
	
	/**
	 * 根据镇id获取区县id
	 * @param id
	 * @return
	 */
	public Integer findDisIdById(Integer id);
	
	/**
	 * 根据条件统计视图v_entry_area条数
	 * @param vo
	 * @return
	 */
	public long findtotal(EntryAreaSearch vo);
	
	/**
	 * 根据条件查询视图v_entry_area数据
	 * @param vo
	 * @return
	 */
	public List<EntryAraeListVo> findPage(EntryAreaSearch vo);
	
	/**
	 * 根据区县id获取所有村id
	 * @param districtIds 区县id
	 * @return
	 */
	public List<Integer> getVillageIdByDistrictIds(@Param(value = "districtIds") List<Integer> districtIds);
	
	/**
	 * 根据乡镇ids获取
	 * 根据多id获取乡镇（ztree使用）
	 * @param ids 区域id
	 * @return
	 */
	public List<OptionVo> findTownByList(@Param(value = "ids")List<Integer> ids);
	
	/**
	 * 根据多id获取村（ztree使用）
	 * @param ids 区域id
	 * @return
	 */
	public List<OptionVo> findVillByList(@Param(value = "ids")List<Integer> ids);
}