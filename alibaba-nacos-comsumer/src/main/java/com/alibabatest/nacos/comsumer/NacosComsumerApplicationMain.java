package com.alibabatest.nacos.comsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class NacosComsumerApplicationMain {
    public static void main(String[] args) {
        SpringApplication.run(NacosComsumerApplicationMain.class,args);
    }
}
