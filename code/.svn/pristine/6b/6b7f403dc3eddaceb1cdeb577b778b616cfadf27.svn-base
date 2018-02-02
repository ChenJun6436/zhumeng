package com.jf.projects.zmt.service;

import java.util.List;

import com.jf.projects.zmt.model.Inspectin;
import com.jf.projects.zmt.model.SUser;
import com.jf.projects.zmt.vo.OptionVo;
import com.jf.projects.zmt.vo.ResponseVO;
import com.jf.projects.zmt.vo.inspection.AddInspectionUser;
import com.jf.projects.zmt.vo.user.UserSearch;

public interface InspectionService {
    /**
     * 分页查找检疫中心信息
     * 
     * @param uSearch
     * @return
     */
    ResponseVO findInspectionInfo(UserSearch uSearch);

    /**
     * 添加检疫中心
     * 
     * @param aVo
     * @return
     */
    ResponseVO addInspection(Inspectin Vo);

    /**
     * 添加检疫中心人员
     * 
     * @param vo
     * @return
     */
    int addInspectionUser(AddInspectionUser vo);

    /**
     * 通过检验中心查找该检验中心的检验人员信息
     * 
     * @param userSearch
     * @return
     */
    ResponseVO findInspectionUserInfo(UserSearch userSearch);

    /**
     * 启用或者禁用某一个检疫中心
     * 
     * @param id
     * @param status
     * @return
     */
    ResponseVO startOrForbid(String id, String status);

    /**
     * 编辑检验中心
     * 
     * @param vo
     * @return
     */
    ResponseVO updateInspection(Inspectin vo);

    /**
     * 修改检验中心人员
     * 
     * @param vo
     * @return
     */
    int updateInspectionUser(SUser vo);

    List<OptionVo> getUsers();

}
