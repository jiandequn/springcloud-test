package com.alibaba.seata.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class) //排除dataSource自动装配
@EnableDiscoveryClient
@EnableFeignClients()
public class OrderSeataApplicationMain {
    public static void main(String[] args) {
        SpringApplication.run(OrderSeataApplicationMain.class,args);
    }
}
