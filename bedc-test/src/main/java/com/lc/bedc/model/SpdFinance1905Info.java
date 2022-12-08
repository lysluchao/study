package com.lc.bedc.model;



/**
 * 浦发理财产品赎回
 *
 * @author luchao
 * @version v1.0
 * @date 2022/10/19 15:28
 */
public class SpdFinance1905Info  implements java.io.Serializable {

    private static final long serialVersionUID = 7287833802830273880L;
    /**
     * 理财产品编号
     */
    private String productCode;
    /**
     * 客户帐号
     */
    private String acctNo;
    /**
     * 赎回份额
     */
    private String transVol;
    /**
     * 净值上限
     */
    private String netWorthUpperLimit;
    /**
     * 净值下限
     */
    private String netWorthLowerLimit;
    /**
     * 理财经理代码
     */
    private String financialManaCode;
    /**
     * 备用标记
     */
    private String reserveMark;
    /**
     * 备用字符
     */
    private String reserveCharacter;
    /**
     * 备用字段
     */
    private String reserve;

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getAcctNo() {
        return acctNo;
    }

    public void setAcctNo(String acctNo) {
        this.acctNo = acctNo;
    }

    public String getTransVol() {
        return transVol;
    }

    public void setTransVol(String transVol) {
        this.transVol = transVol;
    }

    public String getNetWorthUpperLimit() {
        return netWorthUpperLimit;
    }

    public void setNetWorthUpperLimit(String netWorthUpperLimit) {
        this.netWorthUpperLimit = netWorthUpperLimit;
    }

    public String getNetWorthLowerLimit() {
        return netWorthLowerLimit;
    }

    public void setNetWorthLowerLimit(String netWorthLowerLimit) {
        this.netWorthLowerLimit = netWorthLowerLimit;
    }

    public String getFinancialManaCode() {
        return financialManaCode;
    }

    public void setFinancialManaCode(String financialManaCode) {
        this.financialManaCode = financialManaCode;
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

    public String getReserve() {
        return reserve;
    }

    public void setReserve(String reserve) {
        this.reserve = reserve;
    }

    @Override
    public String toString() {
        return "SpdFinance1905Info{" +
                "productCode='" + productCode + '\'' +
                ", acctNo='" + acctNo + '\'' +
                ", transVol='" + transVol + '\'' +
                ", netWorthUpperLimit='" + netWorthUpperLimit + '\'' +
                ", netWorthLowerLimit='" + netWorthLowerLimit + '\'' +
                ", financialManaCode='" + financialManaCode + '\'' +
                ", reserveMark='" + reserveMark + '\'' +
                ", reserveCharacter='" + reserveCharacter + '\'' +
                ", reserve='" + reserve + '\'' +
                '}';
    }
}
