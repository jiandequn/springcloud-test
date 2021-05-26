package com.cloudtest.comsumer.utils;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * NONE 默认的
 * BASIC 仅仅记录请求方法，URL，响应状态码及执行时间
 * HEADERS 除了BASIC中定义的信息外，还有请求和响应头信息
 * FULL 除了HEADERS 中定义的信息外，还有请求和响应的正文及其元数据
 */
@Configuration
public class FeignCongfig {
    @Bean
    public Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL;
    }
}
