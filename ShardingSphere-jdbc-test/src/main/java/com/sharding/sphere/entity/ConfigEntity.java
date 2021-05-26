package com.sharding.sphere.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "t_config")
public class ConfigEntity {
    private Long id;
    private String name;
    private String code;
    private String remarks;

}
