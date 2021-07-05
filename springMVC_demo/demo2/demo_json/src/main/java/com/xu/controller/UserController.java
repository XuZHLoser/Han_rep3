package com.xu.controller;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xu.utils.JsonUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.xu.pojo.User;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


//@Controller
//该注解会让该类不经过视图解析器
@RestController
public class UserController {
    //也可以集中在springmvc配置文件中配置
    //@RequestMapping(value = "/j1", produces = "application/json;charset=utf-8")
    @RequestMapping("/j1")
   // @ResponseBody //该注解会让他不走视图解析器
    public String json1() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();

        User user = new User(1, "毛慧华", 18);

        String str = mapper.writeValueAsString(user);

        return str;
    }
    @RequestMapping("/j2")
    public String json2() {
        Date date = new Date();
        return JsonUtils.getJson(date, ":yyyy-MM-dd");
    }
    @RequestMapping("/j3")
    public String json3() {
        List<User> userList = new ArrayList<>();
        User user1 = new User(1, "毛慧华1", 18);
        User user2 = new User(1, "毛慧华2", 18);
        User user3 = new User(1, "毛慧华3", 18);
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        return JSON.toJSONString(userList);
    }
}
