package com.zzm.structure.queue.blockingqueue;

public interface BlockingQueue <E>{

    void offer(E e) throws InterruptedException;

    E poll() throws InterruptedException;


}
