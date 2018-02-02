package com.jf.projects.zmt.service.impl;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jf.projects.zmt.dao.SignExcelMapper;
import com.jf.projects.zmt.service.SignExcelService;
import com.jf.projects.zmt.util.ConstantsUtil;
import com.jf.projects.zmt.vo.RequestPageParam;
import com.jf.projects.zmt.vo.ResponseVO;
import com.jf.projects.zmt.vo.farms.SignExcelVo;

@Service
public class SignExcelServiceImpl implements SignExcelService {
	@Autowired
	private SignExcelMapper mapper;

	@Override
	public ResponseVO getPageSignExcel(RequestPageParam vo) {
		ResponseVO responseVO = new ResponseVO();
		List<SignExcelVo> list = mapper.findAllSignExcel(vo.getStart(),
				vo.getLength());
		int total = mapper.countSignExcel();
		if (list != null) {
			responseVO.setData(list);
			responseVO.setRecordsFiltered(total);
			responseVO.setRecordsTotal(total);
		}
		responseVO.setCode(ConstantsUtil.RES_SUCCESS_CODE);
		responseVO.setMessage(ConstantsUtil.RES_SUCCESS_MESSAGE);
		return responseVO;
	}

	@Override
	public void downloadSignExcel(String url, HttpServletResponse response) {
		try {
			// path是指欲下载的文件的路径。
			File file = new File(url);
			// 取得文件名。
			String filename = file.getName();
			// 以流的形式下载文件。
			InputStream fis = new BufferedInputStream(new FileInputStream(url));
			byte[] buffer = new byte[fis.available()];
			fis.read(buffer);
			fis.close();
			// 清空response
			response.reset();
			// 设置response的Header
			response.addHeader("Content-Disposition", "attachment;filename="
					+ filename);
			response.addHeader("Content-Length", "" + file.length());
			OutputStream toClient = new BufferedOutputStream(
					response.getOutputStream());
			response.setContentType("application/octet-stream");
			toClient.write(buffer);
			toClient.flush();
			toClient.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}
