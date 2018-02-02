package com.zmt.zmtofficialwebsite.controller;

import com.zmt.zmtofficialwebsite.config.IniConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 描述: test
 *
 * @author Administrator
 * @create 2018-01-08 16:39
 */
@Controller
public class testController {

  @Autowired
  IniConfig iniConfig;


  @RequestMapping("/test")
  @ResponseBody
  public String get() {
    return iniConfig.getPassword();
  }
}
