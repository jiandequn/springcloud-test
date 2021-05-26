package com.cloudtest.stream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class StreamConsumerApplicationMain {
    public static void main(String[] args) {
        SpringApplication.run(StreamConsumerApplicationMain.class,args);
    }
}
