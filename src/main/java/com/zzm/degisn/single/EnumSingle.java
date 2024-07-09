package com.zzm.degisn.single;

/**
 * @BelongsProject: leet
 * @BelongsPackage: com.zzm.degisn.single
 * @Author: zzm
 * @CreateTime: 2024-02-23  15:48
 * @Description: TODO
 * @Version: 1.0
 */
//枚举单例
enum EnumSingle {
    //1.枚举单例是如何实现实例个数的？  定义的时候有几个，到时候就有几个instance
    //2.枚举单例在创建时是否有并发问题？ 没有。类加载时就创建了
    //3.枚举单例是否可以被反射破坏？  不能
    //4.枚举单例是否可以被序列化破坏？  实现序列化接口，不会被破坏
    //5.枚举单例属于饿汉式还是懒汉式 饿汉式
    //6.枚举单例如果希望加入一些单例创建时的初始化逻辑应该如何做？ 枚举类中定义构造方法
    INSTANCE;
}
