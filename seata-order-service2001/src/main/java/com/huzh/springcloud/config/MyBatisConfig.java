package com.huzh.springcloud.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author huzh
 * @date 2020/6/28 18:51
 */
@Configuration
@MapperScan({"com.huzh.springcloud.dao"})
public class MyBatisConfig {
}

