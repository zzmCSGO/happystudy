package com.zzm.structure.queue.monotonic;

import java.util.LinkedList;

/**
 * @BelongsProject: leet
 * @BelongsPackage: com.zzm
 * @Author: zzm
 * @CreateTime: 2024-01-17  17:37
 * @Description: TODO
 * @Version: 1.0
 */
//单调队列
public class MonotonicQueue {
    private LinkedList<Integer> queue = new LinkedList<>();

    public Integer peek(){
        return queue.peekFirst();
    }

    public void poll(){
        queue.pollFirst();
    }
    //6,5,4,3,2,1
    public void offer(Integer t){
        while(!queue.isEmpty() && queue.peekLast() < t){
            //如果队列不为空，且队列尾部元素小于t，那么就把队列尾部元素移除
            queue.pollLast();
        }
        //把t加入到队列尾部
        queue.offerLast(t);
    }

    @Override
    public String toString() {
        return queue.toString();
    }

    public static void main(String[] args) {
        MonotonicQueue q=new MonotonicQueue();
        for (int i :new int[]{1,3,4,3,2,1}) {
            q.offer(i);
            System.out.println(q);
        }

    }
}
