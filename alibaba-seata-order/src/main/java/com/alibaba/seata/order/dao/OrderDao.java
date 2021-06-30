package com.alibaba.seata.order.dao;

import com.alibaba.seata.order.entity.OrderEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface OrderDao {
    void insert(OrderEntity orderEntity);

    void update(OrderEntity orderEntity);

    OrderEntity get(@Param("userId") Long userId);
}
