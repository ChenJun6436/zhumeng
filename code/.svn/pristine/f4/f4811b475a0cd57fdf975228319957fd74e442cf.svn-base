package com.jf.projects.zmt.service;

import com.jf.projects.zmt.model.SUser;
import com.jf.projects.zmt.vo.ResponseVO;
import com.jf.projects.zmt.vo.farms.SerchVo;
import com.jf.projects.zmt.vo.fileManager.FileBuliderVo;

public interface FileManagerZMTService {
	/**
	 * 查找建档者
	 * 
	 * @return
	 */
	ResponseVO findFileBuilders(SerchVo search);

	/**
	 * 查找建档者建立的档案
	 * 
	 * @param builderId
	 * @return
	 */

	ResponseVO findFileByBuildersId(FileBuliderVo fileBuliderVo);

	/**
	 * 查找拥有建档权限的角色
	 * 
	 * @return
	 */
	ResponseVO findRoleVoByRource();

	/**
	 * 查找部门通过建档权限
	 * 
	 * @return
	 */
	ResponseVO findDepartmentVoByRource();

	ResponseVO forbidOrStartBuilder(String builderId, String status);

	/**
	 * 修改建档人员信息
	 * 
	 * @param vo
	 * @return
	 */
	int updateBuliderUser(SUser vo);

}
