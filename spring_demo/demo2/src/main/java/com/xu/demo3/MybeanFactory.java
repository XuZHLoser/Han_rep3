package com.xu.demo3;

import org.springframework.cglib.proxy.Callback;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MybeanFactory {
    public static UserServiceImpl createService() {
        final UserServiceImpl userService = new UserServiceImpl();
        final MyAspect myAspect = new MyAspect();
        //cjlib:底层创建了目标类的子类
        Enhancer enhancer = new Enhancer();//cjlib核心：增强类

        enhancer.setSuperclass(userService.getClass());

        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
                myAspect.before();
                Object obj = method.invoke(userService, args);
                myAspect.after();
                return obj;
            }
        });
        UserServiceImpl proxyService = (UserServiceImpl) enhancer.create();

        return proxyService;

    }
}
