package com.lc.util;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.function.Supplier;

/**
 * Excel工具类，POI实现
 *
 * @Auther: LuChao
 * @Date: 2022/8/11 11:12
 * @Version: v1.0
 */
public class ExcelUtil {

    /**
     * 创建excel文档
     *
     * @param path     存储路径
     * @param workbook excel文档
     * @throws IOException 路径无效时
     */
    public static void createExcelBySuppliedData(HSSFWorkbook workbook, String path) throws IOException {

        if (StringUtil.isBlank(path)) {
            throw new IllegalArgumentException("路径错误");
        } else {
            File file = new File(path);
            if (!file.exists()) {
                boolean createSuccess = false;
                for (int i = 0; i < 3 && !createSuccess; i++) {
                    createSuccess = file.createNewFile();
                }
            }
            workbook.write(file);
            workbook.close();
        }
    }

    /**
     * 创建excel文档
     *
     * @param suppliedData excel中的数据
     * @param path         存储路径
     * @throws IOException 路径无效时
     */
    public static <T extends Iterable<?>> void createExcelBySuppliedData(Supplier<T> suppliedData, LinkedHashMap<String, String> sortedCol, String path) throws IOException {
        HSSFWorkbook workbook = createWorkbookBySuppliedData(suppliedData, sortedCol);
        createExcelBySuppliedData(workbook, path);
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
     * 根据提供的数据导出WorkBook
     *
     * @param suppliedData 提供的数据
     * @param sheetNames   sheet名称
     * @param sheetSize    sheet大小
     * @param <T>          单条数据类型
     * @return 创建的workbook
     */
    public static <T extends Iterable<?>> HSSFWorkbook createWorkbookBySuppliedData(Supplier<T> suppliedData, String[] sheetNames, int sheetSize, LinkedHashMap<String, String> sortedCol) {


        HSSFWorkbook workbook = new HSSFWorkbook();

        T t = suppliedData.get();
        Iterator<?> iterator = t.iterator();
        for (String sheetName : sheetNames) {
            try {
                createSheet(sheetSize, workbook, iterator, sheetName, sortedCol);
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        return workbook;
    }

    public static void createSheet(int sheetSize, HSSFWorkbook workbook, Iterator<?> iterator, String sheetName, LinkedHashMap<String, String> sortedCol) throws IllegalAccessException, InvocationTargetException {
        HSSFSheet sheet = createSheet(workbook, sheetName);

        createHeader(sheet, sortedCol);

        HashMap<String, Integer> colIndexMap = initCilIndexMap(sortedCol);

        writeSheet(sheetSize, iterator, sheet, colIndexMap);
    }

    /**
     * 写入sheet的值
     *
     * @param sheetSize   sheet大小
     * @param iterator    数据迭代器
     * @param sheet       待写入的sheet
     * @param colIndexMap 字段写入顺序
     */
    private static void writeSheet(int sheetSize, Iterator<?> iterator, HSSFSheet sheet, HashMap<String, Integer> colIndexMap) {
        for (int i = 1; i < sheetSize && iterator.hasNext(); i++) {
            Object data = iterator.next();
            Class<?> clazz = data.getClass();
            Method[] methods = clazz.getMethods();

            HSSFRow row = sheet.createRow(i);

            for (Method method : methods) {
                String methodName = method.getName();
                if (methodName.startsWith("get") && method.getReturnType() == String.class && colIndexMap.get(methodName.substring(3)) != null) {
                    String val = null;
                    try {
                        val = (String) method.invoke(data);
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        e.printStackTrace();
                    }
                    HSSFCell cell = row.createCell(colIndexMap.get(methodName.substring(3)));
                    cell.setCellValue(val);
                }
            }
        }
    }

    /**
     * 获取字段放置的顺序关系
     *
     * @param sortedCol field和中文名的映射
     * @return 顺序关系
     */
    private static HashMap<String, Integer> initCilIndexMap(LinkedHashMap<String, String> sortedCol) {
        Object[] objects = sortedCol.keySet().toArray();
        HashMap<String, Integer> colIndexMap = new HashMap<>();
        for (int i = 0; i < objects.length; i++) {
            colIndexMap.put((String) objects[i], i);
        }
        return colIndexMap;
    }

    /**
     * 创建表头
     *
     * @param sheet     数据表
     * @param sortedCol 表头行
     */
    public static void createHeader(HSSFSheet sheet, LinkedHashMap<String, String> sortedCol) {
        HSSFRow row = sheet.createRow(0);

        Collection<String> values = sortedCol.values();
        Object[] valuesArray = values.toArray();
        for (int i = 0; i < valuesArray.length; i++) {
            HSSFCell cell = row.createCell(i);
            cell.setCellValue((String) valuesArray[i]);
        }
    }


    /**
     * 根据提供的数据导出WorkBook
     *
     * @param suppliedData 提供的数据
     * @param <T>          单条数据类型
     * @return 创建的workbook
     */
    public static <T extends Iterable<?>> HSSFWorkbook createWorkbookBySuppliedData(Supplier<T> suppliedData, LinkedHashMap<String, String> sortedCol) {
        return createWorkbookBySuppliedData(suppliedData, new String[]{"default"}, Integer.MAX_VALUE, sortedCol);
    }

}
