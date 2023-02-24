package com.yu.springcloud.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RefreshScope
public class ConfigController {
    @Value("${config.info}")
    private String ConfigInfo;

    @Value("${server.port}")
    private String ServerPort;

    @GetMapping("/config-info")
    public String getConfigInfo(){
        return ServerPort + "的配置信息：/n" + ConfigInfo;
    }

}
