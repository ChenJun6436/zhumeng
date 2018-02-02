package com.zmt.zmtofficialwebsite.vo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 描述: 新闻vo
 *
 * @author yt
 * @create 2018-01-09 15:12
 */
public class NewsVo {

    /**
     * id
     */
    private Long id;

    /**
     * 类型(1公司新闻,2行业新闻)
     */
    private Integer type;

    /**
     * 标题
     */
    private String title;

    /**
     * 发布时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:ss:mm", timezone = "GMT+8")
    private Date createTime;

    public NewsVo() {
        super();
    }

    public NewsVo(Long id, Integer type, String title, Date createTime) {
        this.id = id;
        this.type = type;
        this.title = title;
        this.createTime = createTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
