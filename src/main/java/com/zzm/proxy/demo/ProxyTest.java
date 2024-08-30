package com.zzm.proxy.demo;

import com.zzm.proxy.IUserService;
import com.zzm.proxy.UserServiceImpl;
import com.zzm.proxy.handler.MyInvocationHandler;

import java.lang.reflect.Proxy;

/**
 * @Author:zzm
 * @Date:2024/8/22 15:30
 */
public class ProxyTest {
    public static void main(String[] args) throws Throwable {
        IUserService userService = new UserServiceImpl();
        MyInvocationHandler handler = new MyInvocationHandler(userService);
        IUserService proxy = (IUserService) Proxy.newProxyInstance(userService.getClass().getClassLoader(), userService.getClass().getInterfaces(), handler);
        proxy.add("张三");
    }
}
