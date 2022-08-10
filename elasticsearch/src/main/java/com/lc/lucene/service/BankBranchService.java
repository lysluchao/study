package com.lc.lucene.service;

import com.lc.lucene.model.BankBranchEntity;
import org.apache.lucene.queryparser.classic.ParseException;

import java.io.IOException;

public interface BankBranchService {

    void createIndex() throws IOException;

    BankBranchEntity query(String bankName) throws IOException, ParseException;
}
