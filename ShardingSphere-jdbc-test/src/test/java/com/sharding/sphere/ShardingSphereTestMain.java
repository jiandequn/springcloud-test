package com.sharding.sphere;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sharding.sphere.dao.CourseDao;
import com.sharding.sphere.entity.Course;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * 水平分库分表操作 application-sharding.properties配置文件
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ShardingSphereTestMain {
    @Autowired
    private CourseDao courseDao;
    @Test
    public void addCourse(){
        for(int i=0;i<1000;i++){
            Course c = new Course();
            c.setCname("comman-"+i);
            c.setUserId(Double.doubleToLongBits (Math.random()*10000L));
            c.setCstatus("1");
            this.courseDao.insert(c);
        }
    }
    @Test
    public void getCourseAll(){
        QueryWrapper<Course> t = new QueryWrapper();
        t.orderByDesc("cid");
        List<Course> list = this.courseDao.selectList(t);
        System.out.println(".....");
        list.forEach(s-> System.out.println("cid="+s.getCid()+",cname="+s.getCname()+",uid="+s.getUserId()));
    }
    @Test
    public void getCoursePage(){
        QueryWrapper<Course> t = new QueryWrapper();
        t.orderByDesc("cid");
        Page<Course> pg =new Page(2,10);
        IPage<Course> p = this.courseDao.selectPage(pg,t);
        System.out.println(".....");
        System.out.println("总页数："+p.getTotal());
        System.out.println("页数："+p.getPages());

    }
}
