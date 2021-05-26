package com.cloudtest.comsumer.controller;

import com.cloudtest.comsumer.service.PaymentFeignService;
import com.cloudtest.comsumer.service.PaymentHystrixService;
import com.cloudtest.entity.CommonResult;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order2")
public class Order2Controller {
    @Autowired
    private PaymentHystrixService paymentHystrixService;

    @GetMapping("/get/{id}")
    public CommonResult get(@PathVariable Long id){
        return paymentHystrixService.get(id);
    }
    @GetMapping(value = "/timeout/waiting")
    public CommonResult timeout(Long id){
        return paymentHystrixService.timeoutWaiting(id);
    }
    @GetMapping("/get2/{id}")
    public CommonResult get2(@PathVariable Long id){
        return paymentHystrixService.get2(id);
    }
}
