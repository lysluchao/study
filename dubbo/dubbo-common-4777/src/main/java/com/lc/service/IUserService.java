package com.lc.service;

import com.lc.vo.UserAddress;

public interface IUserService {
    /**
     * 根据用户id获取用户地址
     * @param userId
     * @return
     */
    UserAddress getUserAddById(int userId);
}
