package com.yu.springcloud;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ConfigMain3355 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigMain3355.class,args);
        System.out.println("启动成功");
    }
}
