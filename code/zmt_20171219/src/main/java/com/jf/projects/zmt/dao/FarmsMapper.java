package com.jf.projects.zmt.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jf.projects.zmt.model.Farms;
import com.jf.projects.zmt.vo.farms.AppFarmsVo;
import com.jf.projects.zmt.vo.farms.FarmsInfo;
import com.jf.projects.zmt.vo.farms.UserOfFarms;

public interface FarmsMapper extends BaseMapper<Farms> {
	/**
	 * 查找养殖户信息
	 * 
	 * @param account
	 * @param phone
	 * @param typeId
	 * @param departmentId
	 * @param roleId
	 * @param keyWords
	 * @param farmType
	 * @param start
	 * @param length
	 * @return
	 */
	List<FarmsInfo> findFarmsVos(@Param(value = "account") String account,
			@Param(value = "phone") String phone,
			@Param(value = "typeId") String typeId,
			@Param(value = "departmentId") String departmentId,
			@Param(value = "roleId") String roleId,
			@Param(value = "keyWords") String keyWords,
			@Param(value = "farmType") Integer farmType,
			@Param(value = "start") Integer start,
			@Param(value = "length") Integer length);

	/**
	 * 总条数
	 * 
	 * @param account
	 * @param phone
	 * @param typeId
	 * @param departmentId
	 * @param roleId
	 * @param keyWords
	 * @param farmType
	 * @return
	 */
	long countFarmsVos(@Param(value = "account") String account,
			@Param(value = "phone") String phone,
			@Param(value = "typeId") String typeId,
			@Param(value = "departmentId") String departmentId,
			@Param(value = "roleId") String roleId,
			@Param(value = "keyWords") String keyWords,
			@Param(value = "farmType") Integer farmType);

	/**
	 * 建档搜索养殖户
	 * 
	 * @param keyWords
	 * @return
	 */
	List<UserOfFarms> findFarmsBykeywords(
			@Param(value = "keyWords") String keyWords);

	/**
	 * 通过用户id查找养殖id
	 * 
	 * @param id
	 * @return
	 */
	String getFarmId(@Param(value = "id") String id);

	/**
	 * app段查找某人建立的养殖户
	 * 
	 * @param id
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	List<AppFarmsVo> appGetFarsmInfo(@Param(value = "id") String id,
			@Param(value = "beginDate") String beginDate,
			@Param(value = "endDate") String endDate,
			@Param("keyWords") String keyWords);

	/**
	 * 通过养殖户id获取关联主键
	 * 
	 * @param id
	 * @return
	 */
	String appGetIdByFarmerId(@Param(value = "id") String id);

	/**
	 * 通过养殖户id获取养殖户信息
	 * 
	 * @param id
	 * @return
	 */
	Farms appGetFarmInfo(@Param(value = "id") String id);
}
