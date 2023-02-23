package com.yu.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.yu.springcloud.service.impl.PaymentFeignServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
//新建一个类实现本地的service接口，当接口中要调用的服务器宕机之后，就会使用该类中具体实现的方法作为降级方法、
@FeignClient(value = "CLOUD-PAYMENT-SERVICE",fallback = PaymentFeignServiceImpl.class)
public interface PaymentFeignService {

    @GetMapping("/payment/ok/{id}")
    public String paymentHystrixOk(@PathVariable("id") long id);

    @GetMapping("/payment/timeout/{id}")
    public String paymentHystrixTimeout(@PathVariable("id") long id);

    @GetMapping("/payment/error/{id}")
    public String paymentHystrixError(@PathVariable("id") long id);

}
