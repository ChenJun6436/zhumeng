package com.jf.projects.zmt.service;

import java.util.List;

import com.jf.projects.zmt.model.AndSlaughterhouseUser;
import com.jf.projects.zmt.vo.BaseParam;
import com.jf.projects.zmt.vo.slaughterhouse.SlaughterhousePigVo;

/**
 * @className: SlaughterhouseService
 * @description：屠宰场
 * @author yt
 * @date 2017年10月19日下午5:09:39
 */
public interface AndSlaughterhouseUserService {

    boolean add(AndSlaughterhouseUser vo);

    /**
     * 用户管理的猪列表
     * 
     * @param param
     * @return
     */
    List<SlaughterhousePigVo> findListByPid(BaseParam param);

    /**
     * 猪列表总条数
     * 
     * @param search
     * @return
     */
    Long findListCountByPid(BaseParam param);

    /**
     * 生猪屠宰
     * 
     * @param id
     * @return
     */
    boolean slaughter(String id, String slaughterhouseId);

    /**
     * 查询屠宰场人数
     * 
     * @param slaughterhouseId
     *            屠宰场id
     * @return
     */
    Long findPeopleNumBySlaughterhouseId(String slaughterhouseId);

    boolean addUserSlaughter(AndSlaughterhouseUser vo);

    /**
     * 判断猪id是否被录入
     * 
     * @param vo
     * @return
     */

    boolean existPigId(String pigId);

    /**
     * 猪列表
     * 
     * @param param
     * @return
     */
    List<SlaughterhousePigVo> findList(BaseParam param);

}
