package com.lc.service;

import com.lc.lucene.dao.BankInfoDao;
import com.lc.lucene.model.BankBranchEntity;
import com.lc.lucene.service.BankBranchServiceImpl;
import com.lc.util.ExcelUtil;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BankBranchServiceImplTest {
    @Resource
    BankBranchServiceImpl bankBranchService;
    @Resource
    BankInfoDao bankInfoDao;
    long before;
    int eqCount = 0;

    @Before
    public void setUp() throws Exception {
        before = System.currentTimeMillis();
    }

    @After
    public void after() {
        System.out.println("耗时(ms)：" + (System.currentTimeMillis() - before));
    }

    @Test
    public void createIndex() throws IOException {
        bankBranchService.createIndex();
    }

    @Test
    public void query() throws IOException, ParseException {
        System.out.println(bankBranchService.query("人民银行赵县"));
        System.out.println(bankBranchService.query("人民银行济南营业管理部会计国库"));
        /*
        工商银行有限四子王旗
工商银行有限鄂尔多斯西街
工商银行有限乌拉特前旗
工商银行有限乌拉特中旗

         */
        System.out.println(bankBranchService.query("工商银行四子王旗"));
        System.out.println(bankBranchService.query("工商银行乌拉特中旗"));
        System.out.println(bankBranchService.query("工商银行乌拉特前旗"));
    }

    @Test
    public void multiQuery() throws IOException {
        HSSFWorkbook book = new HSSFWorkbook();
        int total = bankInfoDao.branchCount(), count = 0, pageSize = 10000;
        while (count < total / 100) {
            Map<String, String> map = new HashMap<>(2);
            map.put("from", String.valueOf(count));
            map.put("to", String.valueOf(count + pageSize));
            List<BankBranchEntity> bankBranchEntities = bankInfoDao.loadBankBranchs(map);
            writeSheet(bankBranchEntities, book, count);
            count += bankBranchEntities.size();
        }

        ExcelUtil.createExcel(book, "D://a" + (double) this.eqCount / 10000 + ".xls");
    }

    private void writeSheet(List<BankBranchEntity> bankBranchEntities, HSSFWorkbook book, int count) {
        HSSFSheet sheet = ExcelUtil.createSheet(book, count + "-" + (count + 10000));

        ExcelUtil.initSheetHeader(sheet, "数据库中的行名", "查询参数", "lucene匹配的对象", "是否命中");
        for (int i = 1; i <= bankBranchEntities.size(); i++) {
            HSSFRow row = sheet.createRow(i);
            HSSFCell cell0 = row.createCell(0);
            String branchname = bankBranchEntities.get(i - 1).getBranchname();
            cell0.setCellValue(branchname);
            String queryBankName = mock(branchname);
            HSSFCell cell1 = row.createCell(1);
            cell1.setCellValue(queryBankName);

            HSSFCell cell2 = row.createCell(2);

            try {
                BankBranchEntity result = bankBranchService.query(queryBankName);
                cell2.setCellValue(result.toString());

                HSSFCell cell3 = row.createCell(3);
                cell3.setCellValue(branchname.equals(result.getBranchname()));
                if (branchname.equals(result.getBranchname())) {
                    this.eqCount++;
                }
            } catch (IOException | ParseException e) {
                e.printStackTrace();
                cell2.setCellValue("查询错误");
            }

        }
    }

    private static String mock(String branchname) {
        List<String> replaceItems = new ArrayList<>();
        replaceItems.add("分行");
        replaceItems.add("支行");
        replaceItems.add("总行");

        replaceItems.add("营业部");
        replaceItems.add("分理处");
        replaceItems.add("股份有限公司");
        replaceItems.add("有限公司");
        replaceItems.add("合作社");
//		replaceItems.add("农商行");
//		replaceItems.add("城商行");

        replaceItems.add("储蓄所");
        replaceItems.add("清算中心");
        replaceItems.add("省");
        replaceItems.add("市");

        replaceItems.add("自治州");
        replaceItems.add("自治区");
        replaceItems.add("特别行政区");

        for (String item : replaceItems) {
            branchname = branchname.replaceAll(item, "");
        }

        return branchname;
    }


}