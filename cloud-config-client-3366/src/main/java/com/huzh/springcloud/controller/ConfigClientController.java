package com.huzh.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author huzh
 * @date 2020/6/22 15:40
 */
@RestController
@RefreshScope
//curl -X POST "http://localhost:3344/actuator/bus-refresh"  全局通知
//curl -X POST "http://localhost:3344/actuator/bus-refresh/config-client:3355"  全局通知
public class ConfigClientController {
    @Value("${server.port}")
    private String serverPort;

    @Value("${config.info}")
    private String configInfo;

    @GetMapping("/configInfo")
    public String configInfo() {
        return "serverPort: " + serverPort + "\t\n\n configInfo: " + configInfo;
    }

}
