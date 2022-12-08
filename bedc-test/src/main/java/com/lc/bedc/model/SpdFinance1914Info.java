package com.lc.bedc.model;



/**
 * 浦发理财产品成交查询
 *
 * @author luchao
 * @version v1.0
 * @date 2022/10/19 15:28
 */
public class SpdFinance1914Info  implements java.io.Serializable {

    private static final long serialVersionUID = -729884897259867858L;
    /**
     * 客户账号
     */
    private String acctNo;
    /**
     * 起始日期
     */
    private String beginDate;
    /**
     * 终止日期
     */
    private String endDate;
    /**
     * 理财产品编号
     */
    private String productCode;
    /**
     * 查询笔数
     */
    private String queryNumber;
    /**
     * 起始笔数
     */
    private String beginNumber;
    /**
     * 备用字段
     */
    private String reserve;
    /**
     * 备用字符
     */
    private String reserveCharacter;
    /**
     * 备用标记
     */
    private String reserveMark;

    public String getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(String beginDate) {
        this.beginDate = beginDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getQueryNumber() {
        return queryNumber;
    }

    public void setQueryNumber(String queryNumber) {
        this.queryNumber = queryNumber;
    }

    public String getBeginNumber() {
        return beginNumber;
    }

    public void setBeginNumber(String beginNumber) {
        this.beginNumber = beginNumber;
    }

    public String getReserve() {
        return reserve;
    }

    public void setReserve(String reserve) {
        this.reserve = reserve;
    }

    public String getReserveCharacter() {
        return reserveCharacter;
    }

    public void setReserveCharacter(String reserveCharacter) {
        this.reserveCharacter = reserveCharacter;
    }

    public String getReserveMark() {
        return reserveMark;
    }

    public void setReserveMark(String reserveMark) {
        this.reserveMark = reserveMark;
    }

    public String getAcctNo() {
        return acctNo;
    }

    public void setAcctNo(String acctNo) {
        this.acctNo = acctNo;
    }

    @Override
    public String toString() {
        return "SpdFinance1914Info{" +
                "acctNo='" + acctNo + '\'' +
                ", beginDate='" + beginDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", productCode='" + productCode + '\'' +
                ", queryNumber='" + queryNumber + '\'' +
                ", beginNumber='" + beginNumber + '\'' +
                ", reserve='" + reserve + '\'' +
                ", reserveCharacter='" + reserveCharacter + '\'' +
                ", reserveMark='" + reserveMark + '\'' +
                '}';
    }
}
