package com.zzm.thread;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @BelongsProject: leet
 * @BelongsPackage: com.zzm.thread
 * @Author: zzm
 * @CreateTime: 2024-02-25  20:56
 * @Description: TODO
 * @Version: 1.0
 */
public class MyPool {

    class MyBlockingQueue<T>{
        //1.任务队列
        private Deque<T> queue=new ArrayDeque<>();

        //2.锁来保证安全
        private ReentrantLock lock=new ReentrantLock();


        //3.生产者条件变量
        private Condition fullWaitSet=lock.newCondition();
        //4.消费者条件变量
        private Condition emptyWaitSet=lock.newCondition();
        //5.队列的容量上限
        private int capacity;

        public MyBlockingQueue(int capacity) {
            this.capacity = capacity;
        }


        //阻塞获取
        public T take(){
            lock.lock();
            try{
                while(queue.isEmpty()){
                    try {
                        //队列为空就去等待
                        emptyWaitSet.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                T t = queue.removeFirst();
                //通知生产者
                fullWaitSet.signal();
                return t;
            }finally {
                lock.unlock();
            }
        }

        //带超时阻塞获取,不回去永久等待
        public T poll(long timeout, TimeUnit unit){
            lock.lock();
            try{
                //将超时时间统一转换为纳秒
                long nanos = unit.toNanos(timeout);
                while(queue.isEmpty()){
                    try {
                        if(nanos<=0){
                            return null;
                        }
                        //队列为空就去等待,返回的是这个剩余的时间
                         nanos = emptyWaitSet.awaitNanos(nanos);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                T t = queue.removeFirst();
                //通知生产者
                fullWaitSet.signal();
                return t;
            }finally {
                lock.unlock();
            }
        }
        //阻塞添加
        public void put(T element){
            lock.lock();
            try{
                //看队列是否是满的
                while(queue.size()==capacity){
                    try{
                       fullWaitSet.await();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                queue.addLast(element);
                //通知消费者
                emptyWaitSet.signal();
            }finally {
                lock.unlock();
            }
        }
        //带超时时间的阻塞添加
        public boolean offer(T task,long timeout,TimeUnit unit){
            lock.lock();
            try{
                long nanos=unit.toNanos(timeout);
                //看队列是否是满的
                while(queue.size()==capacity){
                    if(nanos<=0){
                        return false;
                    }
                    try{
                        nanos = fullWaitSet.awaitNanos(nanos);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                queue.addLast(task);
                //通知消费者
                emptyWaitSet.signal();
            }finally {
                lock.unlock();
            }
            return true;
        }
        //获取队列大小
        public int size(){
            lock.lock();
            try{
                return queue.size();
            }finally {
                lock.unlock();
            }
        }

        public void tryPut(RejectPolicy<T> rejectPolicy, T task) {
            lock.lock();
            try{
                if(queue.size()==capacity){
                    rejectPolicy.reject(this,task);
                }else{
                    //有空间
                    queue.addLast(task);
                    emptyWaitSet.signal();
                }
            }finally {
                lock.unlock();
            }
        }
    }

    //策略模式
    @FunctionalInterface
    interface RejectPolicy<T>{
    void reject(MyBlockingQueue<T> queue,T task);
    }

    class MyThreadPool{
        //任务队列
        private MyBlockingQueue<Runnable> taskQueue;

        //线程集合，set里面如果只放thread的话包含的信息是有限的，所以给包装一下。
        private HashSet<Worker> workers=new HashSet<>();

        //核心线程数
        private int coreSize;

        //获取任务的超时时间
        private long timeout;
        //时间单位
        private TimeUnit timeUnit;

        //拒绝策略
        private RejectPolicy<Runnable> rejectPolicy;

        class Worker extends Thread {

            private Runnable task;

            public Worker(Runnable task) {
                this.task = task;
            }

            public void run() {
                //执行任务
                //1.当task不为空，直接执行任务
                //2.当task执行完毕，就从任务队列中获取任务并执行
                while (task != null|| (task = taskQueue.poll(timeout, timeUnit)) != null) {
                    try {
                        task.run();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }finally {
                        //任务执行完毕，给null
                        task=null;
                    }
                }
                synchronized (workers){
                    //任务执行完毕，从集合中移除
                    workers.remove(this);
                }

            }

        }

        public MyThreadPool(int coreSize, long timeout, TimeUnit timeUnit,int queueCapacity,RejectPolicy<Runnable> rejectPolicy) {
            this.coreSize = coreSize;
            this.timeout = timeout;
            this.timeUnit = timeUnit;
            this.taskQueue=
                    new MyBlockingQueue<>(queueCapacity);
            this.rejectPolicy=rejectPolicy;
        }

        //执行任务
        public void execute(Runnable task){
            //workers是共享变量，需要加锁保护集合安全
          synchronized (workers){
              //当任务数没有超过coreSize时，直接交给worker执行
              if(workers.size()<coreSize){
                  Worker worker = new Worker(task);
                  workers.add(worker);
                  worker.start();
              }else{
                  //如果任务数超过coreSize时，加入到任务队列中
//                  taskQueue.put(task);
                  taskQueue.tryPut(rejectPolicy,task);
              }
          }
        }
    }

    public void main(String[] args) {

        MyThreadPool pool = new MyThreadPool(1, 1, TimeUnit.SECONDS, 1, (queue, task) -> {
            //将拒绝车略下发给调用者
            //1.死等
//            queue.put(task);
            //2.超时等待
//            queue.offer(task,1500,TimeUnit.MILLISECONDS);
            //3.放弃
//            System.out.println("放弃"+task);
            //4.让调用者抛出异常，异常之后的任务不会执行
//            throw new RuntimeException("任务执行失败"+task);
            //5.让调用者自己执行任务
            task.run();
        });

    }
}
