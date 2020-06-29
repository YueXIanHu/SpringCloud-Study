package com.huzh.springcloud.alibaba.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author huzh
 * @date 2020/6/29 10:38
 */
@Configuration
@MapperScan({"com.huzh.springcloud.alibaba.dao"})
public class MyBatisConfig {
}

