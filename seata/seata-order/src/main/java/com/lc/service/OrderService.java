package com.lc.service;

import com.lc.Order;

public interface OrderService {

    /**
     * 创建订单
     */
    Order create(String userId, String commodityCode, int orderCount);
}