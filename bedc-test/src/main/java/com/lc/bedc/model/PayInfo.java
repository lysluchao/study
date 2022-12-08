package com.lc.bedc.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * 支付
 *
 * @author luchao
 * @version v1.0
 * @date 2022/11/18 15:42
 */
@Getter
@Setter
@ToString
public class PayInfo extends TaskInfo implements Serializable {
    private static final long serialVersionUID = 8428276935204440821L;
    private String busiSeqNo;

    private Long payAccId;

    private String payBankCode;

    private String oppBankCode;

    private String oppBranchCode;

    private String oppBranchName;

    private String oppAcctNo;

    private String oppAcctName;

    private int oppClass;  // 0:对公 , 1：对私

    private int bankFlag;  // 0:同行 , 1：跨行

    private int areaFlag;  // 0:同城 , 1：异地

    private String amount;

    private int urgFlag;   // 0:普通 , 1：加急

    private String purpose;

    private String summary;

    private String postscript;

    private String oppprovince; //收款人省份信息

    private String oppcity;         //收款人的所在市信息

    private String kjseqno; //会计流水号

    private String selfpay;


}
