package com.lc.bedc.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * 历史明细查询
 *
 * @author luchao
 * @version v1.0
 * @date 2022/11/14 15:57
 */
@Getter
@ToString
@Setter
public class HisDetailQueryInfo extends TaskInfo implements Serializable {
    private static final long serialVersionUID = 2937513367445866481L;
    private String bankCode;

    private Long accId;

    private String startDate;

    private String endDate;

    private String busiSeqNo;

}
