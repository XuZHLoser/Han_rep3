package com.xu.controller;

import com.xu.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/user")
public class UserController {
    @GetMapping("/t1")
    public  String test1(@RequestParam("username") String name, Model model) {
        System.out.println(name);
        model.addAttribute("msg", name);
        return "test";
    }
    //前端接受一个对象：id，name，age，前端传递的参数会会自动匹配对象的字段名
    @GetMapping("/t2")
    public String test2(User user) {
        System.out.println(user);
        return "test";
    }


}
