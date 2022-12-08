package com.lc.bedc.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * 账户明细查询
 *
 * @author luchao
 * @version v1.0
 * @date 2022/11/16 15:57
 */
@Getter
@Setter
@ToString
public class DetailQueryInfo extends TaskInfo implements Serializable {
    private static final long serialVersionUID = 1547495374079552598L;

    private String bankCode;

    private Long accId;

    private String qDate;

}
