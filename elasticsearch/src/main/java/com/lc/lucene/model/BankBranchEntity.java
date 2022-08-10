package com.lc.lucene.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class BankBranchEntity {
    private String ecflag; //跨行电联标志

    private String branchcode;  //支付系统行号

    private String eisbnkcode; //电子联行行号

    private String eissitecode; //EIS小站号

    private String represerved3; //响应备用字段3

    private String represerved4;//响应备用字段4

    private String bankcodeunit;  //行别代码


    private String branchname;  //行名

    private String updatedate;  //变更日期

    private String bankcode;


}
