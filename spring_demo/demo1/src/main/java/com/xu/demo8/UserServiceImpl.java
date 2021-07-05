package com.xu.demo8;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Controller("userServiceId")
public class UserServiceImpl implements UserService {

    @Override
    public void addUser() {
        System.out.println("add_user");
    }
}
