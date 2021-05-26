package com.cloudtest.gateway3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class GateWayEruekaApplicationMain {
    public static void main(String[] args) {
        SpringApplication.run(GateWayEruekaApplicationMain.class,args);

    }
}
