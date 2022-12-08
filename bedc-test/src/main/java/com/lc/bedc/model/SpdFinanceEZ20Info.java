package com.lc.bedc.model;



/**
 * 浦发理财产品持仓查询
 *
 * @author luchao
 * @version v1.0
 * @date 2022/10/19 15:28
 */
public class SpdFinanceEZ20Info  implements java.io.Serializable {
    private static final long serialVersionUID = -4746474108532321356L;
    /**
     * 客户账号
     */
    private String acctNo;
    /**
     * 查询笔数
     */
    private String queryNumber;
    /**
     * 起始笔数
     */
    private String beginNumber;
    /**
     * 备用标记1
     */
    private String reserveMark;
    /**
     * 备用字符2
     */
    private String reserveCharacter;
    /**
     * 理财产品编号
     */
    private String productCode;
    /**
     * 备用字段
     */
    private String reserve;
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

    public String getReserveMark() {
        return reserveMark;
    }

    public void setReserveMark(String reserveMark) {
        this.reserveMark = reserveMark;
    }

    public String getReserveCharacter() {
        return reserveCharacter;
    }

    public void setReserveCharacter(String reserveCharacter) {
        this.reserveCharacter = reserveCharacter;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getReserve() {
        return reserve;
    }

    public void setReserve(String reserve) {
        this.reserve = reserve;
    }

    public String getProductFlag() {
        return productFlag;
    }

    public void setProductFlag(String productFlag) {
        this.productFlag = productFlag;
    }

    @Override
    public String toString() {
        return "SpdFinanceEZ20Info{" +
                "acctNo='" + acctNo + '\'' +
                ", queryNumber='" + queryNumber + '\'' +
                ", beginNumber='" + beginNumber + '\'' +
                ", reserveMark='" + reserveMark + '\'' +
                ", reserveCharacter='" + reserveCharacter + '\'' +
                ", productCode='" + productCode + '\'' +
                ", reserve='" + reserve + '\'' +
                ", productFlag='" + productFlag + '\'' +
                '}';
    }
}
