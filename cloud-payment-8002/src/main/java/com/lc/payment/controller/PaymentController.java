package com.lc.payment.controller;

import com.lc.common.entities.CommonResult;
import com.lc.common.entities.Payment;
import com.lc.payment.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;
    @Value("${server.port}")
    private String serverPort;

    @PostMapping(value = "/payment/create")
    public CommonResult<Integer> create(Payment payment) {
        int result = paymentService.create(payment);
        log.info("----------插入结果：{}" , result);
        if(result>0){
            return new CommonResult<>(200, "插入成功"+serverPort, result);
        }else {
            return new CommonResult<>(400,"插入失败"+serverPort,null);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable Long id) {
        Payment payment=paymentService.getPaymentById(id);
        log.info("----------查询结果：{}" , payment);
        if(payment==null){
            return new CommonResult<>(400,"查询失败"+serverPort,null);
        }else{
            return new CommonResult<>(200,"查询成功"+serverPort,payment);
        }
    }
}
