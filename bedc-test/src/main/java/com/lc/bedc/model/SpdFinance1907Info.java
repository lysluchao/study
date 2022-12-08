package com.lc.bedc.model;



/**
 * 浦发理财产品撤单(可操作所有渠道)
 *
 * @author luchao
 * @version v1.0
 * @date 2022/10/19 15:28
 */
public class SpdFinance1907Info  implements java.io.Serializable {


    private static final long serialVersionUID = -937756632817843514L;
    /**
     * 客户帐号
     */
    private String acctNo;
    /**
     * 原交易流水号
     */
    private String originalSerialNo;
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

    public String getOriginalSerialNo() {
        return originalSerialNo;
    }

    public void setOriginalSerialNo(String originalSerialNo) {
        this.originalSerialNo = originalSerialNo;
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
        return "SpdFinance1907Info{" +
                "acctNo='" + acctNo + '\'' +
                ", originalSerialNo='" + originalSerialNo + '\'' +
                ", reserve1='" + reserve1 + '\'' +
                ", reserve2='" + reserve2 + '\'' +
                ", reserve3='" + reserve3 + '\'' +
                '}';
    }
}
