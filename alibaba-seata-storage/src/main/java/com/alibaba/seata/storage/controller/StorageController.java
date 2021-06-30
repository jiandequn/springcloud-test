package com.alibaba.seata.storage.controller;

import com.alibaba.seata.storage.entity.StorageEntity;
import com.alibaba.seata.storage.service.StorageService;
import com.alibaba.seata.storage.utils.CommonResult;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StorageController {
    @Autowired
    private StorageService storageService;

    @PostMapping("storage/decrease")
    public CommonResult<StorageEntity> createOrder( Long productId,Integer count){
        this.storageService.decrease(productId,count);
        return new CommonResult<>(200,"减库存成功");
    }
}
