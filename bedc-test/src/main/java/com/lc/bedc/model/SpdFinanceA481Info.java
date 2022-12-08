package com.lc.bedc.model;



/**
 * 浦发理财定期/通知存款账户明细查询
 *
 * @author luchao
 * @version v1.0
 * @date 2022/10/19 15:28
 */
public class SpdFinanceA481Info  implements java.io.Serializable {

    private static final long serialVersionUID = -873881507942297066L;
    /**
     * 账号
     */
    private String acctNo;

    public String getAcctNo() {
        return acctNo;
    }

    public void setAcctNo(String acctNo) {
        this.acctNo = acctNo;
    }

    @Override
    public String toString() {
        return "SpdFinanceA481Info{" +
                "acctNo='" + acctNo + '\'' +
                '}';
    }
}
