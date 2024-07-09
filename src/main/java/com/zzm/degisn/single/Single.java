package com.zzm.degisn.single;

import java.util.Scanner;

/**
 * @BelongsProject: leet
 * @BelongsPackage: com.zzm.degisn.single
 * @Author: zzm
 * @CreateTime: 2024-02-23  15:49
 * @Description: TODO
 * @Version: 1.0
 */
//静态内部类实现单例
public final class Single {
    private Single(){}
    // 问题1：属于懒汉式还是饿汉式   懒汉式：因为类加载本身就是懒惰的，只有当你用到的时候才会进行加载
    //如果没有用到getInstance方法，那么就不会加载LazyHolder类，也就不会创建实例
    private static class LazyHolder {
        static final Single INSTANCE = new Single();
    }
    //在创建的时候没有并发问题，类加载时静态变量的赋值是由jvm保证线程安全性。
    public static Single getInstance() {
        return LazyHolder.INSTANCE;
    }


}
