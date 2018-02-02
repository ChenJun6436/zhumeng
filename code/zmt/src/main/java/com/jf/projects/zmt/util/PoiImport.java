package com.jf.projects.zmt.util;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * 描述: excel导入
 *
 * @author dengpeng
 * @create 2018-01-04 15:21
 */
public class PoiImport {

  public static void main(String[] args) {
    try {
      InputStream inputStream = new FileInputStream(
          new File("C:\\Users\\Administrator\\Desktop\\新建 Microsoft Excel 工作表.xlsx"));
      List list = importExcel(inputStream, "新建 Microsoft Excel 工作表.xlsx");
      System.out.println(list);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
  }

  /**
   * 获取excel文件内容
   *
   * @param inputStream s输入流
   * @param fileName 文件名
   * @return pIds
   */
  public static List<String> importExcel(InputStream inputStream, String fileName) {
    boolean is2007 = false;
    if (fileName.endsWith("xlsx")) {
      is2007 = true;
    }

    Workbook workbook = null;
    try {
      if (is2007) {
        workbook = new XSSFWorkbook(inputStream);
      } else {
        workbook = new HSSFWorkbook(inputStream);
      }

    } catch (IOException e) {
      e.printStackTrace();
    }

    List<String> pIds = new ArrayList<>();
    //遍历集合，组装结果
    assert workbook != null;
    int sheerCount = workbook.getNumberOfSheets();
    // 遍历每个Sheet
    for (int i = 0; i < sheerCount; i++) {
      Sheet sheet = workbook.getSheetAt(i);
      int rowCount = sheet.getPhysicalNumberOfRows();
      //遍历每一行
      for (int j = 1; j < rowCount; j++) {
        Row row = sheet.getRow(j);
        int cellCount = row.getPhysicalNumberOfCells(); // 获取总列数
        // 遍历每一列
        for (int k = 0; k < cellCount; k++) {
          Cell cell = row.getCell(k);
          pIds.add(cell.getStringCellValue());
        }
      }
    }
    try {
      inputStream.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return pIds;
  }
}
