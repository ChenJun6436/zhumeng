package com.jf.projects.zmt.service;


import com.jf.projects.zmt.vo.ResponseVO;
/**
 * 
 * @className: DepartmentService
 *
 * @description:部门
 *
 * @author wj
 *
 * @date 2017年10月25日下午3:41:16
 *
 */
public interface DepartmentService {
    
    /**
     * 获取部门列表数据
     * @param typeId
     * @return
     */
    ResponseVO  findDepartmentList(String typeId);

    /**
     * 获取部门下拉数据
     * @param typeId
     * @return
     */
	ResponseVO findDepartment(String typeId);
	
	/**
     * 获取部门下拉数据(建档，养殖)
     * @param typeId
     * @return
     */
	ResponseVO findDepartmentForjy(String typeId);
	
	/**
	 * 删除部门
	 * @param departmentId
	 * @return
	 */
	ResponseVO deleteDepartment(String departmentId);
	
	/**
	 * 新增部门
	 * @param typeId
	 * @param departmentName
	 */
	ResponseVO addDepartment(String typeId,String departmentName,Integer type);
	
	/**
	 * 修改部门信息
	 * @param departmentId
	 * @param typeId
	 * @param departmentName
	 * @return
	 */
	ResponseVO updateDepartment(String departmentId,String typeId,String departmentName);
	

}
