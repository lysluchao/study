package com.lc;

import java.io.Serializable;

/**
 * (StockTbl)实体类
 *
 * @author makejava
 * @since 2024-01-26 17:11:47
 */
public class StockTbl implements Serializable {
    private static final long serialVersionUID = -89577838872689248L;

    private Integer id;

    private String commodityCode;

    private Integer count;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCommodityCode() {
        return commodityCode;
    }

    public void setCommodityCode(String commodityCode) {
        this.commodityCode = commodityCode;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

}

