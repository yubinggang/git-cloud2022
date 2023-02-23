package com.yu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker //开启Hystrix的客户端
public class PaymentHystrixMain8008 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentHystrixMain8008.class,args);
        System.out.println("启动成功");
    }
}
