package com.lc.bedc.model;



/**
 * 浦发理财大额存单认购
 *
 * @author luchao
 * @version v1.0
 * @date 2022/10/19 15:28
 */
public class SpdFinanceFG52Info  implements java.io.Serializable {

    private static final long serialVersionUID = 5718363193580179012L;
    /**
     * 资金来源
     */
    private String amountType;
    /**
     * 帐号
     */
    private String acctNo;
    /**
     * 产品期次号
     */
    private String produuctBatchNo;
    /**
     * 认购金额
     */
    private String amount;
    /**
     * 权益码
     */
    private String equityCode;

    public String getAmountType() {
        return amountType;
    }

    public void setAmountType(String amountType) {
        this.amountType = amountType;
    }

    public String getAcctNo() {
        return acctNo;
    }

    public void setAcctNo(String acctNo) {
        this.acctNo = acctNo;
    }

    public String getProduuctBatchNo() {
        return produuctBatchNo;
    }

    public void setProduuctBatchNo(String produuctBatchNo) {
        this.produuctBatchNo = produuctBatchNo;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getEquityCode() {
        return equityCode;
    }

    public void setEquityCode(String equityCode) {
        this.equityCode = equityCode;
    }

    @Override
    public String toString() {
        return "SpdFinanceFG52Info{" +
                "amountType='" + amountType + '\'' +
                ", acctNo='" + acctNo + '\'' +
                ", produuctBatchNo='" + produuctBatchNo + '\'' +
                ", amount='" + amount + '\'' +
                ", equityCode='" + equityCode + '\'' +
                '}';
    }
}
