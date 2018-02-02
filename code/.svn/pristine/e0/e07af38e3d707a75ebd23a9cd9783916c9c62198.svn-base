package com.jf.projects.zmt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jf.projects.zmt.model.Inspectin;
import com.jf.projects.zmt.model.SUser;
import com.jf.projects.zmt.service.InspectionService;
import com.jf.projects.zmt.util.ConstantsUtil;
import com.jf.projects.zmt.vo.OptionVo;
import com.jf.projects.zmt.vo.ResponseVO;
import com.jf.projects.zmt.vo.inspection.AddInspectionUser;
import com.jf.projects.zmt.vo.user.UserSearch;

@Controller
@RequestMapping("/inspection")
public class InspectionController {
    @Autowired
    private InspectionService inspectionService;

    /**
     * 查找所有检验中心
     * 
     * @param usSearch
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getAll", method = RequestMethod.POST)
    public ResponseVO findInspectionInfo(UserSearch usSearch) {
        return inspectionService.findInspectionInfo(usSearch);
    }

    /**
     * 添加检验中心
     * 
     * @param vo
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseVO addInspection(Inspectin vo) {
        return inspectionService.addInspection(vo);
    }

    /**
     * 查找某一个检验中心下的检验人员
     * 
     * @param uSearch
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getUser/byInspectionId", method = RequestMethod.POST)
    public ResponseVO findInspectionUserInfouser(UserSearch uSearch) {
        return inspectionService.findInspectionUserInfo(uSearch);
    }

    /**
     * 新增
     * 
     * @param vo
     * @return
     */
    @RequestMapping(value = "/inspection/get_users", method = RequestMethod.GET)
    @ResponseBody
    public ResponseVO getUsers() {

        ResponseVO responseVO = new ResponseVO();
        List<OptionVo> users = inspectionService.getUsers();
        responseVO.setData(users);
        responseVO.setCode(ConstantsUtil.RES_SUCCESS_CODE);
        responseVO.setMessage(ConstantsUtil.RES_SUCCESS_MESSAGE);
        return responseVO;
    }

    /**
     * 添加检验人员
     * 
     * @param vo
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/add/inspectionUser", method = RequestMethod.POST)
    public ResponseVO addInspectionUser(AddInspectionUser vo) {
        int flag = inspectionService.addInspectionUser(vo);
        ResponseVO responseVO = new ResponseVO();
        if (flag == 1) {
            responseVO.setCode(ConstantsUtil.RES_SUCCESS_CODE);
            responseVO.setMessage(ConstantsUtil.RES_SUCCESS_MESSAGE);
        } else {
            responseVO.setCode(ConstantsUtil.RES_FAIL_CODE);
            responseVO.setMessage(ConstantsUtil.RES_EXIST_MESSAGE);
        }
        return responseVO;
    }

    /**
     * 启用或者禁用某一个检验中心
     * 
     * @param id
     * @param status
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/startOrForbid/byInspection", method = RequestMethod.POST)
    public ResponseVO stratOrForbid(@RequestParam(value = "id", required = true) String id,
                                    @RequestParam(value = "status", required = true) String status) {
        return inspectionService.startOrForbid(id, status);
    }

    /**
     * 修改某一个检验中心
     * 
     * @param vo
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ResponseVO updateInspection(Inspectin vo) {
        return inspectionService.updateInspection(vo);
    }

    @ResponseBody
    @RequestMapping(value = "/update/user", method = RequestMethod.POST)
    public ResponseVO updateInspectionUser(SUser vo) {
        ResponseVO responseVO = new ResponseVO();
        try {
            int falg = inspectionService.updateInspectionUser(vo);
            if (falg == 1) {
                responseVO.setCode(ConstantsUtil.RES_SUCCESS_CODE);
                responseVO.setMessage(ConstantsUtil.RES_SUCCESS_MESSAGE);
                responseVO.setData(falg);
            } else {
                responseVO.setData(falg);
                responseVO.setCode(ConstantsUtil.RES_FAIL_CODE);
                responseVO.setMessage("电话号码已注册");
            }
        } catch (Exception e) {
            responseVO.setCode(ConstantsUtil.RES_FAIL_CODE);
            responseVO.setMessage(ConstantsUtil.RES_FAIL_MESSAGE);
        }
        return responseVO;
    }
}
