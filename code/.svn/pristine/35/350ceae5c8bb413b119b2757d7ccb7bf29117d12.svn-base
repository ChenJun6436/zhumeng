package com.jf.projects.zmt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jf.projects.zmt.service.DepartmentService;
import com.jf.projects.zmt.vo.ResponseVO;


/**
 * 
 * @className: DepartmentController
 *
 * @description:部门
 *
 * @author wj
 *
 * @date 2017年10月25日下午3:43:03
 *
 */
@Controller
@RequestMapping("/*")
public class DepartmentController {
	
	@Autowired
	private DepartmentService departmentService;
	
	/**
     * 根据类型ID获取部门列表
     * @param typeId
     * @return
     */
    @RequestMapping(value = "/sign/department/find_department_list",method = RequestMethod.POST)
    @ResponseBody   
    public ResponseVO getDepartmentList(@RequestParam(value = "typeId",required = true) String typeId){
            return departmentService.findDepartmentList(typeId);
    }
	
	/**
	 * 根据类型ID获取部门下拉数据
	 * @param typeId
	 * @return
	 */
	@RequestMapping(value = "/sign/department/find_department",method = RequestMethod.POST)
	@ResponseBody	
	public ResponseVO getDepartment(@RequestParam(value = "typeId",required = false) String typeId){
			return departmentService.findDepartment(typeId);
	}
	
	/**
	 * 根据类型ID获取部门下拉数据
	 * @param typeId
	 * @return
	 */
	@RequestMapping(value = "/sign/department/find_department_forjy",method = RequestMethod.POST)
	@ResponseBody	
	public ResponseVO getDepartmentForjy(@RequestParam(value = "typeId",required = false) String typeId){
			return departmentService.findDepartmentForjy(typeId);
	}
	
	/**
	 * 新增部门
	 * @param typeId
	 * @param departmentName
	 * @param type
	 * @return
	 */
    @RequestMapping(value = "/sign/department/add_department",method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody   
    public ResponseVO addDepartment(@RequestParam(value = "typeId",required = true) String typeId,
                                    @RequestParam(value = "departmentName",required = true) String departmentName,
                                    @RequestParam(value = "type",required = false) Integer type){
             return departmentService.addDepartment(typeId,departmentName,type);
    }
    
    /**
     * 修改部门名称或类型
     * @param departmentId
     * @param typeId
     * @param departmentName
     * @return
     */
    @RequestMapping(value = "/sign/department/update_department",method ={RequestMethod.POST,RequestMethod.GET})
    @ResponseBody   
    public ResponseVO updateDepartment(@RequestParam(value = "departmentId",required = true) String departmentId,
                                       @RequestParam(value = "typeId",required = false) String typeId,
                                       @RequestParam(value = "departmentName",required = false) String departmentName){
             return departmentService.updateDepartment(departmentId,typeId,departmentName);
    }
	
	
	
	/**
	 * 删除部门
	 * @param departmentId
	 * @return
	 */
    @RequestMapping(value = "/sign/department/delete_department",method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody   
    public ResponseVO deleteDepartment(@RequestParam(value = "departmentId",required = false) String departmentId){
            return departmentService.deleteDepartment(departmentId);
    }
	
}
