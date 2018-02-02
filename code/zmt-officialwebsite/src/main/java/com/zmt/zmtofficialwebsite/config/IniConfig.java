package com.zmt.zmtofficialwebsite.config;

import com.zmt.zmtofficialwebsite.util.IniUtil;
import java.io.IOException;
import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * 描述: 读取用户名密码
 *
 * @author Administrator
 * @create 2018-01-08 16:26
 */
@Component
public class IniConfig {

  private String username;
  private String password;

  {
    try {
      Map<String, String> map = IniUtil.readIni();
      this.setUsername(map.get("username"));
      this.setPassword(map.get("password"));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public IniConfig() {
  }

  public IniConfig(String username, String password) {
    this.username = username;
    this.password = password;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}
