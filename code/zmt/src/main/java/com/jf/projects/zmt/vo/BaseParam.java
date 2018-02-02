package com.jf.projects.zmt.vo;

import java.util.Date;

public class BaseParam {
    private String id;

    private String pigId;

    private String userId;

    private String type;

    /** 默认开始条数 */
    public final static int DEFAULT_START = 0;

    /** 默认查询条数 */
    public final static int DEFAULT_LENGTH = 10;

    /**
     * 从第几条开始显示
     */
    private Integer start;

    /**
     * 每页显示多少条
     */
    private Integer length;

    /**
     * 生猪品种
     */
    private String pigBreed;

    /**
     * 生猪状态
     */
    private String pigStatus;

    /**
     * 开始时间
     */
    private Date startTime;

    /**
     * 结束时间
     */
    private Date endTime;

    public BaseParam(String id, String pigId, Integer start, Integer length) {
        super();
        this.id = id;
        this.pigId = pigId;
        this.start = start;
        this.length = length;
    }

    public BaseParam() {

    }

    public BaseParam(String id, String pigId, Integer start, Integer length, String pigBreed,
                     String pigStatus) {
        super();
        this.id = id;
        this.pigId = pigId;
        this.start = start;
        this.length = length;
        this.pigBreed = pigBreed;
        this.pigStatus = pigStatus;
    }

    public BaseParam(String id, String pigBreed, String pigId, Integer start, Integer length) {
        super();
        this.id = id;
        this.pigBreed = pigBreed;
        this.pigId = pigId;
        this.start = start;
        this.length = length;
    }

    public Integer getStart() {
        if (this.start == null) {
            start = DEFAULT_START;
        }
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getLength() {
        if (this.length == null) {
            length = DEFAULT_LENGTH;
        }
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPigId() {
        return pigId;
    }

    public void setPigId(String pigId) {
        this.pigId = pigId;
    }

    public String getPigBreed() {
        return pigBreed;
    }

    public void setPigBreed(String pigBreed) {
        this.pigBreed = pigBreed;
    }

    public String getPigStatus() {
        return pigStatus;
    }

    public void setPigStatus(String pigStatus) {
        this.pigStatus = pigStatus;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

}
