package com.zmt.zmtofficialwebsite.vo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 描述: 案例vo
 *
 * @author yt
 * @create 2018-01-09 15:12
 */
public class CaseVo {

    /**
     * id
     */
    private Long id;

    /**
     * 案例名
     */
    private String name;

    /**
     * 发布时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:ss:mm", timezone = "GMT+8")
    private Date createTime;

    /**
     * 内容
     */
    private String content;

    public CaseVo() {
    }

    public CaseVo(Long id, String name, Date createTime) {
        this.id = id;
        this.name = name;
        this.createTime = createTime;
    }

    public CaseVo(Long id, String name, Date createTime, String content) {
        super();
        this.id = id;
        this.name = name;
        this.createTime = createTime;
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
