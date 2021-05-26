package com.cloudtest.comsumer.controller;

import com.cloudtest.comsumer.service.PaymentFeignService;
import com.cloudtest.entity.CommonResult;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
@DefaultProperties(defaultFallback = "getFallback")
public class OrderController {
    @Autowired
    private PaymentFeignService paymentFeignService;

    @GetMapping("/get/{id}")
    @HystrixCommand
    public CommonResult get(@PathVariable Long id){
        return paymentFeignService.get(id);
    }
    @GetMapping(value = "/timeout/waiting")
    @HystrixCommand
    public CommonResult timeout(Long id){
        return paymentFeignService.timeoutWaiting(id);
    }
    /**
     * fallbackMethod  降级返回调用函数
     * HystrixProperty execution.isolation.thread.timeoutInMilliseconds 超过3秒针调用降级函数
     */
    @GetMapping("/get2/{id}")
    @HystrixCommand(fallbackMethod = "get2Fallback",commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "1000")
    })
    public CommonResult get2(@PathVariable Long id){
        return paymentFeignService.get2(id);
    }

    public CommonResult get2Fallback(Long id){
        return new CommonResult(400,"服务提供方服务不可用");
    }
    public CommonResult getFallback(){
        return new CommonResult(400,"全局调用降级，服务提供方服务不可用");
    }
}
