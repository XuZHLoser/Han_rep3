package com.xu.demo4;

public class MyBeanFactory {
    public UserService createService() {
        return new UserServiceImpl();
    }
}
