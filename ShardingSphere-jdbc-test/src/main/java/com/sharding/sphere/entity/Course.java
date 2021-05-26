package com.sharding.sphere.entity;

import lombok.Data;

@Data
public class Course {
    private Long cid;
    private String cname;
    private String cstatus;
    private  Long userId;

}
