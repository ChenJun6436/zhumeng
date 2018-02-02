package com.jf.projects.zmt.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jf.projects.zmt.model.AndUserArea;
import com.jf.projects.zmt.vo.account.UserAreaVo;

public interface AndUserAreaMapper extends BaseMapper<AndUserArea> {
	/**
	 * 查找用户地址
	 * 
	 * @param userId
	 * @return
	 */
	List<String> findAreaByUserId(@Param("userId") String userId);
	
	/**
	 * 根据用户id获取用户管辖地址及层级
	 * @param userId
	 * @return
	 */
	List<UserAreaVo> findUserArea(@Param("userId") String userId);
	
	/**
	 * 根据用户id删除数据
	 * @param userId
	 */
	void deleteByUserId(@Param("userId")String userId);
	
	/**
	 * 根据地址id查找
	 * @param areaId
	 * @return
	 */
	List<AndUserArea> findByAreaId(@Param("areaId")Integer areaId);
}