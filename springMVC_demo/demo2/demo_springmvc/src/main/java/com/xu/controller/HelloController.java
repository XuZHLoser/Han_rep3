package com.xu.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloController implements Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        ModelAndView mv = new ModelAndView();

        //封装对象到ModelAndView中
        mv.addObject("msg", "hello!");

        //封装要跳转的视图
        mv.setViewName("hello"); // /WEB_INF/jsp/hello.jsp
        return mv;
    }
}
