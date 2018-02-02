package com.zmt.zmtofficialwebsite.util.result;

import java.util.List;

/**
 * 分页数据返回vo
 *
 * @author dengpeng
 * @date 2017/11/9
 */
public class PageResultVo {

    /**
     * 记录总数
     */
    private long recordsTotal = 0;

    /**
     * 当前页的记录总数
     */
    private long recordsFiltered = 0;

    /**
     * 返回数据
     */
    private List<?> list;

    /**
     * 状态码
     */
    private String code;

    /**
     * 成功失败
     */
    private Boolean success = true;

    public PageResultVo() {
        super();
    }

    public static PageResultVo error() {
        return new PageResultVo(null, null, null, "500", false);
    }

    public PageResultVo(long recordsTotal, long recordsFiltered, List<?> list) {
        super();
        this.recordsTotal = recordsTotal;
        this.recordsFiltered = recordsFiltered;
        this.list = list;
    }

    private PageResultVo(Long recordsTotal, Long recordsFiltered, List<?> list, String code,
                         Boolean success) {
        super();
        this.recordsTotal = recordsTotal;
        this.recordsFiltered = recordsFiltered;
        this.list = list;
        this.code = code;
        this.success = success;
    }

    public static PageResultVo success(long recordsTotal, long recordsFiltered, List<?> list) {
        return new PageResultVo(recordsTotal, recordsFiltered, list, "200", true);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public long getRecordsTotal() {
        return recordsTotal;
    }

    public void setRecordsTotal(long recordsTotal) {
        this.recordsTotal = recordsTotal;
    }

    public long getRecordsFiltered() {
        return recordsFiltered;
    }

    public void setRecordsFiltered(long recordsFiltered) {
        this.recordsFiltered = recordsFiltered;
    }

    public List<?> getList() {
        return list;
    }

    public void setList(List<?> list) {
        this.list = list;
    }

}
