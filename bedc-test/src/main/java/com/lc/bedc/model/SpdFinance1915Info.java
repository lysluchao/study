package com.lc.bedc.model;



/**
 * 浦发理财产品分红查询
 *
 * @author luchao
 * @version v1.0
 * @date 2022/10/19 15:28
 */
public class SpdFinance1915Info  implements java.io.Serializable {
    private static final long serialVersionUID = 1363280752730574314L;
    /**
     * 客户账号
     */
    private String acctNo;
    /**
     * 理财产品编号
     */
    private String productCode;
    /**
     * 起始日期
     */
    private String beginDate;
    /**
     * 终止日期
     */
    private String endDate;
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
    /**
     * 产品种类
     */
    private String productFlag;

    public String getAcctNo() {
        return acctNo;
    }

    public void setAcctNo(String acctNo) {
        this.acctNo = acctNo;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

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

    public String getProductFlag() {
        return productFlag;
    }

    public void setProductFlag(String productFlag) {
        this.productFlag = productFlag;
    }

    @Override
    public String toString() {
        return "SpdFinance1915Info{" +
                "acctNo='" + acctNo + '\'' +
                ", productCode='" + productCode + '\'' +
                ", beginDate='" + beginDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", queryNumber='" + queryNumber + '\'' +
                ", beginNumber='" + beginNumber + '\'' +
                ", reserve='" + reserve + '\'' +
                ", reserveCharacter='" + reserveCharacter + '\'' +
                ", reserveMark='" + reserveMark + '\'' +
                ", productFlag='" + productFlag + '\'' +
                '}';
    }
}
