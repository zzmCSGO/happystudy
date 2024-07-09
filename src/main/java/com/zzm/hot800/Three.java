package com.zzm.hot800;



import java.util.PriorityQueue;

/**
 * @BelongsProject: leet
 * @BelongsPackage: com.zzm.hot800
 * @Author: zzm
 * @CreateTime: 2024-01-24  14:56
 * @Description: TODO
 * @Version: 1.0
 */
//703.数据流中的第K大元素 用堆实现
public class Three {
    private PriorityQueue<Integer> minHeap;

    public static void main(String[] args) {

    }
    public Three(int k, int[] nums) {
        minHeap=new PriorityQueue<>(k,(a,b)->a-b);
//       minHeap=new MinHeap(k);
       for(int num:nums){

           add(num);
       }
    }

    public int add(int val) {
        if(minHeap.isEmpty()){
            minHeap.offer(val);
        }
        //先拿到堆顶元素
        if(val>minHeap.peek()){
            minHeap.poll();
            minHeap.offer(val);
        }
        return minHeap.peek();
    }

}
