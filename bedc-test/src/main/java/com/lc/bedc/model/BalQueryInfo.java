package com.lc.bedc.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * 当前余额查询
 *
 * @author luchao
 * @version v1.0
 * @date 2022/11/15 14:14
 */
@Getter
@Setter
@ToString
public class BalQueryInfo extends TaskInfo implements Serializable {
    private static final long serialVersionUID = -6595155851655013113L;
    private String bankCode;
    private Long accId;
    private String qDate;
}
