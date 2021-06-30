package com.alibaba.seata.storage.service;

import com.alibaba.seata.storage.dao.StorageDao;
import com.alibaba.seata.storage.entity.StorageEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class StorageService {
    @Autowired
    private StorageDao storageDao;
    public void decrease(Long productId,Integer count){
        log.info("库存调用开始。。。");
        this.storageDao.decrease(productId,count);
        log.info("库存调用结束。。。");
    }
}
