package com.lc.service.impl;

import com.lc.*;
import com.lc.client.SeataStockClient;
import com.lc.dao.OrderTblDao;
import com.lc.service.OrderService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.security.SecureRandom;

/**
 * @author chao14.lu
 * @create 2024-01-26 17:00
 */
@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {

    @Resource
    private  OrderTblDao orderTblDao;
    private final SeataStockClient seataStockClient;

    @Override
    @GlobalTransactional(rollbackFor = Exception.class)
    public Order create(String userId, String commodityCode, int orderCount) {
        SecureRandom secureRandom=new SecureRandom();
        int anInt = secureRandom.nextInt();
        OrderTbl orderTbl = new OrderTbl();
        orderTbl.setCount(orderCount);
        orderTbl.setCommodityCode(commodityCode);
        orderTbl.setMoney(anInt);
        orderTbl.setUserId(userId);
        orderTblDao.insert(orderTbl);

        seataStockClient.sale(commodityCode,orderCount);
        return null;
    }
}
