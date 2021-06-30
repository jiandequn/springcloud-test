package com.alibaba.seata.account.utils;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("coom.alibaba.seata.dao")
public class MyBatisConfig {
}