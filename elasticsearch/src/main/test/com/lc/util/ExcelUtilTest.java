package com.lc.util;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class ExcelUtilTest {

    @Test
    public void createBook() throws IOException {
        HSSFWorkbook workbook = new HSSFWorkbook();
        ExcelUtil.createSheet(workbook,"a");
        ExcelUtil.createExcel(workbook, "D://a.xls");
    }

    @Test
    public void createSheet() {
    }

    @Test
    public void initSheetHeader() {
    }
}