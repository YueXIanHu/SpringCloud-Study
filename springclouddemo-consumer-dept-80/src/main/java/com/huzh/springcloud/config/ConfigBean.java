package com.huzh.springcloud.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RetryRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author huzh
 * @date 2020/4/813:49
 */
@Configuration
public class ConfigBean {

    @Bean
    @LoadBalanced  //使用@LoadBalanced注解赋予RestTemplate负载均衡的能力 默认轮询
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    //显示声明就用显示的
    @Bean
    public IRule myRule() {
//        return new RandomRule();//随机
        return new RetryRule();//
    }

}
