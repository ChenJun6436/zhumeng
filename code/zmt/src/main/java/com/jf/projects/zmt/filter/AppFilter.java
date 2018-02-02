package com.jf.projects.zmt.filter;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.log4j.Logger;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;



import com.jf.projects.zmt.util.ConstantsUtil;
import com.jf.projects.zmt.util.MD5Util;
import com.jf.projects.zmt.vo.ResponseVO;


/**
 * 
 * @className: AppFilter
 *
 * @description:消息的合法性处理
 *
 * @author wj
 *
 * @date 2017年10月19日下午5:47:47
 *
 */
 

public class AppFilter implements Filter {

	private static final String key = "0635e79ed5468ab06ec0e5cd8cb5f8e4";
	
//	private static ConcurrentMap<String,String> tokenMap = new ConcurrentHashMap<String, String>();
	
	private Logger log = Logger.getLogger(AppFilter.class); 

	// 执行过滤
	public void doFilter(ServletRequest request, ServletResponse response,FilterChain chain) throws IOException, ServletException {
		CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver(((HttpServletRequest) request).getSession().getServletContext());
		log.debug( ((HttpServletRequest)request).getRequestURL().toString().toLowerCase());
		if(((HttpServletRequest)request).getRequestURL().toString().toLowerCase().contains("notify")){
			chain.doFilter(request, response);
			return;
		}
		if (commonsMultipartResolver.isMultipart((HttpServletRequest) request)) {
			MultipartHttpServletRequest multipartRequest = commonsMultipartResolver.resolveMultipart((HttpServletRequest) request);
			request = multipartRequest;
		}

//		String ip = request.getRemoteAddr();	
        //按照加密规则检验token合法性
		StringBuffer buffer = new StringBuffer();
		String token = request.getParameter("token");	
		buffer.append(key);
		buffer.append(request.getParameter("timestamp"));
//		System.out.println(token);
		if (MD5Util.MD5(buffer.toString()).equals(token)) {
			/*String verifyToken = tokenMap.get(ip);
			if(verifyToken !=null && verifyToken.equals(token)){
				ResponseVO res = new ResponseVO();
				res.setCode(ConstantsUtil.RES_ILLEGAL_CODE);
				res.setMessage(ConstantsUtil.RES_ILLEGAL_MESSAGE);		
				response.getWriter().write(JSONObject.fromObject(res).toString());
				return ;
			}*/
//			tokenMap.put(ip, token);
			chain.doFilter(request, response);
		} else {
			ResponseVO res = new ResponseVO();
			res.setCode(ConstantsUtil.RES_ILLEGAL_CODE);
			res.setMessage(ConstantsUtil.RES_ILLEGAL_MESSAGE);		
			response.getWriter().write(JSONObject.fromObject(res).toString());
		}

	}

	public void init(FilterConfig filterConfig) throws ServletException {

	}

	public void destroy() {

	}
	
	
}
