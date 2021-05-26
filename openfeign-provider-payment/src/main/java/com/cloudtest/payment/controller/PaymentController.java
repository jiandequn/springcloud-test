package com.cloudtest.payment.controller;

import com.cloudtest.entity.CommonResult;
import com.cloudtest.entity.PaymentEntity;
import com.cloudtest.payment.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/payment")
@Slf4j
public class PaymentController {
    @Autowired
    private PaymentService paymentService;
    @Autowired
    private DiscoveryClient discoveryClient;
    @PostMapping(value = "/create")
    public CommonResult create(PaymentEntity entity){
        int res = this.paymentService.create(entity);
        System.out.println("222");
        if(res==1){
            return new CommonResult(1,"success");
        }
        return new CommonResult(0,"error");
    }

    @GetMapping(value = "/get/{id}")
    public CommonResult get(@PathVariable(name = "id") Long id){
        PaymentEntity res = this.paymentService.getPaymentById(id);
        try {
            log.info("开始休息get。。。。");
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(res != null){
            return new CommonResult(1,"success",res);
        }
        log.info("ttt");
        return new CommonResult(0,"error");
    }
    @GetMapping(value = "/timeout/waiting")
    public CommonResult timeout(Long sec) {
        try {
            log.info("开始休息/timeout/waiting。。。。");
            TimeUnit.SECONDS.sleep(sec);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new CommonResult(200,"超时等待时间"+sec+"秒");
    }
}
