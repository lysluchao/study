package com.lc.util;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.File;
import java.io.IOException;

/**
 * @Description: Excel工具类，POI实现
 * @Auther: LuChao
 * @Date: 2022/8/11 11:12
 * @Version: v1.0
 */
public class ExcelUtil {

    /**
     * 创建excel文档
     *
     * @param path 存储路径
     * @param workbook  excel文档
     * @throws IOException 路径无效时
     */
    public static void createExcel(HSSFWorkbook workbook,String path) throws IOException {

        if (StringUtil.isBlank(path)) {
            throw new IllegalArgumentException("路径错误");
        } else {
            File file=new File(path);
            if(!file.exists()){
                file.createNewFile();
            }
            workbook.write(file);
            workbook.close();
        }
    }

    /**
     * 创建表单
     *
     * @param workbook  文档
     * @param sheetName 表单名
     * @return 表单
     */
    public static HSSFSheet createSheet(HSSFWorkbook workbook, String sheetName) {
        if (StringUtil.isBlank(sheetName)) {
            return workbook.createSheet();
        } else {
            return workbook.createSheet(sheetName);
        }
    }

    /**
     * 设置表头
     * @param sheet 表单
     * @param header 标题头
     */
    public static void initSheetHeader(HSSFSheet sheet,String ... header){
        HSSFRow row = sheet.createRow(0);
        for (int i = 0; i < header.length; i++) {
            HSSFCell cell = row.createCell(i);
            cell.setCellValue(header[i]);
        }
    }

}
