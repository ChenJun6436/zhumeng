package com.jf.projects.zmt.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jf.projects.zmt.service.hikVideoService;
import com.jf.projects.zmt.util.ConstantsUtil;
import com.jf.projects.zmt.vo.ResponseVO;

/**
 * 
 * @className: hikVideoController
 *
 * @description:海康威视视频地址
 *
 * @author wj
 *
 * @date 2017年12月14日下午3:40:02
 *
 */
@Controller
@RequestMapping("/*")
public class hikVideoController {

    @Autowired
    private hikVideoService hikVideoService;

    /**
     * 获取视频地址信息
     * 
     * @return
     */
    @RequestMapping(value = "/sign/video/find_video", method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public ResponseVO getVideo(@RequestParam(value = "slaughterhouseId", required = false) String slaughterhouseId) {
        ResponseVO responseVO = new ResponseVO();
        try {
            responseVO.setCode(ConstantsUtil.RES_SUCCESS_CODE);
            responseVO.setMessage(ConstantsUtil.RES_SUCCESS_MESSAGE);
            responseVO.setData(hikVideoService.findVideoList(slaughterhouseId));
            return responseVO;
        } catch (Exception e) {
            responseVO.setCode(ConstantsUtil.RES_FAIL_CODE);
            responseVO.setMessage(ConstantsUtil.RES_FAIL_MESSAGE);
            return responseVO;
        }
    }
    
    
    /**
     * 新增视频地址信息
     * @param rtmp
     * @param videoNo
     * @param hls
     * @param slaughterhouseId
     * @return
     */
    @RequestMapping(value = "/sign/video/add_video", method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public ResponseVO addVideo(@RequestParam(value = "name", required = false) String name,
    						   @RequestParam(value = "rtmp", required = true) String rtmp,
                               @RequestParam(value = "videoNo", required = false) String videoNo,
                               @RequestParam(value = "hls", required = true) String hls,
                               @RequestParam(value = "slaughterhouseId", required = false) String slaughterhouseId) {
        ResponseVO responseVO = new ResponseVO();
        try {
            responseVO.setCode(ConstantsUtil.RES_SUCCESS_CODE);
            responseVO.setMessage(ConstantsUtil.RES_SUCCESS_MESSAGE);
            hikVideoService.addVideo(rtmp,hls,videoNo,slaughterhouseId);
            return responseVO;
        } catch (Exception e) {
            responseVO.setCode(ConstantsUtil.RES_FAIL_CODE);
            responseVO.setMessage(ConstantsUtil.RES_FAIL_MESSAGE);
            return responseVO;
        }
    }
    
    
    /**
     * 更新视频地址信息
     * @param hikVideoId
     * @param rtmp
     * @param videoNo
     * @param hls
     * @param slaughterhouseId
     * @return
     */
    @RequestMapping(value = "/sign/video/update_video", method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public ResponseVO updateVideo(@RequestParam(value = "hikVideoId", required = true) String hikVideoId,
                               @RequestParam(value = "rtmp", required = false) String rtmp,
                               @RequestParam(value = "videoNo", required = false) String videoNo,
                               @RequestParam(value = "hls", required = false) String hls,
                               @RequestParam(value = "slaughterhouseId", required = false) String slaughterhouseId) {
        ResponseVO responseVO = new ResponseVO();
        try {
            responseVO.setCode(ConstantsUtil.RES_SUCCESS_CODE);
            responseVO.setMessage(ConstantsUtil.RES_SUCCESS_MESSAGE);
            hikVideoService.updateVideo(hikVideoId,rtmp,hls,videoNo,slaughterhouseId);
            return responseVO;
        } catch (Exception e) {
            responseVO.setCode(ConstantsUtil.RES_FAIL_CODE);
            responseVO.setMessage(ConstantsUtil.RES_FAIL_MESSAGE);
            return responseVO;
        }
    }
    
    /**
     * 删除视频地址信息
     * @param hikVideoId
     * @return
     */
    @RequestMapping(value = "/sign/video/delete_video", method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public ResponseVO deleteVideo(@RequestParam(value = "hikVideoId", required = true) String hikVideoId) {
        ResponseVO responseVO = new ResponseVO();
        try {
            responseVO.setCode(ConstantsUtil.RES_SUCCESS_CODE);
            responseVO.setMessage(ConstantsUtil.RES_SUCCESS_MESSAGE);
            hikVideoService.deleteHikVideo(hikVideoId);
            return responseVO;
        } catch (Exception e) {
            responseVO.setCode(ConstantsUtil.RES_FAIL_CODE);
            responseVO.setMessage(ConstantsUtil.RES_FAIL_MESSAGE);
            return responseVO;
        }
    }

}
