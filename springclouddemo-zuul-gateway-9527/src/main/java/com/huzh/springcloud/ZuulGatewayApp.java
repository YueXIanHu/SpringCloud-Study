package com.huzh.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author huzh
 * @description TODO
 * @date 2020/6/3 17:04
 */
@SpringBootApplication
@EnableZuulProxy //开启zuul
public class ZuulGatewayApp {

    public static void main(String[] args) {
        SpringApplication.run(ZuulGatewayApp.class);
    }
}
