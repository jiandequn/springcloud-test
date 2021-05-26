package com.alibabatest.nacos.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class NacosProviderApplicationMain {
    public static void main(String[] args) {
        SpringApplication.run(NacosProviderApplicationMain.class,args);
    }
}
