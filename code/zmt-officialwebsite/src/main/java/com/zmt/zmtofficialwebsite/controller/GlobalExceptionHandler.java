package com.zmt.zmtofficialwebsite.controller;

import com.zmt.zmtofficialwebsite.util.result.ResultVo;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.NoHandlerFoundException;

/**
 * 描述: 异常处理当访问异常时不再返回error page而是我们自定义的vo返回错误信息
 *
 * @author Administrator
 * @create 2018-01-10 14:51
 */
@ControllerAdvice
public class GlobalExceptionHandler {

  private Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

  /**
   * 系统异常处理 400 500...
   *
   * @param e 异常信息
   * @return ResultVo
   */
  @ExceptionHandler(value = Exception.class)
  @ResponseBody
  public ResultVo defaultErrorHandler(HttpServletRequest request, Exception e) {

    ResultVo vo = new ResultVo();
    vo.setMessage(e.getMessage());
    if (e instanceof MaxUploadSizeExceededException) {
      vo.setMessage("文件过大，最大为10MB");
    }
    if (e instanceof NoHandlerFoundException) {//404异常
      vo.setCode("404");
    } else {
      vo.setCode("500");
    }
    vo.setSuccess(false);
    return vo;
  }
}
