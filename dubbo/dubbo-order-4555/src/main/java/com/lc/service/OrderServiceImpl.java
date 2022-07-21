package com.lc.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.rpc.cluster.loadbalance.RoundRobinLoadBalance;
import com.alibaba.dubbo.rpc.cluster.support.FailoverCluster;
import com.lc.vo.UserAddress;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements IOrderService {

    //引用远程提供者服务
    @Reference(loadbalance = RoundRobinLoadBalance.NAME,cluster = FailoverCluster.NAME,mock = "fail:return null")
    private IUserService userService;

    @Override
    public UserAddress placeOrder(int userId) {
        // 远程调用，获取用户地址
        UserAddress userAddById = userService.getUserAddById(userId);
        return userAddById;
    }
}
