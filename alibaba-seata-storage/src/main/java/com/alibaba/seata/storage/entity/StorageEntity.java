package com.alibaba.seata.storage.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StorageEntity {
    private Long id;
    private Long productId;
    private Integer total;
    private Integer used;
    private Integer residue;

}
