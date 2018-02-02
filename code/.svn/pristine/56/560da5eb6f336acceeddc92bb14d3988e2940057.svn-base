package com.zmt.zmtofficialwebsite.util;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.dtools.ini.BasicIniFile;
import org.dtools.ini.IniFile;
import org.dtools.ini.IniFileReader;
import org.dtools.ini.IniFileWriter;
import org.dtools.ini.IniItem;
import org.dtools.ini.IniSection;

/**
 * 描述: 读取修改ini文件
 *
 * @author Administrator
 * @create 2018-01-08 16:27
 */
public class IniUtil {

  /**
   * 读取配置文件数据
   *
   * @return map
   */
  public static Map<String, String> readIni() throws IOException {
    IniFile ini = new BasicIniFile();
    IniFileReader reader = new IniFileReader(ini, new File(IniUtil.class.getResource("/").getPath() + "user.ini"));
    reader.read();

    Map<String, String> map = new HashMap<>();
    for (int i = 0; i < ini.getNumberOfSections(); i++) {
      IniSection sec = ini.getSection(i);
      for (IniItem item : sec.getItems()) {
        map.put(item.getName(), item.getValue());
      }
    }
    return map;
  }

  /**
   * 修改配置文件信息
   *
   * @param password 密码
   * @return boolean
   */
  public static boolean changePassword(String password) {
    IniFile ini = new BasicIniFile();
    String path = IniUtil.class.getResource("/").getPath() + "user.ini";
    IniFileReader reader = new IniFileReader(ini, new File(path));
    IniFileWriter writer = new IniFileWriter(ini, new File(path));
    try {
      reader.read();

      IniSection sec = ini.getSection(0);
      IniItem iniItem = sec.getItem("password");
      iniItem.setValue(password);
      sec.addItem(iniItem);
      ini.addSection(sec);
      writer.write();

    } catch (IOException e) {
      e.printStackTrace();
      return false;
    }
    return true;
  }

  public static void main(String[] args) throws IOException {
    System.out.println(IniUtil.readIni());
  }
}
