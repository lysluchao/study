package com.lc.bedc.model;


/**
 * 浦发理财大额存单查询
 *
 * @author luchao
 * @version v1.0
 * @date 2022/10/19 15:28
 */
public class SpdFinanceFG51Info  implements java.io.Serializable {
    private static final long serialVersionUID = 3279910927161454764L;
    /**
     * 产品期次号
     */
    private String produuctBatchNo;
    /**
     * 发行年度
     */
    private String publishYear;
    /**
     * 货币代号
     */
    private String currency;
    /**
     * 存期
     */
    private String depositTerm;
    /**
     * 状态
     */
    private String status;
    /**
     * 起始笔数
     */
    private String beginNumber;
    /**
     * 查询笔数
     */
    private String queryNumber;
    /**
     * 发行起始日期
     */
    private String pubBeginDate;
    /**
     * 发行终止日期
     */
    private String pubEndDate;

    public String getProduuctBatchNo() {
        return produuctBatchNo;
    }

    public void setProduuctBatchNo(String produuctBatchNo) {
        this.produuctBatchNo = produuctBatchNo;
    }

    public String getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(String publishYear) {
        this.publishYear = publishYear;
    }

    public String getDepositTerm() {
        return depositTerm;
    }

    public void setDepositTerm(String depositTerm) {
        this.depositTerm = depositTerm;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getBeginNumber() {
        return beginNumber;
    }

    public void setBeginNumber(String beginNumber) {
        this.beginNumber = beginNumber;
    }

    public String getQueryNumber() {
        return queryNumber;
    }

    public void setQueryNumber(String queryNumber) {
        this.queryNumber = queryNumber;
    }

    public String getPubBeginDate() {
        return pubBeginDate;
    }

    public void setPubBeginDate(String pubBeginDate) {
        this.pubBeginDate = pubBeginDate;
    }

    public String getPubEndDate() {
        return pubEndDate;
    }

    public void setPubEndDate(String pubEndDate) {
        this.pubEndDate = pubEndDate;
    }

    @Override
    public String toString() {
        return "SpdFinanceFG51Info{" +
                "produuctBatchNo='" + produuctBatchNo + '\'' +
                ", publishYear='" + publishYear + '\'' +
                ", currency='" + currency + '\'' +
                ", depositTerm='" + depositTerm + '\'' +
                ", status='" + status + '\'' +
                ", beginNumber='" + beginNumber + '\'' +
                ", queryNumber='" + queryNumber + '\'' +
                ", pubBeginDate='" + pubBeginDate + '\'' +
                ", pubEndDate='" + pubEndDate + '\'' +
                '}';
    }
}
