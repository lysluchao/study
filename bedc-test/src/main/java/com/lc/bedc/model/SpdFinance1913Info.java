package com.lc.bedc.model;



/**
 * 浦发理财产品委托明细查询
 *
 * @author luchao
 * @version v1.0
 * @date 2022/10/19 15:28
 */
public class SpdFinance1913Info  implements java.io.Serializable {


    private static final long serialVersionUID = 6339051629197949079L;
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

    @Override
    public String toString() {
        return "SpdFinance1913Info{" +
                "acctNo='" + acctNo + '\'' +
                ", queryNumber='" + queryNumber + '\'' +
                ", beginNumber='" + beginNumber + '\'' +
                ", reserve='" + reserve + '\'' +
                ", reserveCharacter='" + reserveCharacter + '\'' +
                ", reserveMark='" + reserveMark + '\'' +
                '}';
    }
}
