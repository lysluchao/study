package com.lc.util;

import com.lc.common.entities.BankBranchEntity;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class ExcelUtilTest {

    @org.junit.Test
    public void createExcelBySuppliedData() {
    }

    @org.junit.Test
    public void testCreateExcelBySuppliedData() {
    }

    @org.junit.Test
    public void createSheet() {
    }

    @org.junit.Test
    public void initSheetHeader() {
    }

    @org.junit.Test
    public void createWorkbookBySuppliedData() {
    }

    @org.junit.Test
    public void testCreateSheet() {
    }

    @org.junit.Test
    public void testCreateWorkbookBySuppliedData() {
    }

    @Test
    public void createBook() throws IOException {
        HSSFWorkbook workbook = new HSSFWorkbook();
        ExcelUtil.createSheet(workbook, "a");
        ExcelUtil.createExcel(workbook, "D://a.xls");
    }

    @Test
    public void createExcel() throws IOException {

        LinkedHashMap<String, String> col = new LinkedHashMap<>();
        col.put("Bankcode", "内部行号");
        col.put("Branchcode", "联行号");
        col.put("Bankcodeunit", "联行号单位");
        col.put("Eisbnkcode", "电子联行号");
        ExcelUtil.createExcelBySuppliedData(() -> {
            List<BankBranchEntity> bankBranchEntities = new ArrayList<>();
            BankBranchEntity bankBranchEntity = new BankBranchEntity();
            bankBranchEntity.setBankcode("1111");
            bankBranchEntity.setBranchcode("2222");
            bankBranchEntity.setBankcodeunit("3333");
            bankBranchEntity.setEisbnkcode("4444");
            for (int i = 0; i < 1001; i++) {
                bankBranchEntities.add(bankBranchEntity);
            }
            return bankBranchEntities;
        }, col, "D://a" + System.currentTimeMillis() + ".xls");
    }

}