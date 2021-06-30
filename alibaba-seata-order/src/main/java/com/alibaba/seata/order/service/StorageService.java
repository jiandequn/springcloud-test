package com.alibaba.seata.order.service;

import com.alibaba.seata.order.utils.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 库存微服务接口
 */
@Service
@FeignClient(value = "alibaba-seata-storage")
public interface StorageService {
    @PostMapping("storage/decrease")
    CommonResult decrease(@RequestParam("productId") Long productId,@RequestParam("count") Integer count);
}
