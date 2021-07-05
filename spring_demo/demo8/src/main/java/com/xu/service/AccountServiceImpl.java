package com.xu.service;

import com.xu.dao.AccountDao;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.REQUIRED)
//给类加注解代表该类全部方法都加上事务；给方法加注解代表给该方法加上事务
public class AccountServiceImpl implements AccountService {
    private AccountDao accountDao;
    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }
    @Override
    public void transfer(String outer, String inner, Integer money) {
        accountDao.out(outer, money);
        int i = 1/0;
        accountDao.in(inner, money);
    }
}
