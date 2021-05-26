package com.cloudtest.comsumer.service;

import com.cloudtest.entity.CommonResult;
import feign.Headers;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Service
@FeignClient(value = "HYSTRIX-PAYMENT-SERVICE")
public interface PaymentFeignService {
    @GetMapping(value = "/payment/get/{id}")
    public CommonResult get(@PathVariable("id") Long id);

    @GetMapping(value = "/payment/get2/{id}")
    public CommonResult get2(@PathVariable("id") Long id);

    @GetMapping("/payment/timeout/waiting")
    public CommonResult timeoutWaiting(@RequestParam("sec") Long sec);
}
