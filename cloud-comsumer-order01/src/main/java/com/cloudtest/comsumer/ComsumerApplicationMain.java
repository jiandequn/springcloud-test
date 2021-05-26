package com.cloudtest.comsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class ComsumerApplicationMain
{
    public static void main( String[] args )
    {
        SpringApplication.run(ComsumerApplicationMain.class,args);
        System.out.println( "Hello World!" );
    }
}
