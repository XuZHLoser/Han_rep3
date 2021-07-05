package com.xu.demo3;

public class MyBeanFactory {
    public static UserService createService() {
        return new UserServiceImpl();
    }
}
