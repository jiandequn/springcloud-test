package com.alibaba.seata.order.service;

import com.alibaba.seata.order.dao.OrderDao;
import com.alibaba.seata.order.entity.OrderEntity;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OrderService {
    @Autowired
    private OrderDao orderDao;
    @Autowired
    private StorageService storageService;
    @Autowired
    private AccountService accountService;
    @GlobalTransactional(name = "fsp-create-order",rollbackFor = Exception.class)
    public void insert(OrderEntity orderEntity){
        log.info("创建订单。。");
        orderEntity.setStatus(0);
        this.orderDao.insert(orderEntity);
        log.info("创建订单成功。。");
        log.info(">>订单微服务开始减库存调用 storage.count");
        storageService.decrease(orderEntity.getProductId(), orderEntity.getCount());
        log.info("--->订单微服务减库存结束。");
        log.info(">>订单微服务开始账户余额存调用 --money");
        accountService.decrease(orderEntity.getProductId(), orderEntity.getMoney());
        log.info("--->订单微服务账户余额扣钱结束。");
        //修改订单状态
        log.info("修改订单状态");
        orderEntity.setStatus(1);
        orderDao.update(orderEntity);
        log.info("订单完成。。");
    }
    public void update(OrderEntity orderEntity){
        this.orderDao.update(orderEntity);
    }
    public OrderEntity get(Long userId){
        return this.orderDao.get(userId);
    }
}
