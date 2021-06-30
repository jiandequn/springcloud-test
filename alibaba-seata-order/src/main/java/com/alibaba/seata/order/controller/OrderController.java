package com.alibaba.seata.order.controller;

import com.alibaba.seata.order.entity.OrderEntity;
import com.alibaba.seata.order.service.OrderService;
import com.alibaba.seata.order.utils.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("create")
    public CommonResult<OrderEntity> createOrder(OrderEntity orderEntity){
        this.orderService.insert(orderEntity);
        return new CommonResult<>(200,"创建成功",orderEntity);
    }
}
