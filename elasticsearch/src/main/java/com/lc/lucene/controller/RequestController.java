package com.lc.lucene.controller;

import com.lc.lucene.service.BankBranchService;
import org.apache.lucene.queryparser.classic.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * @Description:
 * @Auther: LuChao
 * @Date: 2022/8/9 16:26
 * @Version: v1.0
 */
@Controller
public class RequestController {

    @Resource
    private BankBranchService bankBranchService;

    @RequestMapping("/createIndex")
    public void createIndex(){
        try {
            bankBranchService.createIndex();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/query/{bankName}")
    public void query(@PathVariable String bankName) throws IOException, ParseException {
        bankBranchService.query(bankName);
    }

}
