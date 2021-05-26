package com.cloudtest.comsumer;

import com.cloudtest.ribbon.MyRibbonRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name = "CLOUD-PAYMENT-SERVICE",configuration = MyRibbonRule.class)
public class EurekaComsumerApplicationMain
{
    public static void main( String[] args )
    {
        SpringApplication.run(EurekaComsumerApplicationMain.class,args);
        System.out.println( "Hello World!" );
    }
}
