package com.cloudtest.comsumer.lib;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class MyLoadBalancerImpl implements LoadBalancer{
    private AtomicInteger atomicInteger = new AtomicInteger(0);
    public final int getAndIncrement(){
        int current;
        int next;
        for(;;){
            current = this.atomicInteger.get();
            next=current>Integer.MAX_VALUE?0:current+1;
            if(this.atomicInteger.compareAndSet(current,next)){
                return next;
            }

        }
    }
    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstanceList) {
        int index = getAndIncrement() % serviceInstanceList.size();
        return serviceInstanceList.get(index);
    }
}
