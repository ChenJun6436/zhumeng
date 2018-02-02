package com.jf.projects.zmt.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jf.projects.zmt.service.RoleService;
import com.jf.projects.zmt.vo.ResponseVO;


/**
 * 
 * @className: RoleController
 *
 * @description:用户角色
 *
 * @author wj
 *
 * @date 2017年10月25日下午3:18:02
 *
 */
@Controller
@RequestMapping("/*")
public class RoleController {
	
	@Autowired
	private RoleService roleService;
	
	
	/**
	 * 获取角色列表数据
	 * @param typeId
	 * @param departmentId
	 * @param roleId
	 * @param start
	 * @param length
	 * @return
	 */
    @RequestMapping(value = "/sign/role/find_role_list",method = RequestMethod.POST)
    @ResponseBody   
    public ResponseVO getRoleList(@RequestParam(value = "typeId",required = true) String typeId,
                                  @RequestParam(value = "departmentId",required = false) String departmentId,
                                  @RequestParam(value = "roleId",required = false) String roleId,
                                  @RequestParam(value = "start",required = false) Integer start,
                                  @RequestParam(value = "length",required = false) Integer length){
            return roleService.findRoleList(typeId,departmentId,roleId,start,length);
    }
    
	
	
	/**
     * 获取角色下拉数据
     * @param departmentId
     * @return
     */
    @RequestMapping(value = "/sign/role/find_role",method = RequestMethod.POST)
    @ResponseBody   
    public ResponseVO getDepartment(@RequestParam(value = "departmentId",required = false) String departmentId){
            return roleService.findRoleByDepartmentId(departmentId);
    }
    
    

    /**
     * 新增角色
     * @param roleName
     * @param departmentId
     * @param typeId
     * @param resourceIds
     * @param code
     * @param creator
     * @return
     */
    @RequestMapping(value = "/sign/role/add_role",method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody   
    public ResponseVO addRole(/*AddRoleRequestVo  addRoleRequestVo*/
                                @RequestParam(value = "roleName",required = true) String roleName,
                                @RequestParam(value = "departmentId",required = true) String departmentId,
                                @RequestParam(value = "typeId",required = true) String typeId,
                                @RequestParam(value = "resourceIds",required = true) String resourceIds,
                                @RequestParam(value = "code",required = false) String code,
                                @RequestParam(value = "creator",required = false) String creator
                              ){
              return roleService.addRole(roleName,departmentId,typeId,resourceIds,code,creator);
             /*return roleService.addRole(addRoleRequestVo.getRoleName(),addRoleRequestVo.getDepartmentId(),
                                       addRoleRequestVo.getTypeId(),addRoleRequestVo.getResourceIds());*/
    }
    
    /**
     * 更新角色信息
     * @param roleName
     * @param departmentId
     * @param roleId
     * @param resourceIds
     * @param code
     * @param creator
     * @return
     */
    @RequestMapping(value = "/sign/role/update_role",method = RequestMethod.POST)
    @ResponseBody   
    public ResponseVO updateRole(@RequestParam(value = "roleName",required = false) String roleName,
                                 @RequestParam(value = "departmentId",required = false) String departmentId,
                                 @RequestParam(value = "roleId",required = true) String roleId,
                                 @RequestParam(value = "resourceIds",required = false) String resourceIds,
                                 @RequestParam(value = "code",required = false) String code,
                                 @RequestParam(value = "creator",required = false) String creator){
        
             return roleService.updateRole(roleId,roleName,departmentId,resourceIds,code,creator);
            /*return roleService.updateRole(addRoleRequestVo.getRoleId(),addRoleRequestVo.getRoleName(),
                                       addRoleRequestVo.getDepartmentId(),addRoleRequestVo.getResourceIds());*/
    }
    
    /**
     * 删除角色
     * @param roleId
     * @return
     */
    @RequestMapping(value = "/sign/role/delete_role",method = RequestMethod.POST)
    @ResponseBody   
    public ResponseVO deleteRole(@RequestParam(value = "roleId",required = true) String roleId){
        return roleService.deleteRole(roleId);
    }
	
	
}
