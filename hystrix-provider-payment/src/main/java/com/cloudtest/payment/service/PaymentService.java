package com.cloudtest.payment.service;

import cn.hutool.core.util.IdUtil;
import com.cloudtest.entity.PaymentEntity;
import com.cloudtest.payment.dao.PaymentDao;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

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

    /**
     * fallbackMethod  降级返回调用函数
     * HystrixProperty execution.isolation.thread.timeoutInMilliseconds 超过3秒针调用降级函数
     * @param id
     * @return
     */
    @HystrixCommand(fallbackMethod = "getPaymentById2Fallback",commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "3000")
    })
    public PaymentEntity getPaymentById2(Long id){
        try {
            TimeUnit.SECONDS.sleep(id*2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this.paymentDao.getPaymentById(id);
    }
    /**
     * 服务端降级操作，直接返回
     * @param id
     * @return
     */
    public PaymentEntity getPaymentById2Fallback(Long id){
        return new PaymentEntity(-1l,"payment降级了");
    }

    /**
     * HystrixPropertiesManager 类中包含了属性信息
     * @param id
     * @return
     */
    @HystrixCommand(fallbackMethod = "testFallbackCiruitBreaker",commandProperties = {
           @HystrixProperty(name="circuitBreaker.enabled",value = "true"), //是否开启熔断机制
            @HystrixProperty(name="circuitBreaker.requestVolumeThreshold",value = "10"), //请求次数
            @HystrixProperty(name="circuitBreaker.sleepWindowInMilliseconds",value = "10000"), //时间窗口期
            @HystrixProperty(name="circuitBreaker.errorThresholdPercentage",value = "60"),//失败率达到多少后跳闸
    })
    public String testCiruitBreaker(Integer id){
        if(id<0){
            throw new RuntimeException("****id不能为负数");
        }
        String sn = IdUtil.simpleUUID();
        return Thread.currentThread().getName()+"\t"+"调用成功，流水号："+sn;
    }
    public String testFallbackCiruitBreaker(Integer id){
        return "id不能为负数，请稍后再试；id="+id;
    }

}
