package com.jf.projects.zmt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jf.projects.zmt.dao.HikVideoMapper;
import com.jf.projects.zmt.model.HikVideo;
import com.jf.projects.zmt.service.hikVideoService;
import com.jf.projects.zmt.util.UUIDUtil;

/**
 * 
 * @className: hikVidelServiceImpl
 *
 * @description:海康威视视频地址实现
 *
 * @author wj
 *
 * @date 2017年12月14日下午3:46:55
 *
 */

@Service
public class hikVidelServiceImpl implements hikVideoService {

    @Autowired
    private HikVideoMapper hikVideoMapper;

    @Override
    public List<HikVideo> findVideoList(String slaughterhouseId) {
        return hikVideoMapper.findBySlaughterhouseId(slaughterhouseId);
    }

    @Override
    public void addVideo(String rtmp, String hls, String videoNo, String slaughterhouseId) {
        //新增视频地址信息
        HikVideo hikVideo = new HikVideo();
        hikVideo.setId(UUIDUtil.getUUID());
        hikVideo.setHls(hls);
        hikVideo.setRtmp(rtmp);
        hikVideo.setSlaughterhouseId(slaughterhouseId);
        hikVideo.setVideoNo(videoNo);
        hikVideoMapper.insert(hikVideo);
        
    }

    @Override
    public void deleteHikVideo(String hikVideoId) {
        hikVideoMapper.delete(hikVideoId);
        
    }

    @Override
    public void updateVideo(String hikVideoId, String rtmp, String hls, String videoNo, String slaughterhouseId) {
        HikVideo hikVideo = hikVideoMapper.findById(hikVideoId);
        if(hikVideo != null ){
            hikVideo.setHls(hls);
            hikVideo.setRtmp(rtmp);
            hikVideo.setSlaughterhouseId(slaughterhouseId);
            hikVideo.setVideoNo(videoNo);
            hikVideoMapper.update(hikVideo);
        }
                        
    }


}
