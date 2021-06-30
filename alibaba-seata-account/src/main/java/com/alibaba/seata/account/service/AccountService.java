package com.alibaba.seata.account.service;

import com.alibaba.seata.account.dao.AccountDao;
import org.apache.commons.lang3.ThreadUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

/**
 * 账户余额微服务接口
 */
@Service
public class AccountService {
    @Autowired
    private AccountDao accountDao;
    public void decrease(Long userId, BigDecimal money){
        try {
            TimeUnit.SECONDS.sleep(15L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        accountDao.decrease(userId,money);
    }
}
