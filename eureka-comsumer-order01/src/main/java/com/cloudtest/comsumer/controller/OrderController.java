package com.cloudtest.comsumer.controller;

import com.cloudtest.comsumer.lib.MyLoadBalancerImpl;
import com.cloudtest.entity.CommonResult;
import com.cloudtest.entity.PaymentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    private String PAYMENT_URL="http://CLOUD-PAYMENT-SERVICE";
    @Autowired
    private RestTemplate restTemplate;
    @PostMapping("/create")
    public CommonResult create(PaymentEntity paymentEntity){
       return restTemplate.postForObject(PAYMENT_URL+"/payment/create",paymentEntity,CommonResult.class);
    }

    @GetMapping("/get/{id}")
    public CommonResult get(@PathVariable Long id){
        return restTemplate.getForObject(PAYMENT_URL+"/payment/get/"+id,CommonResult.class);
    }
    @Autowired
    private DiscoveryClient discoveryClient;
    @Autowired
    private MyLoadBalancerImpl myLoadBalancer;
    @GetMapping("/get2/{id}")
    public CommonResult get2(@PathVariable Long id){
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        ServiceInstance instance = myLoadBalancer.instances(instances);
        URI uri = instance.getUri();
        return restTemplate.getForObject(uri+"/payment/get/"+id,CommonResult.class);
    }
}
