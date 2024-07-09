package com.zzm.thread;

import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @BelongsProject: leet
 * @BelongsPackage: com.zzm.thread
 * @Author: zzm
 * @CreateTime: 2024-02-22  18:11
 * @Description: TODO
 * @Version: 1.0
 */
public class SyncPark {
    private int loopNumber;
    private Thread[] threads;


    public SyncPark(int loopNumber) {
        this.loopNumber = loopNumber;
    }


    public void setThreads(Thread... threads) {
        this.threads = threads;
    }



    public void print(int n){
        Thread cur=Thread.currentThread();
        for (int j = 0; j < loopNumber; j++) {
            for(int i=1;i<=n;i++){
                LockSupport.park();
                //如果是第一个线程，打印1 3 5 7,如果是第二个线程，打印2 4 6 8
                if(cur.getName().equals("t1")){
                    if(i%2==1){
                        System.out.println(i);
                    }
                }else{
                    if(i%2==0){
                        System.out.println(i);
                    }
                }
                LockSupport.unpark(nextThread());
            }

        }

    }

    public Thread nextThread(){
        Thread current=Thread.currentThread();
        int index=0;
        for(int i=0;i<threads.length;i++){
            if(threads[i]==current){
                //标记当前线程
                index=i;
                break;
            }
        }
        if(index<threads.length-1){//不是最后一个线程
            return threads[index+1];
        }else{//最后一个线程,返回第一个线程
            return threads[0];
        }
    }


    public static void main(String[] args) {

        SyncPark syncPark=new SyncPark(1);
        Thread t1=new Thread(()->{
            syncPark.print(9);
        });
        t1.setName("t1");

        Thread t2=new Thread(()->{
            syncPark.print(9);
        });
        t2.setName("t2");
        syncPark.setThreads(t1,t2);
        t1.start();
        t2.start();
        LockSupport.unpark(t1);
    }

}
