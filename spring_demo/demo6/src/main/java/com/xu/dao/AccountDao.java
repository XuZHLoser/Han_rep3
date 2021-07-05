package com.xu.dao;

public interface AccountDao {

    //汇款
    void out(String outer, Integer money);
    //收款
    void in(String inner, Integer money);
}
