package com.cloudtest.stream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class StreamProviderApplicationMain {
    public static void main(String[] args) {
        SpringApplication.run(StreamProviderApplicationMain.class,args);
    }
}
