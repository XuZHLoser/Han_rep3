package com.xu.demo5;

public class UserServiceImpl implements UserService {

    @Override
    public void addUser() {
        System.out.println("add");
    }

    @Override
    public void updateUser() {
        System.out.println("update");
    }

    @Override
    public void deleteUser() {
        System.out.println("delete");
    }
}
