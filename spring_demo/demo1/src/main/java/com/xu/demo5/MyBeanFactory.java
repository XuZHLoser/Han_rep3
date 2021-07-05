package com.xu.demo5;

public class MyBeanFactory {
    public UserService createService() {
        return new UserServiceImpl();
    }
}
