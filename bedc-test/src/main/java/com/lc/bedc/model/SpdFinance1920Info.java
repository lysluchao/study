package com.lc.bedc.model;



/**
 * 浦发理财对公交易账户签约管理
 *
 * @author luchao
 * @version v1.0
 * @date 2022/10/19 15:28
 */
public class SpdFinance1920Info  implements java.io.Serializable {

    private static final long serialVersionUID = -3392442254883885160L;
    /**
     * 操作标志
     */
    private String operateFlag;
    /**
     * 客户帐号
     */
    private String acctNo;
    /**
     * 备用标志
     */
    private String spareFlag;
    /**
     * 备用字段
     */
    private String note;
    /**
     * 备用字段2
     */
    private String reserve2;

    public String getOperateFlag() {
        return operateFlag;
    }

    public void setOperateFlag(String operateFlag) {
        this.operateFlag = operateFlag;
    }

    public String getAcctNo() {
        return acctNo;
    }

    public void setAcctNo(String acctNo) {
        this.acctNo = acctNo;
    }

    public String getSpareFlag() {
        return spareFlag;
    }

    public void setSpareFlag(String spareFlag) {
        this.spareFlag = spareFlag;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getReserve2() {
        return reserve2;
    }

    public void setReserve2(String reserve2) {
        this.reserve2 = reserve2;
    }

    @Override
    public String toString() {
        return "SpdFinance1920Info{" +
                "operateFlag='" + operateFlag + '\'' +
                ", acctNo='" + acctNo + '\'' +
                ", spareFlag='" + spareFlag + '\'' +
                ", note='" + note + '\'' +
                ", reserve2='" + reserve2 + '\'' +
                '}';
    }
}
