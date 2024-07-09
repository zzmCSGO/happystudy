package com.zzm.aop;//package com.zzm.aop;
//
//import com.neu.ucenter.service.impl.PasswordAuthServiceImpl;
//import org.springframework.cglib.proxy.Enhancer;
//import org.springframework.cglib.proxy.MethodInterceptor;
//import org.springframework.cglib.proxy.MethodProxy;
//
//import java.lang.reflect.Method;
//
///**
// * @BelongsProject: llyz-neu-project
// * @BelongsPackage: com.neu.ucenter.service
// * @Author: zzm
// * @CreateTime: 2024-02-18  12:23
// * @Description: TODO
// * @Version: 1.0
// */
//public class CglibPro implements MethodInterceptor {
//
//    private Object target;
//
//    public CglibPro() {
//    }
//
//    public Object newProxy(Object object) {
//        //创建代理对象
//        this.target = object;
//        Enhancer enhancer = new Enhancer();
//        enhancer.setSuperclass(target.getClass());
//        enhancer.setCallback(this);
//        return enhancer.create();
//    }
//    @Override
//    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
//        System.out.println("before sell pig  cglib");
//        Object object=methodProxy.invokeSuper(o,objects);
//        System.out.println("after sell pig  cglib");
//        return object;
//    }
//
//    public static void main(String[] args) {
//        CglibPro cglibPro=new CglibPro();
//        PasswordAuthServiceImpl pass=(PasswordAuthServiceImpl) cglibPro.newProxy(new PasswordAuthServiceImpl());
//        pass.toString();
//    }
//}
