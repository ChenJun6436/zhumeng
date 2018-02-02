package com.zmt.zmtofficialwebsite.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 描述: 新闻
 *
 * @author dengpeng
 * @create 2018-01-09 10:57
 */
@Entity
@Table(name = "t_news")
public class News extends BaseMode {

    /**
     * 新闻标题
     */
    @Column(name = "headline", length = 50)
    private String headline;

    /**
     * 类型(1公司新闻,2行业新闻)
     */
    @Column(name = "type", length = 1)
    private Integer type;

    /**
     * 标题
     */
    @Column(name = "title", length = 100)
    private String title;

    /**
     * 关键字
     */
    @Column(name = "keywords", length = 200)
    private String keywords;

    /**
     * 描述
     */
    @Column(name = "description", length = 400)
    private String description;

    /**
     * 内容
     */
    @Column(name = "content", length = 16777216)
    private String content;

    @Column(name = "img_url")
    private String imgUrl;

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
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

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
