package com.zmt.zmtofficialwebsite.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 描述: 案例
 *
 * @author yt
 * @create 2018-01-09 10:57
 */
@Entity
@Table(name = "t_case")
public class Case extends BaseMode {
    /**
     * 标题
     */
    @Column(name = "name", length = 50)
    private String name;

    /**
     * 内容
     */
    @Column(name = "content", length = 16777216)
    private String content;

    /**
     * 封面
     */
    @Column(name = "img_url")
    private String imgUrl;

    @ManyToOne
    @JoinColumn(name = "aanvraag_type_id")
    private AanvraagType aanvraagType;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public AanvraagType getAanvraagType() {
        return aanvraagType;
    }

    public void setAanvraagType(AanvraagType aanvraagType) {
        this.aanvraagType = aanvraagType;
    }

}
