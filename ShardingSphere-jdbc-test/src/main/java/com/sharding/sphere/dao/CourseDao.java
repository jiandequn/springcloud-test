package com.sharding.sphere.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sharding.sphere.entity.Course;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

//@Mapper
@Repository
public interface CourseDao extends BaseMapper<Course> {
}
