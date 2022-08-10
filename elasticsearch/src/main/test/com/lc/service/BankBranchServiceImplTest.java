package com.lc.service;

import com.lc.lucene.service.BankBranchServiceImpl;
import org.apache.lucene.queryparser.classic.ParseException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BankBranchServiceImplTest {
    @Resource
    BankBranchServiceImpl bankBranchService;

    @Before
    public void setUp() throws Exception {
        //FileUtil.deleteFile(new File("/lucene/"));
    }

    @Test
    public void createIndex() throws IOException {
        bankBranchService.createIndex();
    }

    @Test
    public void query() throws IOException, ParseException {
        bankBranchService.query("中国农业银行股份有限公司辽中刘二堡分理处12312312");
        bankBranchService.query("辽中刘堡分理处3");
        bankBranchService.query("中国农业银行股份有限公司沈阳九路支行");
        bankBranchService.query("沈阳九路支行");
        bankBranchService.query("江苏商业银行龙河");
    }
}