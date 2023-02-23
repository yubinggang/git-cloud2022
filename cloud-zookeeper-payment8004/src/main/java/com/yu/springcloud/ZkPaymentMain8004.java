package com.yu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ZkPaymentMain8004 {
    public static void main(String[] args) {
        SpringApplication.run(ZkPaymentMain8004.class,args);
        System.out.println("启动成功");
    }
}
