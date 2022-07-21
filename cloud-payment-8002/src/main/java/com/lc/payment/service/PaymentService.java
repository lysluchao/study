package com.lc.payment.service;

import com.lc.common.entities.Payment;

public interface PaymentService {
    public int create(Payment payment);

    public Payment getPaymentById( Long id);
}
