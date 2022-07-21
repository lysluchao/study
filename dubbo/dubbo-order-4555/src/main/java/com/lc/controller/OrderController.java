package com.lc.controller;

import com.lc.service.IOrderService;
import com.lc.vo.UserAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class OrderController {
    @Autowired
    IOrderService orderService;

    @RequestMapping("/initOrder")
    @ResponseBody
    public UserAddress initOrder(@RequestParam("uid")int userId) {
        return orderService.placeOrder(userId);
    }
}
