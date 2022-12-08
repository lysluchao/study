package com.lc.bedc.model;



/**
 * 浦发定期存款查询
 *
 * @author luchao
 * @version v1.0
 * @date 2022/10/19 15:28
 */
public class SpdFinanceFT20Info  implements java.io.Serializable {
    private static final long serialVersionUID = -6372690627643191460L;
    /**
     * 签约客户号
     */
    private String transMasterID;
    /**
     * 起始笔数
     */
    private String beginNumber;
    /**
     * 查询笔数
     */
    private String queryNumber;

    public String getTransMasterID() {
        return transMasterID;
    }

    public void setTransMasterID(String transMasterID) {
        this.transMasterID = transMasterID;
    }

    public String getBeginNumber() {
        return beginNumber;
    }

    public void setBeginNumber(String beginNumber) {
        this.beginNumber = beginNumber;
    }

    public String getQueryNumber() {
        return queryNumber;
    }

    public void setQueryNumber(String queryNumber) {
        this.queryNumber = queryNumber;
    }

    @Override
    public String toString() {
        return "SpdFinanceFT20Info{" +
                "transMasterID='" + transMasterID + '\'' +
                ", beginNumber='" + beginNumber + '\'' +
                ", queryNumber='" + queryNumber + '\'' +
                '}';
    }
}
