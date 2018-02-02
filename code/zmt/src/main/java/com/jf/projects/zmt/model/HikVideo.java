package com.jf.projects.zmt.model;

import java.util.Date;

public class HikVideo {
    /**
     * 主键
     */
    private String id;
    /**
     * 视频编号
     */
    private String videoNo;
    /**
     * rtmp地址
     */
    private String rtmp;
    /**
     * hls地址
     */
    private String hls;
    /**
     * 屠宰场ID
     */
    private String slaughterhouseId;
    /**
     * 生成时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;
    /**
     * 状态
     */
    private String status;
   
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVideoNo() {
        return videoNo;
    }

    public void setVideoNo(String videoNo) {
        this.videoNo = videoNo;
    }

    public String getRtmp() {
        return rtmp;
    }

    public void setRtmp(String rtmp) {
        this.rtmp = rtmp;
    }

    public String getHls() {
        return hls;
    }

    public void setHls(String hls) {
        this.hls = hls;
    }

    public String getSlaughterhouseId() {
        return slaughterhouseId;
    }

    public void setSlaughterhouseId(String slaughterhouseId) {
        this.slaughterhouseId = slaughterhouseId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}