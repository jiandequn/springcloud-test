package com.alibabatest.nacos.provider.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

    @Value("${server.port}")
    private String port;
    @GetMapping("payment/get")
    public String get(){
        return "当前提供服务的端口:"+port;
    }
}
