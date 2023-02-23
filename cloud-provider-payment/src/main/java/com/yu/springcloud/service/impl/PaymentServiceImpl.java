package com.yu.springcloud.service.impl;

import com.yu.springcloud.dao.PaymentDao;
import com.yu.springcloud.entities.Payment;
import com.yu.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Resource
    private PaymentDao paymentDao;

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }

    @Override
    public int createPayment(Payment payment) {
        return paymentDao.createPayment(payment);
    }
}
