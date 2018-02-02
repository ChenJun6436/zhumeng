package com.jf.projects.zmt.service;

import java.util.List;

import com.jf.projects.zmt.model.HikVideo;
/**
 * 
 * @className: hikVideoService
 *
 * @description:海康威视视频地址
 *
 * @author wj
 *
 * @date 2017年12月14日下午3:45:54
 *
 */
public interface hikVideoService {

	/**
	 * 获取视频地址信息
	 * @param salghterhouseId
	 * @return
	 */
	List<HikVideo> findVideoList(String slaughterhouseId);
	
	/**
	 * 新增视频地址信息
	 * @param rtmp
	 * @param hls
	 * @param videoNo
	 * @param slaughterhouseId
	 */
	void addVideo(String rtmp,String hls,String videoNo,String slaughterhouseId);
	
	/**
	 * 更新视频地址信息
	 * @param hikVideoId
	 * @param rtmp
	 * @param hls
	 * @param videoNo
	 * @param slaughterhouseId
	 */
	void updateVideo(String hikVideoId,String rtmp,String hls,String videoNo,String slaughterhouseId);
	
	/**
	 * 删除视频地址信息
	 * @param hikVideoId
	 */
	void deleteHikVideo(String hikVideoId);


}
