package com.zzm.proxy.handler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Author:zzm
 * @Date:2024/8/22 15:26
 */
public class MyInvocationHandler implements InvocationHandler {

    private Object target;

    public MyInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("代理开始");
        Object invoke = method.invoke(target, args);
        System.out.println("代理结束");
        return invoke;
    }

}
