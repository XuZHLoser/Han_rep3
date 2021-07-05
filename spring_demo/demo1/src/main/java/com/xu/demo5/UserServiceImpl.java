package com.xu.demo5;

public class UserServiceImpl implements UserService {
    @Override
    public void addUser() {
        System.out.println("add_user");
    }
    public void myInit() {
        System.out.println("init");
    }
    public void myDestroy() {
        System.out.println("destroy");
    }
}
