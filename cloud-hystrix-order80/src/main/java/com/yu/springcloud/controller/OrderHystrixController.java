package com.yu.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.yu.springcloud.service.PaymentFeignService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/consumer")
public class OrderHystrixController {
    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping("/payment/ok/{id}")
    public String paymentHystrixOk(@PathVariable("id") long id){
        return paymentFeignService.paymentHystrixOk(id);
    }

    @GetMapping("/payment/timeout/{id}")
    @HystrixCommand(fallbackMethod = "paymentHystrixTimeoutHeader",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1500")
    })
    public String paymentHystrixTimeout(@PathVariable("id") long id){
        return paymentFeignService.paymentHystrixTimeout(id);
    }

    @GetMapping("/payment/error/{id}")
    public String paymentHystrixError(@PathVariable("id") long id){
        return paymentFeignService.paymentHystrixError(id);
    }

    public String paymentHystrixTimeoutHeader(@PathVariable("id") long id){
        return "当前程序延时或者出错，请稍后再试" + id;
    }



}
