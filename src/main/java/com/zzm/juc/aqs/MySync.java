package com.zzm.juc.aqs;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;

/**
 * @BelongsProject: leet
 * @BelongsPackage: com.zzm.juc.aqs
 * @Author: zzm
 * @CreateTime: 2024-02-25  14:21
 * @Description: TODO
 * @Version: 1.0
 */
//自定义同步器类
public class MySync extends AbstractQueuedSynchronizer {

    //独占锁
    @Override
    public boolean tryAcquire(int arg) {
        //从0尝试变成1，cas
        if(compareAndSetState(0,1)){
            //加上锁了,并设置当前owner线程为独占线程
            setExclusiveOwnerThread(Thread.currentThread());
        }
        return false;
    }

    @Override
    public boolean tryRelease(int arg) {
        //没有其他线程能与自己竞争
        setExclusiveOwnerThread(null);
        setState(0);//state是volatile，后面会加写屏障的，保证不会重排序，保证在它之前的操作对其他线程是可见的
        return true;
    }

    //是否持有独占锁
    @Override
    public boolean isHeldExclusively() {
        return getState()==1;
    }

    public Condition  Condition(){
        return new ConditionObject();
    }
}
