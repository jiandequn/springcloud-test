package com.sharding.sphere.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sharding.sphere.entity.ConfigEntity;
import com.sharding.sphere.entity.Course;
import org.springframework.stereotype.Repository;

//@Mapper
@Repository
public interface ConfigDao extends BaseMapper<ConfigEntity> {
}
