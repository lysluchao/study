package com.lc.bedc.model;



/**
 * 浦发理财产品申购
 *
 * @author luchao
 * @version v1.0
 * @date 2022/10/19 16:18
 */
public class SpdFinance1904Info  implements java.io.Serializable {
    private static final long serialVersionUID = -2260627076722135219L;
    /**
     * 客户帐号
     */
    private String acctNo;
    /**
     * 理财产品编号
     */
    private String productCode;
    /**
     * 申购金额
     */
    private String applyAmnt;
    /**
     * 理财经理代码
     */
    private String managerID;
    /**
     * 备用标记1
     */
    private String reserveMark1;
    /**
     * 备用标记2
     */
    private String reserveMark2;
    /**
     * 备用字符2
     */
    private String reserveCharacter2;
    /**
     * 理财经理所属机构号
     */
    private String financialManaOrganNum;
    /**
     * 理财权益码（电子资格券）
     */
    private String elecTicket;
    /**
     * 申购预约编号
     */
    private String applBookNo;
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
    /**
     * 销售人工号
     */
    private String salesmanNo;
    /**
     * 推荐人信息
     */
    private String recommenderInfo;


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

    public String getApplyAmnt() {
        return applyAmnt;
    }

    public void setApplyAmnt(String applyAmnt) {
        this.applyAmnt = applyAmnt;
    }

    public String getManagerID() {
        return managerID;
    }

    public void setManagerID(String managerID) {
        this.managerID = managerID;
    }

    public String getReserveMark1() {
        return reserveMark1;
    }

    public void setReserveMark1(String reserveMark1) {
        this.reserveMark1 = reserveMark1;
    }

    public String getReserveMark2() {
        return reserveMark2;
    }

    public void setReserveMark2(String reserveMark2) {
        this.reserveMark2 = reserveMark2;
    }

    public String getReserveCharacter2() {
        return reserveCharacter2;
    }

    public void setReserveCharacter2(String reserveCharacter2) {
        this.reserveCharacter2 = reserveCharacter2;
    }

    public String getFinancialManaOrganNum() {
        return financialManaOrganNum;
    }

    public void setFinancialManaOrganNum(String financialManaOrganNum) {
        this.financialManaOrganNum = financialManaOrganNum;
    }

    public String getElecTicket() {
        return elecTicket;
    }

    public void setElecTicket(String elecTicket) {
        this.elecTicket = elecTicket;
    }

    public String getApplBookNo() {
        return applBookNo;
    }

    public void setApplBookNo(String applBookNo) {
        this.applBookNo = applBookNo;
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

    public String getSalesmanNo() {
        return salesmanNo;
    }

    public void setSalesmanNo(String salesmanNo) {
        this.salesmanNo = salesmanNo;
    }

    public String getRecommenderInfo() {
        return recommenderInfo;
    }

    public void setRecommenderInfo(String recommenderInfo) {
        this.recommenderInfo = recommenderInfo;
    }

    @Override
    public String toString() {
        return "SpdFinance1904Info{" +
                "acctNo='" + acctNo + '\'' +
                ", productCode='" + productCode + '\'' +
                ", applyAmnt='" + applyAmnt + '\'' +
                ", managerID='" + managerID + '\'' +
                ", reserveMark1='" + reserveMark1 + '\'' +
                ", reserveMark2='" + reserveMark2 + '\'' +
                ", reserveCharacter2='" + reserveCharacter2 + '\'' +
                ", financialManaOrganNum='" + financialManaOrganNum + '\'' +
                ", elecTicket='" + elecTicket + '\'' +
                ", applBookNo='" + applBookNo + '\'' +
                ", reserve1='" + reserve1 + '\'' +
                ", reserve2='" + reserve2 + '\'' +
                ", reserve3='" + reserve3 + '\'' +
                ", salesmanNo='" + salesmanNo + '\'' +
                ", recommenderInfo='" + recommenderInfo + '\'' +
                '}';
    }
}
