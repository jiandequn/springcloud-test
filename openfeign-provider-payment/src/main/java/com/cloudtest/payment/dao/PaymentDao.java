package com.cloudtest.payment.dao;

import com.cloudtest.entity.PaymentEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PaymentDao {
    int create(PaymentEntity payment);

    PaymentEntity getPaymentById(Long id);
}
