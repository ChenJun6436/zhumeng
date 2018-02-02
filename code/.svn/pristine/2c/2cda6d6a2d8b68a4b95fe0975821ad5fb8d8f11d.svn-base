package com.jf.projects.zmt.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jf.projects.zmt.model.PigFile;
import com.jf.projects.zmt.vo.farms.AppFileOfFamerVo;
import com.jf.projects.zmt.vo.fileManager.FileRecordVo;
import com.jf.projects.zmt.vo.fileManager.PigFileVo;
import com.jf.projects.zmt.vo.home.FilingNumberVo;
import com.jf.projects.zmt.vo.home.InputNumberVo;

public interface PigFileMapper extends BaseMapper<PigFile> {
	/**
	 * 统计该用户建立的档案
	 * 
	 * @param userId
	 * @return
	 */
	int countFile(@Param("userId") String userId);

	/**
	 * 统计用户的生猪
	 * 
	 * @return
	 */
	int countFileOfFarmer(@Param("userId") String userId);

	/**
	 * 通过建档者id查看建立的档案
	 * 
	 * @param userId
	 * @return
	 */
	List<PigFileVo> findFileByBuliderId(@Param("userId") String userId,
			@Param("sign") String sign, @Param(value = "start") Integer start,
			@Param(value = "length") Integer length);

	/**
	 * 统计总数
	 * 
	 * @param userId
	 * @param sign
	 * @return
	 */
	long countFileByBuliderId(@Param("userId") String userId,
			@Param("sign") String sign);

	/**
	 * 查找档案通过养殖户
	 * 
	 * @param userId
	 * @param sign
	 * @param phone
	 * @return
	 */
	List<FileRecordVo> findFileByFarmerId(@Param("userId") String userId,
			@Param("keyWords") String keyWords,
			@Param(value = "start") Integer start,
			@Param(value = "length") Integer length);

	/**
	 * 统计总数
	 * 
	 * @param userId
	 * @param keyWords
	 * @return
	 */
	long countFileByFarmerId(@Param("userId") String userId,
			@Param("keyWords") String keyWords);

	/**
	 * 通过生猪标签删除该生猪档案
	 * 
	 * @param sign
	 * @return
	 */
	int deleteFileBySign(@Param("sign") String sign);

	/**
	 * 通过生猪唯一标签查找生猪档案
	 * 
	 * @param sign
	 * @return
	 */
	PigFile findPigfileBySign(@Param("sign") String sign);

	/**
	 * 根据区域和层级获取建档总数
	 * 
	 * @param areaId
	 *            区域id
	 * @param type
	 *            层级 1：省 2:市 3：区县 4：乡镇 5：村
	 * @return
	 */
	Integer countByArea(@Param("areaId") Integer areaId,
			@Param("type") Integer type);

	/**
	 * 根据区域和层级获取今日建档总数
	 * 
	 * @param areaId
	 *            区域id
	 * @param type
	 *            层级 1：省 2:市 3：区县 4：乡镇 5：村
	 * @return
	 */
	Integer countByAreaToday(@Param("areaId") Integer areaId,
			@Param("type") Integer type);

	/**
	 * 根据猪id修改状态
	 * 
	 * @return
	 */
	Long updateStatus(PigFile p);

	/**
	 * 统计一年每月的建档数
	 * 
	 * @param areaId
	 *            区域id
	 * @param type
	 *            层级 1：省 2:市 3：区县 4：乡镇 5：村
	 * @return
	 */
	FilingNumberVo countFilingNumberForYear(@Param("areaId") Integer areaId,
			@Param("type") Integer type);

	/**
	 * 统计一年每月的建档数
	 * 
	 * @param areaId
	 *            区域id
	 * @param type
	 *            层级 1：省 2:市 3：区县 4：乡镇 5：村
	 * @return
	 */
	InputNumberVo countInputNumberForYear(@Param("areaId") Integer areaId,
			@Param("type") Integer type);

	/**
	 * 根据猪id修改任何字段
	 * 
	 * @param p
	 *            除了id 传什么改什么
	 * @return
	 */
	Long updateAllByPigId(PigFile p);

	/**
	 * 判断猪id是否存在
	 * 
	 * @param pigId
	 * @return
	 */
	boolean existPigId(String pigId);

	/**
	 * APP 端查找某一个养殖户领养的生猪
	 * 
	 * @param id
	 * @param sign
	 * @param beginDate
	 * @param endDate
	 * @param pigType
	 * @param pigStatus
	 * @return
	 */
	List<AppFileOfFamerVo> appFindFileOfFamer(@Param(value = "id") String id,
			@Param(value = "sign") String sign,
			@Param(value = "beginDate") String beginDate,
			@Param(value = "endDate") String endDate,
			@Param(value = "pigType") String pigType,
			@Param(value = "pigStatus") Integer pigStatus);

	/**
	 * 判断改标签是否与生猪建立关系
	 * 
	 * @param sign
	 * @return
	 */
	String getPigFile(@Param("sign") String sign);

	/**
	 * 查找养殖的猪通过养殖户
	 * 
	 * @param userId
	 * @return
	 */
	List<FileRecordVo> findPigByFarmerId(@Param("userId") String userId);

	/**
	 * app养殖户在改变生猪状态的时后判断
	 * 
	 * @param sign
	 * @param id
	 * @return
	 */
	List<PigFile> appGetFile(@Param("sign") String sign, @Param("id") String id);

}