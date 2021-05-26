package com.cloudtest.comsumer.controller;

import com.cloudtest.comsumer.service.PaymentFeignService;
import com.cloudtest.entity.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private PaymentFeignService paymentFeignService;

    @GetMapping("/get/{id}")
    public CommonResult get(@PathVariable Long id){
        return paymentFeignService.get(id);
    }
    @GetMapping(value = "/timeout/waiting")
    public CommonResult timeout(Long id){
        return paymentFeignService.timeoutWaiting(id);
    }

}
