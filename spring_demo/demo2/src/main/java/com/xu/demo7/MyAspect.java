package com.xu.demo7;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
//不用写id，因为作用在同一个类上
@Component
@Aspect
public class MyAspect {
    @Before("execution(* com.xu.demo7.UserServiceImpl.*(..))")
    public void myBefore() {
        System.out.println("before");
    }
    //@PointCut 修饰方法private void XXX, 之后通过"方法名“获得切入点引用
}

