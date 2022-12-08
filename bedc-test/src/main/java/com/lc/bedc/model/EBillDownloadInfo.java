package com.lc.bedc.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * 回单下载
 *
 * @author luchao
 * @version v1.0
 * @date 2022/11/30 14:58
 */
@Getter
@Setter
@ToString
public class EBillDownloadInfo extends TaskInfo implements Serializable {
    private static final long serialVersionUID = -2169050106403404380L;
    private String bankCode;
    private Long accId;
    private String qDate;
    private String detailSeqNo;
}
