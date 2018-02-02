package com.zmt.zmtofficialwebsite.controller.admin;

import com.zmt.zmtofficialwebsite.config.IniConfig;
import com.zmt.zmtofficialwebsite.util.IniUtil;
import com.zmt.zmtofficialwebsite.util.result.ResultVo;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 描述: 用户
 *
 * @author Administrator
 * @create 2018-01-09 15:47
 */
@RestController
@RequestMapping("/user")
public class UserController {

  @Autowired
  IniConfig iniConfig;

  @Autowired
  HttpServletRequest request;

  /**
   * 用户登陆
   *
   * @param username 用户名
   * @param password 密码
   * @return ResultVo
   */
  @RequestMapping("/login")
  public ResultVo login(@RequestParam(value = "username", required = false) String username,
      @RequestParam(value = "password", required = false) String password) {

    if (StringUtils.isBlank(username) || StringUtils.isBlank(password)) {
      return ResultVo.error("参数错误");
    }

    if (!username.equals(iniConfig.getUsername()) || !password.equals(iniConfig.getPassword())) {
      return ResultVo.error("用户名或密码错误");
    }

    HttpSession session = request.getSession();
    session.setAttribute("username", username);
    session.setMaxInactiveInterval(3600);
    return ResultVo.ok();
  }

  /**
   * 修改密码
   *
   * @param password 密码
   * @return ResultVo
   */
  @RequestMapping("/changePassword")
  public ResultVo changePassword(@RequestParam(value = "password", required = false) String password,
      @RequestParam(value = "oldPassword", required = false) String oldPassword) {

    if (StringUtils.isBlank(password) || StringUtils.isBlank(oldPassword)) {
      return ResultVo.error("参数错误");
    }
    if (!oldPassword.equals(iniConfig.getPassword())) {
      return ResultVo.error("密码错误");
    }
    if (password.equals(iniConfig.getPassword())) {
      return ResultVo.error("新旧密码不能相同");
    }

    IniUtil.changePassword(password);
    HttpSession session = request.getSession();
    session.removeAttribute("username");
    return ResultVo.ok();
  }

  /**
   * 退出登录
   *
   * @return ResultVo
   */
  @RequestMapping("/logout")
  public ResultVo logout() {
    HttpSession session = request.getSession();
    session.removeAttribute("username");
    return ResultVo.ok();
  }
}
