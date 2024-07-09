package com.zzm.juc.syn;

import lombok.extern.slf4j.Slf4j;
import org.openjdk.jol.info.ClassLayout;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;

/**
 * @BelongsProject: happystudy
 * @BelongsPackage: com.zzm.juc.syn
 * @Author: zzm
 * @CreateTime: 2024-03-25  16:06
 * @Description: TODO
 * @Version: 1.0
 */
@Slf4j(topic = "c.TestLight")
public class TestLight {


    static final Object obj = new Object();

    static class Mythread {
        static Thread[] threads;

        public static void setThreads(Thread... t) {
            threads = t;
        }

        //获得到当前线程的下一个线程
        public static Thread getNextThread(Thread t) {
            for (int i = 0; i < threads.length; i++) {
                if (threads[i] == t) {
                    return threads[(i + 1) % threads.length];
                }
            }
            return null;
        }


        public static void print(int n) {
            log.debug("对象头" + ClassLayout.parseInstance(obj).toPrintable());
            for (int i = 0; i < 5; i++) {
                LockSupport.park();
                System.out.println(Thread.currentThread().getName());
                LockSupport.unpark(getNextThread(Thread.currentThread()));
            }
        }

        public static void start(){
            for (Thread t:threads){
                t.start();
            }
        }
    }

    static class SyncWaitNotify {
        private int flag;
        private int loopNumber;

        static final Object lock = new Object();

        public SyncWaitNotify(int flag, int loopNumber) {
            this.flag = flag;
            this.loopNumber = loopNumber;
        }

        public void print(int waitFlag, int nextFlag, String str) {
            for (int i = 0; i < loopNumber; i++) {
                log.debug("对象头" + ClassLayout.parseInstance(lock).toPrintable());
                synchronized (lock) {
                    while (this.flag != waitFlag) {
                        try {
                            this.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.print(str);
                    flag = nextFlag;
                    this.notifyAll();
                }
            }
        }
    }

    public static void main(String[] args) {
//        Thread t1= new Thread(() -> {
//            Mythread.print(1);
//        }, "t1");
//        Thread t2 = new Thread(() -> {
//            Mythread.print(2);
//        }, "t2");
//        Thread t3 = new Thread(() -> {
//            Mythread.print(3);
//        }, "t3");
//        Mythread.setThreads(t1, t2, t3);
//        Mythread.start();
//        LockSupport.unpark(t1);
        SyncWaitNotify syncWaitNotify = new SyncWaitNotify(1, 3);
        new Thread(() -> {
            syncWaitNotify.print(1, 2, "a");
        }).start();
        new Thread(() -> {
            syncWaitNotify.print(2, 3, "b");
        }).start();
        new Thread(() -> {
            syncWaitNotify.print(3, 1, "c");
        }).start();
    }

}




