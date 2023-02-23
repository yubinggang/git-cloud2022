package com.yu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ZkOrderMain80 {
    public static void main(String[] args) {
        SpringApplication.run(ZkOrderMain80.class,args);
        System.out.println("启动成功");
    }
}
