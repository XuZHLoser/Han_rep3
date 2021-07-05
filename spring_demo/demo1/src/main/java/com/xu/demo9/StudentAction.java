package com.xu.demo9;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller("studentActionId")
public class StudentAction {
    @Autowired//默认按照类型注入
    private StudentService studentService;

    public void execute() {
        studentService.addStudent();
    }


}
