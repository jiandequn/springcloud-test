package com.cloudtest.stream.controller;

import com.cloudtest.stream.service.IMessageProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {
    @Autowired
    private IMessageProvider messageProvider;
    @GetMapping("/send")
    public String send(String msg){
        return messageProvider.send(msg);
    }
}
