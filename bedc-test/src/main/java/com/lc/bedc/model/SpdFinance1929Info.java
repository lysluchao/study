package com.lc.bedc.model;



/**
 * 浦发理财产品固定持有期持仓明细查询
 *
 * @author luchao
 * @version v1.0
 * @date 2022/10/19 15:28
 */
public class SpdFinance1929Info  implements java.io.Serializable {
    private static final long serialVersionUID = -8522112831236068195L;
    /**
     * 客户账号
     */
    private String acctNo;
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
     * 备用标记
     */
    private String reserveMark;
    /**
     * 备用字段
     */
    private String reserve1;
    /**
     * 备用字符
     */
    private String reserveCharacter;
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

    public String getReserve1() {
        return reserve1;
    }

    public void setReserve1(String reserve1) {
        this.reserve1 = reserve1;
    }

    public String getReserveCharacter() {
        return reserveCharacter;
    }

    public void setReserveCharacter(String reserveCharacter) {
        this.reserveCharacter = reserveCharacter;
    }

    public String getProductFlag() {
        return productFlag;
    }

    public void setProductFlag(String productFlag) {
        this.productFlag = productFlag;
    }

    @Override
    public String toString() {
        return "SpdFinance1929Info{" +
                "acctNo='" + acctNo + '\'' +
                ", productCode='" + productCode + '\'' +
                ", queryNumber='" + queryNumber + '\'' +
                ", beginNumber='" + beginNumber + '\'' +
                ", reserveMark='" + reserveMark + '\'' +
                ", reserve1='" + reserve1 + '\'' +
                ", reserveCharacter='" + reserveCharacter + '\'' +
                ", productFlag='" + productFlag + '\'' +
                '}';
    }
}
