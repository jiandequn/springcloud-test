package com.alibabatest.sentinel.utils;

import java.io.Serializable;

public class DataResult implements Serializable {
    private String code;
    private String msg;
    private Object data;
    public DataResult(){

    }
    public DataResult(String code,String msg){
        this.code=code;
        this.msg = msg;
    }
    public DataResult(String code,Object data){
        this.code=code;
        this.data=data;
    }
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
