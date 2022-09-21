package com.lc.lucene.dao;

import com.lc.common.entities.BankBranchEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Auther: LuChao
 * @Date: 2022/8/9 16:13
 * @Version: v1.0
 */
@Mapper
public interface BankInfoDao {

    int branchCount();

    List<BankBranchEntity> loadBankBranchs(Map<String, String> param);

    List<BankBranchEntity> expBranches();
}
