package com.alibaba.seata.account.controller;

import com.alibaba.seata.account.service.AccountService;
import com.alibaba.seata.account.utils.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/account/")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @PostMapping("decrease")
    public CommonResult decrease(Long userId, BigDecimal money){
        this.accountService.decrease(userId,money);
        return new CommonResult<>(200,"扣除余额成功");
    }
}
