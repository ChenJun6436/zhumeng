package com.jf.projects.zmt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jf.projects.zmt.service.ResourceService;
import com.jf.projects.zmt.util.ConstantsUtil;
import com.jf.projects.zmt.vo.ResponseVO;

/**
 * 
 * @className: ResourceController
 *
 * @description:资源
 *
 * @author wj
 *
 * @date 2017年10月31日下午3:56:34
 *
 */
@Controller
@RequestMapping("/*")
public class ResourceController {
	
	@Autowired
	private ResourceService resourceService;
	
	/**
	 * 获取所有资源数据
	 * @return
	 */
    @RequestMapping(value = "/sign/resource/find_resource",method = RequestMethod.POST)
    @ResponseBody   
    public ResponseVO getResource(){
        ResponseVO responseVO = new ResponseVO();
        try {
            responseVO.setData(resourceService.findAll());
            responseVO.setCode(ConstantsUtil.RES_SUCCESS_CODE);
            responseVO.setMessage(ConstantsUtil.RES_SUCCESS_MESSAGE);
            return responseVO;
        } catch (Exception e) {
            e.printStackTrace();
            responseVO.setCode(ConstantsUtil.RES_FAIL_CODE);
            responseVO.setMessage(ConstantsUtil.RES_FAIL_MESSAGE);
            return responseVO;
        }
      }
    
    
    /**
     * 获取当前角色下资源数据
     * @return
     */
    @RequestMapping(value = "/sign/resource/find_role_resource",method = RequestMethod.POST)
    @ResponseBody   
    public ResponseVO getRoleResource(@RequestParam(value = "roleId",required = true) String roleId){
        ResponseVO responseVO = new ResponseVO();
        try {
            responseVO.setData(resourceService.findResourceByRoleId(roleId));
            responseVO.setCode(ConstantsUtil.RES_SUCCESS_CODE);
            responseVO.setMessage(ConstantsUtil.RES_SUCCESS_MESSAGE);
            return responseVO;
        } catch (Exception e) {
            e.printStackTrace();
            responseVO.setCode(ConstantsUtil.RES_FAIL_CODE);
            responseVO.setMessage(ConstantsUtil.RES_FAIL_MESSAGE);
            return responseVO;
        }
      }
    
    }

    
	
