package com.lc.order.controller;

import com.lc.common.entities.CommonResult;
import com.lc.common.entities.Payment;
import com.lc.order.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderFeignController {
    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping("/order/feign/{id}")
    public CommonResult<Payment>  getPaymentById(@PathVariable("id") Long id){
        return paymentFeignService.getPaymentById(id);
    }

    @GetMapping(value = "/order/feign/timeout")
    public String feignTimeout(){
        return paymentFeignService.paymentTimeout();
    }
}
