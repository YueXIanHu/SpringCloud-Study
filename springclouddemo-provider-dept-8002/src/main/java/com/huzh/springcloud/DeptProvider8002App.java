package com.huzh.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author huzh
 * @date 2020/4/811:30
 */
@SpringBootApplication
//服务注册
@EnableEurekaClient
//服务发现
@EnableDiscoveryClient
public class DeptProvider8002App {
    public static void main(String[] args) {
        SpringApplication.run(DeptProvider8002App.class, args);
    }
}
