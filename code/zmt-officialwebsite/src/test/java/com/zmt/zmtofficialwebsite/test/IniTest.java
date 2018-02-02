package com.zmt.zmtofficialwebsite.test;

import java.io.File;
import java.io.IOException;
import org.dtools.ini.BasicIniFile;
import org.dtools.ini.IniFile;
import org.dtools.ini.IniFileReader;
import org.dtools.ini.IniFileWriter;
import org.dtools.ini.IniItem;
import org.dtools.ini.IniSection;

/**
 * 描述: 读取ini文件
 *
 * @author Administrator
 * @create 2018-01-08 15:52
 */
public class IniTest {

  public static void main(String[] args) throws IOException {
    IniFile ini = new BasicIniFile(false);//不使用大小写敏感
    IniFileReader reader = new IniFileReader(ini,
        new File("E:\\IDEAworkspace\\zmt-officialwebsite\\src\\main\\resources\\user.ini"));
    reader.read();
    for (int i = 0; i < ini.getNumberOfSections(); i++) {
      IniSection sec = ini.getSection(i);
      System.out.println(sec.getItem("username").getValue());
      for (IniItem item : sec.getItems()) {
        System.out.println(item.getName() + " = " + item.getValue());
      }
    }
  }
}
