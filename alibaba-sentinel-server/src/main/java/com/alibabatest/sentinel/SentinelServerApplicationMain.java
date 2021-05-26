package com.alibabatest.sentinel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SentinelServerApplicationMain {
    public static void main(String[] args) {
        SpringApplication.run(SentinelServerApplicationMain.class,args);
    }
}
