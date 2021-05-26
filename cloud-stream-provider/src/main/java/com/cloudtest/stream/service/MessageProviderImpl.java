package com.cloudtest.stream.service;

import cn.hutool.core.lang.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

@EnableBinding(Source.class) //定义消息的推送管道
public class MessageProviderImpl implements IMessageProvider{
    @Autowired
    private MessageChannel output;  //消息发送管道
    @Override
    public String send(String msg) {
        String serialId= UUID.randomUUID().toString()+"= "+msg;
        output.send(MessageBuilder.withPayload( serialId).build());
        System.out.println("发送了serialID="+serialId);
        return "发送了serialID="+serialId;
    }
}
