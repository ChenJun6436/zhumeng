package com.jf.projects.zmt.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jf.projects.zmt.service.TypeService;
import com.jf.projects.zmt.util.ConstantsUtil;
import com.jf.projects.zmt.vo.ResponseVO;

/**
 * 
 * @className: TypeController
 *
 * @description:用户角色类型
 *
 * @author wj
 *
 * @date 2017年10月25日下午3:17:39
 *
 */
@Controller
@RequestMapping("/*")
public class TypeController {

    @Autowired
    private TypeService typeService;

    /**
     * 获取所有用户类型
     * 
     * @return
     */
    @RequestMapping(value = "/sign/type/find_all", method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public ResponseVO getType() {
        ResponseVO responseVO = new ResponseVO();
        try {
            responseVO.setCode(ConstantsUtil.RES_SUCCESS_CODE);
            responseVO.setMessage(ConstantsUtil.RES_SUCCESS_MESSAGE);
            responseVO.setData(typeService.findAll());
            return responseVO;
        } catch (Exception e) {
            e.printStackTrace();
            responseVO.setCode(ConstantsUtil.RES_FAIL_CODE);
            responseVO.setMessage(ConstantsUtil.RES_FAIL_MESSAGE);
            return responseVO;
        }
    }

    /**
     * 新增用户角色类型
     * @param typeName
     * @return
     */
    @RequestMapping(value = "/sign/type/add_type", method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public ResponseVO addType(@RequestParam(value = "typeName",required = true) String typeName) {
        return typeService.addType(typeName);
    }
    
    /**
     * 更新角色类型名称
     * @param typeId
     * @param typeName
     * @return
     */
    @RequestMapping(value = "/sign/type/update_type", method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public ResponseVO updateType(@RequestParam(value = "typeId",required = true) String typeId,
                              @RequestParam(value = "typeName",required = true) String typeName) {
            return typeService.updateType(typeId, typeName);
    }
    
    

}
