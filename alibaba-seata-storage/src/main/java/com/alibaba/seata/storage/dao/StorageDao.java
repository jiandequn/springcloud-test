package com.alibaba.seata.storage.dao;

import com.alibaba.seata.storage.entity.StorageEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface StorageDao {

    int decrease(@Param("productId") Long productId, @Param("count") Integer count);

}
