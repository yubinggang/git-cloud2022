package com.yu.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsulPaymentCotroller {
    @Value("${server.port}")
    private String ServerPort;

    @GetMapping("/payment/consul")
    public String getZkInfo(){
        return "注册到consul,serverport: " + ServerPort;
    }

}
