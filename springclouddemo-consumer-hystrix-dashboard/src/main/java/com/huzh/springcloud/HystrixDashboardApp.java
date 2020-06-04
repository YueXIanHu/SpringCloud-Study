package com.huzh.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @author huzh
 * @description TODO
 * @date 2020/6/3 13:47
 */
@SpringBootApplication
//开启Hystrix服务监控，访问http://localhost:9001/hystrix
@EnableHystrixDashboard
@EnableDiscoveryClient
@EnableFeignClients
@EnableCircuitBreaker
public class HystrixDashboardApp {
    public static void main(String[] args) {
        SpringApplication.run(HystrixDashboardApp.class, args);
    }
}
