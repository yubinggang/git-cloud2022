package com.yu.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.apache.tomcat.jni.Time;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
//设置全局的默认降级方法：对于设置有@HystrixCommand注解但没有设置具体降级方法的方法，会使用默认的降级方法globalHeader
@DefaultProperties(defaultFallback = "globalHeader")
public class PaymentHystrixController {

    @GetMapping("/payment/ok/{id}")
    public String paymentHystrixOk(@PathVariable("id") long id){
        return "payment--ok--" + id;
    }

    @GetMapping("/payment/timeout/{id}")
    @HystrixCommand(fallbackMethod = "paymentHystrixTimeoutHeader",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    })
    public String paymentHystrixTimeout(@PathVariable("id") long id){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "payment--timeout--" + id;
    }

    //    没有配置详细的降级方法，默认使用全局的降级方法
    @GetMapping("/payment/error/{id}")
    @HystrixCommand
    public String paymentHystrixError(@PathVariable("id") long id){
        int a = 10 / 0;
        return "payment--timeout--" + id;
    }

    public String paymentHystrixTimeoutHeader(@PathVariable("id") long id){
        return "当前程序延时或者出错，请稍后再试" + id;
    }

    public String globalHeader(){
        return "全局降级程序：当前程序延时或者出错，请稍后再试";
    }


//    以下进行服务熔断的延时
    @GetMapping("/payment/circle/{id}")
    @HystrixCommand(fallbackMethod = "paymentCircuitBreakerHandler",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),/* 是否开启断路器*/
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),// 请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"), // 时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60"),// 失败率达到多少后跳闸
    })
    public String paymentCircuitBreaker(@PathVariable("id") long id){
        if(id > 0){
            return "调用成功，当前时间" + Time.now() + " 传入参数： " + id;
        }else {
            throw new RuntimeException("请求参数不能为负数" + Time.now());
        }
    }

    public String paymentCircuitBreakerHandler(@PathVariable("id") long id){
        return "这是降级的处理函数，不能传入负数，当前时间" + Time.now() + " 传入参数： " + id;
    }





}
