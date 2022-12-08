package com.lc.bedc.model;



/**
 * 浦发理财基本信息查询
 *
 * @author luchao
 * @version v1.0
 * @date 2022/10/19 15:28
 */
public class SpdFinance1903Info  implements java.io.Serializable {
    private static final long serialVersionUID = -1665165314476834932L;
    /**
     * 产品类别
     */
    private String productCategory;
    /**
     * 产品类型
     */
    private String productType;
    /**
     * 理财产品状态
     */
    private String productStatus;
    /**
     * 查询笔数
     */
    private String queryNumber;
    /**
     * 起始笔数
     */
    private String beginNumber;
    /**
     * 产品种类
     */
    private String productFlag;
    /**
     * 注册登记人代码
     */
    private String registerCode;
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

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(String productStatus) {
        this.productStatus = productStatus;
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

    public String getProductFlag() {
        return productFlag;
    }

    public void setProductFlag(String productFlag) {
        this.productFlag = productFlag;
    }

    public String getRegisterCode() {
        return registerCode;
    }

    public void setRegisterCode(String registerCode) {
        this.registerCode = registerCode;
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
        return "SpdFinance1903Info{" +
                "productCategory='" + productCategory + '\'' +
                ", productType='" + productType + '\'' +
                ", productStatus='" + productStatus + '\'' +
                ", queryNumber='" + queryNumber + '\'' +
                ", beginNumber='" + beginNumber + '\'' +
                ", productFlag='" + productFlag + '\'' +
                ", registerCode='" + registerCode + '\'' +
                ", reserve1='" + reserve1 + '\'' +
                ", reserve2='" + reserve2 + '\'' +
                ", reserve3='" + reserve3 + '\'' +
                '}';
    }
}
