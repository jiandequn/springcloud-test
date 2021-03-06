package com.sharding.sphere;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.sharding.sphere.dao")
public class ShardingSphereMain {
    public static void main(String[] args) {
        SpringApplication.run(ShardingSphereMain.class, args);
    }
}
