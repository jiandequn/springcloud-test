package com.cloudtest.ribbon;

import com.netflix.loadbalancer.*;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Configuration;

/**
 *
 * 定义负载访问规则接口服务
 */
@Configuration
public class MyRibbonRule {
    public IRule getRule(){
//        return new RoundRobinRule(); //轮询规则
        return new RandomRule();   //随机访问规则
//         return new RetryRule(); //先按照RoundRobinRule的策略获取服务，如果获取服务失败则在指定时间内进行重试，获取可用的服务
//        new WeightedResponseTimeRule(); //对RoundRobinRule的扩展，响应速度越快的实例选择权重越大，越容易获取
//        new BestAvailableRule(); //会有过滤掉由于多次访问故障而处于断路器跳闸状态的服务，然后选择一个并发量最小的服务
//        new AvailabilityFilteringRule(); //会过滤掉故障实例，再选择并发较小的实例
//        new ZoneAvoidanceRule(); //默认规则，复合判断server所在区域的性能和server的可用性选择服务器
    }
}
