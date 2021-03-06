package com.jf.projects.zmt.vo;

import java.io.Serializable;
/**
 * 
 * @className: ResponseVO
 *
 * @description:基础返回vo
 *
 * @author wj
 *
 * @date 2017年11月8日上午9:58:18
 *
 */
public class ResponseVO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 返回信息代码 0->成功；错误代码参考constansUtil类
	 */
	private String code;
	/**
	 * 错误信息
	 */
	private String message;
	/**
	 * 封装json数据
	 */
	private Object data;

	/**
	 * 记录总数
	 */
	public long recordsTotal = 0;

	/**
	 * 当前返回数据条数
	 */
	public long recordsFiltered = 0;

	public ResponseVO() {

	}

	public ResponseVO(long recordsTotal, Object data) {
		super();
		this.recordsTotal = recordsTotal;
		this.data = data;
	}

	public ResponseVO(long recordsTotal, long recordsFiltered, Object data) {
		super();
		this.recordsTotal = recordsTotal;
		this.recordsFiltered = recordsFiltered;
		this.data = data;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code == null ? "" : code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {

		this.message = message == null ? "" : message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data == null ? "" : data;
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

}
