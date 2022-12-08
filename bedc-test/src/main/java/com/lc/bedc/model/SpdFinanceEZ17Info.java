package com.lc.bedc.model;



/**
 * 浦发理财产品详情查询
 *
 * @author luchao
 * @version v1.0
 * @date 2022/10/20 16:12
 */
public class SpdFinanceEZ17Info  implements java.io.Serializable {
    private static final long serialVersionUID = 3568733309054910335L;
    /**
     * 理财产品编号
     */
    private String productCode;
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

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
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
        return "SpdFinanceEZ17Info{" +
                "productCode='" + productCode + '\'' +
                ", reserve1='" + reserve1 + '\'' +
                ", reserve2='" + reserve2 + '\'' +
                ", reserve3='" + reserve3 + '\'' +
                '}';
    }
}
