package com.zmt.zmtofficialwebsite.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 描述: 案例类型
 *
 * @author yt
 * @create 2018-01-09 10:57
 */
@Entity
@Table(name = "t_aanvraag_type")
public class AanvraagType extends BaseMode {
    /**
     * 标题
     */
    @Column(name = "name", length = 50)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // @OneToMany(mappedBy = "case")
    // private List<Case> caseList;

}
