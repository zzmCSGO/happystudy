package com.zzm.juc.lock;

import com.zzm.juc.aqs.MySync;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @BelongsProject: leet
 * @BelongsPackage: com.zzm.juc.lock
 * @Author: zzm
 * @CreateTime: 2024-02-25  14:22
 * @Description: TODO
 * @Version: 1.0
 */
//自定义锁，不可重入
public class MyLock implements Lock {

    private MySync mySync=new MySync();
    //加锁,不成功进入等待队列
    @Override
    public void lock() {
        //加锁不成功会进入等待队列
        mySync.acquire(1);
    }

    //加锁，可以打断，syncronized不可以打断更容易造成死锁
    @Override
    public void lockInterruptibly() throws InterruptedException {
        mySync.acquireInterruptibly(1);
    }

    //尝试加锁，不会继续死等
    @Override
    public boolean tryLock() {
        return mySync.tryAcquire(1);
    }

    //尝试加锁，实现超时
    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return mySync.tryAcquireNanos(1,unit.toNanos(time));
    }

    //解锁
    @Override
    public void unlock() {
        mySync.release(1);
    }

    //创建条件变量
    @Override
    public Condition newCondition() {
        return mySync.Condition();
    }
}
