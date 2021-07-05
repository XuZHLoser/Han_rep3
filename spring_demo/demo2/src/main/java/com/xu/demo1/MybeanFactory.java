package com.xu.demo1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MybeanFactory {
    public static UserService createService() {
        final UserService userService = new UserServiceImpl();
        final MyAspect myAspect = new MyAspect();

        UserService proxyService = (UserService) Proxy.newProxyInstance(MybeanFactory.class.getClassLoader(),
                userService.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        myAspect.before();
                        Object obj = method.invoke(userService, args);
                        myAspect.after();
                        return obj;
                    }
                });
        return proxyService;
    }
}
