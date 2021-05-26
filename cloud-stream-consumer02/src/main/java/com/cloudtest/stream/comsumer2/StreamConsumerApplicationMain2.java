package com.cloudtest.stream.comsumer2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class StreamConsumerApplicationMain2 {
    public static void main(String[] args) {
        SpringApplication.run(StreamConsumerApplicationMain2.class,args);
    }
}
