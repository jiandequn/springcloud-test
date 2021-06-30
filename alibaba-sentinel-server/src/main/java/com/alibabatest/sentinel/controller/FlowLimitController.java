package com.alibabatest.sentinel.controller;

import com.alibaba.csp.sentinel.adapter.spring.webflux.callback.BlockRequestHandler;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibabatest.sentinel.utils.DataResult;
import com.alibabatest.sentinel.utils.MyBlockHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

@RestController
public class FlowLimitController {
    @GetMapping("test1")
    public String test1(){
        return "test1...";
    }
    @GetMapping("test2")
    public String test2(){
        return "test2...";
    }

    @GetMapping("test3")
    public String test3(){
        return "test3...";
    }


    @GetMapping("hotkey")
    @SentinelResource(value ="hotkey" ,blockHandler = "action_blockHandler")
    public String hotkey(String a,String b){
        StringJoiner stringJoiner = new StringJoiner(",","[","]");
        return stringJoiner.add(a).add(b).toString();
    }
    public String action_blockHandler(String a, String b, BlockException blockException){
        return "----blockException";
    }

    @GetMapping("testhotkey")
    @SentinelResource(value ="hotkey" ,blockHandlerClass = MyBlockHandler.class,blockHandler = "customBlackHandlerMethod")
    public DataResult testhotkey(String a, String b){
        Map map =new HashMap<>();
        map.put("a",a);
        map.put("b",b);
        return new DataResult("200",map);
    }
}
