package com.jf.projects.zmt.service;

import com.jf.projects.zmt.model.PigFile;
import com.jf.projects.zmt.vo.ResponseVO;
import com.jf.projects.zmt.vo.farms.AppSearch;
import com.jf.projects.zmt.vo.fileManager.CreateFileVo;
import com.jf.projects.zmt.vo.fileManager.FileSearch;

public interface PigFileService {
	/**
	 * 保存档案
	 * 
	 * @param createFileVo
	 * @return
	 */
	int savePigFile(CreateFileVo createFileVo);

	/**
	 * 查找生猪档案
	 * 
	 * @param fileSearch
	 * @return
	 */
	ResponseVO getFile(FileSearch fileSearch);

	/**
	 * 通过生猪唯一标签删除档案
	 * 
	 * @param sign
	 * @return
	 */
	ResponseVO deleteFileBySign(String sign);

	/**
	 * 根据猪id修改状态
	 * 
	 * @param pigId
	 *            猪id
	 * @param status
	 * @return
	 */
	boolean updateStatus(String pigId, Integer status);

	/**
	 * 根据猪id修改任何字段
	 * 
	 * @param p
	 *            除了id 传什么改什么
	 * @return
	 */
	boolean updateAllByPigId(PigFile p);

	/**
	 * 判断猪id是否存在
	 * 
	 * @param pigId
	 * @return
	 */
	boolean existPigId(String pigId);

	/**
	 * 养殖APP查找某一个养殖户养殖户养的生猪
	 * 
	 * @param vo
	 * @return
	 */
	ResponseVO appFindFileOfFamer(AppSearch vo);

	/**
	 * APP端养殖户转让生猪
	 * 
	 * @param id
	 * @param farmerId
	 * @param sign
	 * @return
	 */
	ResponseVO appFarmerCancelPig(String id, String farmerId,
			Integer pigStatus, String sign, String currentUserId);

	/**
	 * APP端在生猪正常的情况下修改生猪状态为死亡
	 * 
	 * @param id
	 * @param pigStatus
	 * @return
	 */
	ResponseVO appUpdatePigFileStatus(String id, Integer pigStatus,
			String currentUserId);

	/**
	 * 通过生猪唯一标签查找生猪档案
	 * 
	 * @param sign
	 * @return
	 */
	PigFile findPigfileBySign(String sign);

	/**
	 * app端判断该标签
	 * 
	 * @param sign
	 * @return
	 */
	ResponseVO appGetDetail(String sign, String id);

}
