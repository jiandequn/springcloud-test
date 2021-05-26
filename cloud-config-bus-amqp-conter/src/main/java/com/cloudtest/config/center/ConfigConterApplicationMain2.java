package com.cloudtest.config.center;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ConfigConterApplicationMain2 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigConterApplicationMain2.class,args);
    }
}
