package com.yu.springcloud.dao;

import com.yu.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PaymentDao {
    // 通过id查询支付
    public Payment getPaymentById(Long id);
    //创建支付
    public int createPayment(Payment payment);
}
