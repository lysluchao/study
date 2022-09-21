package com.lc.lucene.service;

import com.lc.common.entities.BankBranchEntity;
import org.apache.lucene.queryparser.classic.ParseException;

import java.io.IOException;
import java.util.List;

public interface BankBranchService {

    void createIndex() throws IOException;

    BankBranchEntity query(String bankName) throws IOException, ParseException;

    List<BankBranchEntity> expBranches();
}
