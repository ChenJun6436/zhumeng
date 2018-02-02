package com.zmt.zmtofficialwebsite.util.result;

/**
 * 响应数据vo
 * 
 * @author dengpeng
 * @date 2017/11/6
 */
public class ResultVo {

    /**
     * 返回的状态码
     */
    private String code;

    /**
     * 信息
     */
    private String message;

    /**
     * 数据
     */
    private Object data;

    private Boolean success = true;

    public ResultVo() {
        super();
    }

    public static ResultVo ok() {
        return new ResultVo(null);
    }

    public ResultVo(String code, Boolean success) {
        super();
        this.code = code;
        this.success = success;
    }

    public static ResultVo error(String message) {
        return new ResultVo("500", message, null, false);
    }

    public ResultVo(Object date) {
        this.code = "200";
        this.message = "OK";
        this.data = date;
    }

    public ResultVo(String code, String message, String date, Boolean success) {
        super();
        this.code = code;
        this.message = message;
        this.data = date;
        this.success = success;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

}
