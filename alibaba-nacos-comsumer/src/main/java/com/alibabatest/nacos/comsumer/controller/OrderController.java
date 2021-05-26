package com.alibabatest.nacos.comsumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderController {
    @Value("${service-url.nacos-user-server}")
    private String serverUrl;
    @Autowired
    private RestTemplate restTemplate;
    @GetMapping("order/get")
    public String get(){
        return restTemplate.getForObject(serverUrl+"/payment/get",String.class);
    }
}
