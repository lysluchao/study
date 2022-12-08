package com.lc.bedc.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * 历史余额查询
 *
 * @author luchao
 * @version v1.0
 * @date 2022/11/16 09:15
 */
@Getter
@Setter
@ToString
public class HisBalQueryInfo extends TaskInfo implements Serializable {
    private static final long serialVersionUID = -1003993775189259407L;

    private String bankCode;

    private Long accId;

    private String startDate;

    private String endDate;

    private String busiSeqNo;

}
