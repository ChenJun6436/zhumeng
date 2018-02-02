package com.zmt.zmtofficialwebsite.vo;

/**
 * 描述: 案例类型vo
 *
 * @author yt
 * @create 2018-01-09 15:12
 */
public class CaseNumVo {

    /**
     * id
     */
    private Long id;

    /**
     * 数量
     */
    private Long num;

    public CaseNumVo() {
        super();
    }

    public CaseNumVo(Long id, Long num) {
        super();
        this.id = id;
        this.num = num;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNum() {
        return num;
    }

    public void setNum(Long num) {
        this.num = num;
    }

}
