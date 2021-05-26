package com.cloudtest.dashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 *
 *http://localhost:9001/hystrix 图形化界面访问
 */
@SpringBootApplication
@EnableHystrixDashboard
public class HystrixDashBoardApplicationMain {
    public static void main(String[] args) {
        SpringApplication.run(HystrixDashBoardApplicationMain.class,args);
    }
}
