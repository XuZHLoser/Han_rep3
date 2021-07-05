package com.xu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;

//在templates目录下的所有页面，只能通过controller来跳转
//需要模板引擎的支持
@Controller
public class TestController {
    @RequestMapping("/test")
    public String index(Model model) {
        model.addAttribute("msg", "hello");
        model.addAttribute("users", Arrays.asList("qj", "xzh"));
        return "test";
    }
}
