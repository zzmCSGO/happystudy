package com.zzm.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @BelongsProject: leet
 * @BelongsPackage: com.zzm.hot100.sixty
 * @Author: zzm
 * @CreateTime: 2024-02-18  12:03
 * @Description: TODO
 * @Version: 1.0
 */
public class ProxySellPig implements InvocationHandler {

    Object object;

    public ProxySellPig() {
    }
    /***
     * newProxyInstance()：创建一个代理实例
     * * 其中有三个参数：
     * * 1、classLoader：加载动态生成的代理类的类加载器
     * * 2、interfaces：目标对象实现的所有接口的class对象所组成的数组
     * * 3、invocationHandler：设置代理对象实现目标对象方法的过程，即代理类中如何重写接 口中的抽象方法
     * */

    public Object newProxy(Object target){
        this.object=target;
        return Proxy.newProxyInstance(object.getClass().getClassLoader(),
                object.getClass().getInterfaces(),this);
    }
    //三个参数分别是：代理对象，被调用的方法，调用方法的参数
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before sell pig");
        Object invoke = method.invoke(object, args);
        System.out.println("after sell pig");
        return invoke;
    }

    public static void main(String[] args) {
        ProxySellPig proxySellPig=new ProxySellPig();//代理
        SellPig sellPig = (SellPig) proxySellPig.newProxy(new SellPigImpl());//代理对象
        sellPig.sellPigs();
    }
}
