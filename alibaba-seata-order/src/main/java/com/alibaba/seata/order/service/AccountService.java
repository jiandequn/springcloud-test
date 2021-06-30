package com.alibaba.seata.order.service;

import com.alibaba.seata.order.utils.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * 账户余额微服务接口
 */
@Service
@FeignClient(value = "alibaba-seata-account")
public interface AccountService {
    @PostMapping("account/decrease")
    CommonResult decrease(@RequestParam("userId") Long userId,@RequestParam("money") BigDecimal money);
}
