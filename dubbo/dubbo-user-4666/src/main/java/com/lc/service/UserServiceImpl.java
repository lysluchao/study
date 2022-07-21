package com.lc.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.lc.vo.UserAddress;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;


@Service(weight = 100)
@Component
public class UserServiceImpl implements IUserService {

    @Override
    public UserAddress getUserAddById(int userId) {
        try {
            TimeUnit.SECONDS.sleep(30);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        UserAddress userAddress = new UserAddress();
        userAddress.setUserAddress("上海市宝山区");
        return userAddress;
    }

}

