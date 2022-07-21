package com.lc.service;

import com.lc.vo.UserAddress;

public interface IOrderService {
    /**
     * 用户下单
     * @param userId
     */
    UserAddress placeOrder(int userId);
}