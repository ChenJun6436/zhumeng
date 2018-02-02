package com.jf.projects.zmt.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jf.projects.zmt.model.Inspectin;
import com.jf.projects.zmt.vo.OptionVo;
import com.jf.projects.zmt.vo.inspection.InspectionListVo;
import com.jf.projects.zmt.vo.inspection.InspectionUserVo;

public interface InspectinMapper extends BaseMapper<Inspectin> {
    /**
     * 查找检验中心
     * 
     * @param key
     * @param start
     * @param length
     * @return
     */
    List<InspectionListVo> findListByKeyWords(@Param("key") String key,
                                              @Param(value = "start") Integer start,
                                              @Param(value = "length") Integer length);

    /**
     * 总条数
     * 
     * @param key
     * @return
     */
    long countInspection(@Param("key") String key);

    /**
     * 查找每一个检验中心下的人员
     * 
     * @param key
     * @param inspectionId
     * @param start
     * @param length
     * @return
     */
    List<InspectionUserVo> findInspectionUserInfo(@Param("key") String key,
                                                  @Param("inspectionId") String inspectionId,
                                                  @Param("start") Integer start,
                                                  @Param("length") Integer length);

    /**
     * 总条数
     * 
     * @param key
     * @param inspectionId
     * @return
     */
    long countInspectionUserInfo(@Param("key") String key,
                                 @Param("inspectionId") String inspectionId);

    /**
     * 启用或者禁用某一个检验中心
     * 
     * @param id
     * @param status
     * @return
     */
    int startOrForbid(@Param("id") String id, @Param("status") String status);

    /**
     * 清除某一个和检验中心地址
     * 
     * @param id
     * @return
     */
    int clearInspectionAddress(@Param("id") String id);

    /**
     * 修改之前清除地址
     * 
     * @param id
     * @return
     */
    int clearInspectionUserAddress(@Param("id") String id);

    /**
     * 用户是否在使用
     * 
     * @param id
     * @return
     */
    String ExitUser(@Param("id") String id);

    List<OptionVo> getUsers();
}
