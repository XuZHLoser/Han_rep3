package com.xu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

    @RequestMapping("/hello")
    public String Hello(Model model) {
        model.addAttribute("msg", "hello");
        return "hello";//会被视图解析器处理
    }

}
