package com.xu.demo10;

public class UserServiceImpl implements UserService {

    private int i = 0;

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    @Override
    public void addUser() {
        System.out.println("add_user");
    }

}
