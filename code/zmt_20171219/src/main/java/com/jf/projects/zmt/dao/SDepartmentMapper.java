package com.jf.projects.zmt.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jf.projects.zmt.model.SDepartment;
import com.jf.projects.zmt.vo.department.DepartmentVo;
import com.jf.projects.zmt.vo.department.departmentListVo;

public interface SDepartmentMapper extends BaseMapper<SDepartment> {

	/**
	 * 根据类型ID获取部门下拉数据
	 * 
	 * @param typeId
	 * @return
	 */
	List<departmentListVo> findListByTypeId(String typeId);

	/**
	 * 根据名称查询部门
	 * 
	 * @param departmentName
	 * @return
	 */
	SDepartment findByName(@Param("departmentName") String departmentName);

	/**
	 * 通过useid查找部门名字-
	 * 
	 * @param userId
	 * @return
	 */
	List<String> findDepartmentByUserId(@Param("userId") String userId);

	/**
	 * 根据类型ID获取部门数据
	 * 
	 * @param typeId
	 * @return
	 */
	List<SDepartment> findByTypeId(@Param("typeId") String typeId);

	/**
	 * 根据类型ID获取建档和养殖
	 * 
	 * @param typeId
	 * @return
	 */
	List<SDepartment> findByTypeIdForjy(@Param("typeId") String typeId);

	/**
	 * 通过部门code查找部门
	 * 
	 * @param resource
	 * @return
	 */
	List<DepartmentVo> findDepartmentVoByResource(
			@Param("resource") String resource);
}