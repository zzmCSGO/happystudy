package com.zzm.juc.exercise;

import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.locks.LockSupport;

/**
 * @BelongsProject: leet
 * @BelongsPackage: com.zzm.juc.exercise
 * @Author: zzm
 * @CreateTime: 2024-03-21  13:46
 * @Description: TODO
 * @Version: 1.0
 */
public class Circle {
    //编写三个线程，循环打印1，2，3
    static class MyThread{

        Thread[] threads;



        int member;

        public MyThread(){

        }

        public void set(Thread... t){
            threads=t;
        }

        public void print(int n){
            Thread cur=Thread.currentThread();
            for(int i=0;i<5;i++){
                LockSupport.park();
                System.out.println(n);
                LockSupport.unpark(getNextThread(cur));
            }
        }

        //获取当前线程的下一个线程
        public Thread getNextThread(Thread t){
            for(int i=0;i<threads.length;i++){
                if(threads[i]==t){
                    return threads[(i+1)%threads.length];
                }
            }
            return null;
        }
    }


    public static void main(String[] args) {
        MyThread myThread=new MyThread();
        Thread t1=new Thread(()->{
           myThread.print(1);
        });
        Thread t2=new Thread(()->{
            myThread.print(2);
        });
        Thread t3=new Thread(()->{
            myThread.print(3);
        });
        myThread.set(t1,t2,t3);
        t1.start();
        t2.start();
        t3.start();
        LockSupport.unpark(t1);

    }

}
