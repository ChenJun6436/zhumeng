package com.zmt.zmtofficialwebsite.util.filter;

import org.springframework.boot.SpringBootConfiguration;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 跨域请求拦截器
 *
 * @author dengpeng
 * @date 2017/8/2
 */
@SpringBootConfiguration
public class CORSfilter implements Filter {

  @Override
  public void destroy() {

  }

  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
      throws IOException, ServletException {
    HttpServletResponse res = (HttpServletResponse) servletResponse;
    HttpServletRequest request = (HttpServletRequest) servletRequest;
    res.setContentType("textml;charset=UTF-8");
    res.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
    res.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
    res.setHeader("Access-Control-Max-Age", "0");
    res.setHeader("Access-Control-Allow-Headers",
        "Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With,userId,token");
    res.setHeader("Access-Control-Allow-Credentials", "true");
    res.setHeader("XDomainRequestAllowed", "1");
    filterChain.doFilter(servletRequest, servletResponse);
  }

  @Override
  public void init(FilterConfig filterConfig) {

  }

}
