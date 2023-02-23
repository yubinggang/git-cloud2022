package com.yu.springcloud.service.impl;

import com.yu.springcloud.service.PaymentFeignService;
import org.springframework.stereotype.Component;

@Component
public class PaymentFeignServiceImpl implements PaymentFeignService {
    @Override
    public String paymentHystrixOk(long id) {
        return "服务器宕机后，当前程序出错或超时，请稍后再试";
    }

    @Override
    public String paymentHystrixTimeout(long id) {
        return "服务器宕机后，当前程序出错或超时，请稍后再试";
    }

    @Override
    public String paymentHystrixError(long id) {
        return "服务器宕机后，当前程序出错或超时，请稍后再试";
    }
}
