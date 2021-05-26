package com.cloudtest.comsumer.controller;

import com.cloudtest.entity.CommonResult;
import com.cloudtest.entity.PaymentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private RestTemplate restTemplate;
    @PostMapping("/create")
    public CommonResult create(PaymentEntity paymentEntity){
       return restTemplate.postForObject("http://localhost:8001/payment/create",paymentEntity,CommonResult.class);
    }

    @GetMapping("/get/{id}")
    public CommonResult get(@PathVariable Long id){
        return restTemplate.getForObject("http://localhost:8001/payment/get/"+id,CommonResult.class);
    }
}
