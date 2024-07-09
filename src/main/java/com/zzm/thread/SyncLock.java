package com.zzm.thread;

import java.util.concurrent.atomic.LongAdder;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @BelongsProject: leet
 * @BelongsPackage: com.zzm.thread
 * @Author: zzm
 * @CreateTime: 2024-02-22  19:46
 * @Description: TODO
 * @Version: 1.0
 */
public class SyncLock {

    public static void main(String[] args) {
        AwaitSignal as = new AwaitSignal(5);
        Condition aWaitSet = as.newCondition();
        Condition bWaitSet = as.newCondition();
        Condition cWaitSet = as.newCondition();
        new Thread(() -> {
            as.print("a", aWaitSet, bWaitSet);
        }).start();
        new Thread(() -> {
            as.print("b", bWaitSet, cWaitSet);
        }).start();
        new Thread(() -> {
            as.print("c", cWaitSet, aWaitSet);
        }).start();
        as.start(aWaitSet);

    }
    static class AwaitSignal extends ReentrantLock {
        public void start(Condition first) {
            this.lock();
            try {
                first.signal();
            } finally {
                this.unlock();
            }
        }
        public void print(String str, Condition current, Condition next) {
            for (int i = 0; i < loopNumber; i++) {
                this.lock();
                try {
                    current.await();
                    next.signal();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    this.unlock();
                }
            }
        }
        // 循环次数
        private int loopNumber;
        public AwaitSignal(int loopNumber) {
            this.loopNumber = loopNumber;
        }

    }
}
