package com.alibabatest.sentinel.utils;

import com.alibaba.csp.sentinel.slots.block.BlockException;

public class MyBlockHandler{
    public DataResult customBlackHandlerMethod(String a,String b,BlockException exception){
        return new DataResult("404","异常信息".concat(exception.getMessage()));
    }
}
