package com.lc.payment.service.impl;


import com.lc.common.entities.Payment;
import com.lc.payment.dao.PaymentDao;
import com.lc.payment.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }

    public static void main(String[] args) {
        System.out.println(Math.round(11.5));
        System.out.println(Math.round(-11.5));
    }
}