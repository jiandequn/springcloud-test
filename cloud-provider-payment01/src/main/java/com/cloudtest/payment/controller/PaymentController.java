package com.cloudtest.payment.controller;

import com.cloudtest.entity.CommonResult;
import com.cloudtest.entity.PaymentEntity;
import com.cloudtest.payment.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
@Slf4j
public class PaymentController {
    @Autowired
    private PaymentService paymentService;
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
        if(res != null){
            return new CommonResult(1,"success",res);
        }
        log.info("ttt");
        return new CommonResult(0,"error");
    }
}
