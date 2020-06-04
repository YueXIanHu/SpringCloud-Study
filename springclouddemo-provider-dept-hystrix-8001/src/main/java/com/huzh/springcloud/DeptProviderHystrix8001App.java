package com.huzh.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author huzh
 * @date 2020/4/811:30
 */
@SpringBootApplication
@EnableEurekaClient//本服务启动后会自动注册进eureka服务
@EnableDiscoveryClient//服务发现
@EnableCircuitBreaker//对Hystrix熔断机制的支持
public class DeptProviderHystrix8001App {

    public static void main(String[] args) {
        SpringApplication.run(DeptProviderHystrix8001App.class, args);
    }
}
