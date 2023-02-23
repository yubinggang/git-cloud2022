package com.yu.springcloud.service;

import com.yu.springcloud.entities.Payment;

public interface PaymentService {
    // 通过id查询支付
    public Payment getPaymentById(Long id);
    //创建支付
    public int createPayment(Payment payment);
}
