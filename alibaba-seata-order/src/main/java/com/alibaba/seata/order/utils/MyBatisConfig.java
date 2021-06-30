package com.alibaba.seata.order.utils;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("coom.alibaba.seata.dao")
public class MyBatisConfig {
}