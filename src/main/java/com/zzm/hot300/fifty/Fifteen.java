package com.zzm.hot300.fifty;



import com.zzm.structure.heap.MinHeap;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @BelongsProject: leet
 * @BelongsPackage: com.zzm.hot300
 * @Author: zzm
 * @CreateTime: 2024-01-24  14:14
 * @Description: TODO
 * @Version: 1.0
 */
//215.数组中的第K个大的元素
public class Fifteen {
    public static void main(String[] args) {
        int [] nums={2,1};
        int k=2;
//        System.out.println(findKthLargestPq(nums,k));
        System.out.println(findKthLargest(nums,k));
    }
//    public static int findKthLargest(int[] nums, int k) {
//        MinHeap heap=new MinHeap(k);
//        for (int i = 0; i < k; i++) {
//            heap.offer(nums[i]);
//        }
//
//        for (int i = k; i < nums.length; i++) {
//            if(nums[i]>heap.peek()){
//                heap.replace(nums[i]);
//            }
//        }
//        return heap.peek();
//    }

    public static int findKthLargest(int[] numbers, int k) {
        MinHeap heap = new MinHeap(k);
        for (int i = 0; i < k; i++) {
            heap.offer(numbers[i]);
        }
        for (int i = k; i < numbers.length; i++) {
            if(numbers[i] > heap.peek()){
                heap.replace(numbers[i]);
            }
        }
        return heap.peek();
    }

    public static int findKthLargestPq(int[] nums, int k) {
        //[3,2,1,5,6,4], k = 2   answer:5
        //小顶堆
        PriorityQueue<Integer> minHeap=new PriorityQueue<>(k,(a,b)->a-b);
        for (int i = 0; i < k; i++) {
            minHeap.offer(nums[i]);
        }

        for (int i = 0; i < nums.length; i++) {
            if(nums[i]>minHeap.peek()){
                //替换堆顶元素
                minHeap.poll();
                minHeap.offer(nums[i]);
            }
        }
        return minHeap.peek();
    }
}
