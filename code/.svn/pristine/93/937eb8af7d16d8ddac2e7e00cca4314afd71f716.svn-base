package com.jf.projects.zmt.service;

import com.jf.projects.zmt.vo.ResponseVO;
import com.jf.projects.zmt.vo.account.AppAddUserInfoVo;
import com.jf.projects.zmt.vo.farms.AddFarmerUserInfo;
import com.jf.projects.zmt.vo.farms.AppSearch;
import com.jf.projects.zmt.vo.farms.AppUpdateVo;
import com.jf.projects.zmt.vo.farms.SerchVo;
import com.jf.projects.zmt.vo.fileManager.FileSearch;

public interface FarmsService {
	/**
	 * 查找养殖户
	 * 
	 * @param userSearch
	 * @return
	 */
	ResponseVO findFarmsInfos(SerchVo userSearch);

	/**
	 * 在养殖户下删除通过生猪生猪唯一标志该生猪
	 * 
	 * @param sign
	 * @return
	 */
	ResponseVO deletePigFileByStatus(String sign);

	/**
	 * 查找养殖户养殖的生猪
	 * 
	 * @param fileSearch
	 * @return
	 */
	ResponseVO findFileByFarms(FileSearch fileSearch);

	/**
	 * 通过姓名电话搜索养殖户
	 * 
	 * @param keyWords
	 * @return
	 */
	ResponseVO getFarmsByKeyWords(String keyWords);

	/**
	 * 查找拥有养殖的角色
	 * 
	 * @return
	 */
	ResponseVO findRoleVoByRource();

	/**
	 * 查找部门通过养殖权限
	 * 
	 * @return
	 */
	ResponseVO findDepartmentVoByRource();

	/**
	 * 新增养殖户
	 * 
	 * @param vo
	 * @return
	 */
	Integer addFarms(AddFarmerUserInfo vo);

	/**
	 * 修改养殖户
	 * 
	 * @param vo
	 * @return
	 */
	Integer updateFarms(AddFarmerUserInfo vo);

	/**
	 * app查找某一个人建立的养殖户
	 * 
	 * @param vo
	 * @return
	 */
	ResponseVO findAppFarmsInfo(AppSearch vo);

	/**
	 * app端新增养殖户
	 * 
	 * @param vo
	 * @return
	 */
	Integer appAddFarmer(AppAddUserInfoVo vo);

	/**
	 * app端获取养殖户信息，通过用户id
	 * 
	 * @param id
	 * @return
	 */
	ResponseVO appGetFarmerInfo(String id);

	/**
	 * 修改养殖户信息
	 * 
	 * @param
	 * @return
	 */
	ResponseVO appUpdateFarmer(AppUpdateVo vo);
}
