package com.xu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AddController {
    //可以通过操控method变量来控制提交方式（get或post）：
    //@RequestMapping(value = "/add/{a}/{b}", method = RequestMethod.GET)
    //上述也可简化为以下写法：
    //@GetMapping("/add/{a}/{b}")  get方法
    //@PostMapping("/add/{a}/{b}") post方法
    @RequestMapping("/add/{a}/{b}")
    public String test1(@PathVariable int a, @PathVariable int b, Model model) {
        int res = a + b;
        model.addAttribute("msg", res);
        return "test";
    }
}
