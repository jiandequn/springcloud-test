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
        if(res != null){
            return new CommonResult(1,"success",res);
        }
        log.info("ttt");
        return new CommonResult(0,"error");
    }
    @GetMapping(value = "/get2/{id}")
    public CommonResult get2(@PathVariable(name = "id") Long id){
        PaymentEntity res = this.paymentService.getPaymentById(id);
        if(res != null){
            return new CommonResult(1,"success",res);
        }
        log.info("ttt");
        return new CommonResult(0,"error");
    }
    @GetMapping(value = "/payment/discovery")
    public Object getDiscovery() {
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info("----------element:" + service);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info("serviceId:[{}], 主机名称:[{}], 端口号:[{}], url地址:[{}]", instance.getServiceId(), instance.getHost(), instance.getPort(), instance.getUri());
        }
        return this.discoveryClient;
    }
}
