package com.cloudtest.comsumer.controller;

import com.cloudtest.entity.CommonResult;
import com.cloudtest.entity.PaymentEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/order")
@Slf4j
public class OrderController {
    String REQUEST_URL="http://consul-provider-payment";

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/create")
    public CommonResult create(PaymentEntity paymentEntity){
       return restTemplate.postForObject(REQUEST_URL+"/payment/create",paymentEntity,CommonResult.class);
    }

    @GetMapping("/get/{id}")
    public CommonResult get(@PathVariable Long id){
        return restTemplate.getForObject(REQUEST_URL+"/payment/get/"+id,CommonResult.class);
    }

    @Autowired
    private DiscoveryClient discoveryClient;
    @GetMapping("/1")
    public List serviceUrl() {
        List list = new ArrayList();
        List<String> services = discoveryClient.getServices();
        services.forEach(s->{
            list.add(discoveryClient.getInstances(s));
        });

        return list;
    }
}
