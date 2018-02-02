package com.jf.projects.zmt.service;

import javax.servlet.http.HttpServletResponse;

import com.jf.projects.zmt.vo.RequestPageParam;
import com.jf.projects.zmt.vo.ResponseVO;

public interface SignExcelService {
	/**
	 * 获取生猪excel信息
	 * 
	 * @param vo
	 * @return
	 */
	ResponseVO getPageSignExcel(RequestPageParam vo);

	void downloadSignExcel(String url, HttpServletResponse response);
}
