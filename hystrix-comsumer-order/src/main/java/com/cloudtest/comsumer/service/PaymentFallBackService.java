package com.cloudtest.comsumer.service;

import com.cloudtest.entity.CommonResult;
import org.springframework.stereotype.Component;

@Component
public class PaymentFallBackService implements PaymentHystrixService{
    @Override
    public CommonResult get(Long id) {
        return new CommonResult(400,"get方法调用失败");
    }

    @Override
    public CommonResult get2(Long id) {
        return new CommonResult(400,"get2方法调用失败");
    }

    @Override
    public CommonResult timeoutWaiting(Long sec) {
        return new CommonResult(400,"timeoutWaiting方法调用失败");
    }
}
