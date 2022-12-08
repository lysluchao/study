package com.lc.bedc.model;



/**
 * 浦发理财产品可售额度查询
 *
 * @author luchao
 * @version v1.0
 * @date 2022/10/19 15:28
 */
public class SpdFinance1928Info  implements java.io.Serializable {

    private static final long serialVersionUID = 8459912365169554719L;
    /**
     * 客户账号
     */
    private String acctNo;
    /**
     * 理财产品编号
     */
    private String productCode;
    /**
     * 理财经理所属机构号
     */
    private String financialManaOrganNum;
    /**
     * 备用字段1
     */
    private String reserve1;
    /**
     * 备用字段2
     */
    private String reserve2;
    /**
     * 备用字段3
     */
    private String reserve3;

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

    public String getFinancialManaOrganNum() {
        return financialManaOrganNum;
    }

    public void setFinancialManaOrganNum(String financialManaOrganNum) {
        this.financialManaOrganNum = financialManaOrganNum;
    }

    public String getReserve1() {
        return reserve1;
    }

    public void setReserve1(String reserve1) {
        this.reserve1 = reserve1;
    }

    public String getReserve2() {
        return reserve2;
    }

    public void setReserve2(String reserve2) {
        this.reserve2 = reserve2;
    }

    public String getReserve3() {
        return reserve3;
    }

    public void setReserve3(String reserve3) {
        this.reserve3 = reserve3;
    }

    @Override
    public String toString() {
        return "SpdFinance1928Info{" +
                "acctNo='" + acctNo + '\'' +
                ", productCode='" + productCode + '\'' +
                ", financialManaOrganNum='" + financialManaOrganNum + '\'' +
                ", reserve1='" + reserve1 + '\'' +
                ", reserve2='" + reserve2 + '\'' +
                ", reserve3='" + reserve3 + '\'' +
                '}';
    }
}
