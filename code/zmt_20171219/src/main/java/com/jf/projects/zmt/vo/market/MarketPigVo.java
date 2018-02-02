package com.jf.projects.zmt.vo.market;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class MarketPigVo {

    /**
     * 猪id
     */
    private String pigId;

    /**
     * 重量
     */
    private Double weight;

    /**
     * 品种
     */
    private String pigBreed;

    /**
     * 录入人
     */
    private String creatorName;

    /**
     * 录入时间
     */
    private Date createTime;

    public String getPigId() {
        return pigId;
    }

    public void setPigId(String pigId) {
        this.pigId = pigId;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getPigBreed() {
        return pigBreed;
    }

    public void setPigBreed(String pigBreed) {
        this.pigBreed = pigBreed;
    }

    public String getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

    @JsonFormat(pattern = "yyyy-MM-dd")
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
