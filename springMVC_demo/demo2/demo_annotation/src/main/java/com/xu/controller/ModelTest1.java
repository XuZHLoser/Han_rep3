package com.xu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class ModelTest1 {
    @RequestMapping("/m1/t1")
    public String test1(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        System.out.println(session.getId());
        return "hello";
//        如果没有注册视图解析器，则可以用return "WEB-INF/jsp/hello.jsp"
//        可以显示的标注用转发还是重定向（默认转发）：return "forward:WEB-INF/jsp/hello.jsp"
        //                                     return "redirect:WEB-INF/jsp/hello.jsp"
    }

}
