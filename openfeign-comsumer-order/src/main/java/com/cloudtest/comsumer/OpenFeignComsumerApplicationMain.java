package com.cloudtest.comsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class OpenFeignComsumerApplicationMain {
    public static void main(String[] args) {
        SpringApplication.run(OpenFeignComsumerApplicationMain.class,args);
    }
}
