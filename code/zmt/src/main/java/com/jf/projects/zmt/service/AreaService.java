package com.jf.projects.zmt.service;

import java.util.List;

import com.jf.projects.zmt.vo.OptionVo;
import com.jf.projects.zmt.vo.area.AreaIdsVo;
import com.jf.projects.zmt.vo.area.ZtreeVo;

public interface AreaService {
	
	/**
	 * 根据省市区任意id获取当前id下所有的区县id
	 * @param id
	 * @return
	 */
	public List<Integer> getDistrictIds(Integer id);
	
	/**
	 * 获取所有省份下拉列表
	 * @return
	 */
	public List<OptionVo> findProvinceOption();
	
	/**
	 * 根据省id获取所有市下拉列表
	 * @param provId 省份id
	 * @return
	 */
	public List<OptionVo> findCityOption(Integer provId);
	
	/**
	 * 根据市id获取所有区县下拉列表
	 * @param cityId 市id
	 * @return
	 */
	public List<OptionVo> findDistrictOption(Integer cityId);
	
	/**
	 * 获取树
	 * @param id 地名id
	 * @param type 层级 1：省  2：市  3：区县  4：乡镇  5：村
	 * @param userId 当前登录用户id
	 * @return
	 */
	public List<ZtreeVo> findTree(Integer id,Integer type,String userId);
	
	/**
	 * 根据区域id和层级 获取该id下所有的村id
	 * @param areaId 区域id
	 * @param type 层级 1：省  2：市  3：区县  4：乡镇  5：村
	 * @return
	 */
	public List<Integer> findvallageIds(Integer areaId,Integer type);
	
	/**
	 * 根据区县名称获取省市区id
	 * @param districtId 区县id
	 * @return
	 */
	public AreaIdsVo findAreaIdsByDistrict(String district);
	
	/**
	 * 根据市区名称获取省市区id
	 * @param city
	 * @return
	 */
	public AreaIdsVo findAreaIdsByCity(String city);
}
