package com.sharding.sphere;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sharding.sphere.dao.ConfigDao;
import com.sharding.sphere.dao.CourseDao;
import com.sharding.sphere.entity.ConfigEntity;
import com.sharding.sphere.entity.Course;
import org.apache.shardingsphere.core.strategy.keygen.SnowflakeShardingKeyGenerator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * 读写分离操作 application-readwritesplited.properties配置文件
 * 主库写，从库读
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class ReadWriteSplitedTestMain {
    @Autowired
    private ConfigDao configDao;
    @Test
    public void addConfig(){
        for(int i=0;i<10;i++){
            ConfigEntity configEntity = new ConfigEntity();
            configEntity.setId((long) i);
            configEntity.setCode("code-"+i);
            configEntity.setName("name-"+i);
            configEntity.setRemarks(("desc-"+i));
            this.configDao.insert(configEntity);
        }
    }
    @Test
    public void getById(){
        for(int i=0;i<10;i++){
            ConfigEntity entity = this.configDao.selectById(i);
            if(entity != null)
                System.out.println(entity.getId()+";name="+entity.getName());
        }
    }
}
