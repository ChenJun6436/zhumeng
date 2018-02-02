package com.jf.projects.zmt.vo.slaughterhouse;

public class SlaughterhousePigVo {
    private String id;

    /**
     * 猪id
     */
    private String pigId;

    /**
     * 品种
     */
    private String pigBreed;

    private String status;

    private String createTime;

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

}
