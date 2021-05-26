package com.cloudtest.payment.service;

import com.cloudtest.entity.PaymentEntity;
import com.cloudtest.payment.dao.PaymentDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PaymentService {
    @Resource
    private PaymentDao paymentDao;

    public int create(PaymentEntity entity){
        return paymentDao.create(entity);
    }
    public PaymentEntity getPaymentById(Long id){
        return this.paymentDao.getPaymentById(id);
    }
}
