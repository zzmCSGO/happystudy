package com.zzm.hot300.forty;

import com.zzm.structure.queue.monotonic.MonotonicQueue;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: leet
 * @BelongsPackage: com.zzm.hot300
 * @Author: zzm
 * @CreateTime: 2024-01-17  16:38
 * @Description: TODO
 * @Version: 1.0
 */
//239.滑动窗口最大值

public class ThirtyNine {
    public static void main(String[] args) {
//        int [] nums={1,3,-1,-3,5,3,6,7};
        int [] nums={1,-1};
        int k=1;
        ThirtyNine thirtyNine=new ThirtyNine();
        int[] ints = thirtyNine.plus(nums, k);
        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i]+" ");
        }


    }
    //超时了，但解法是对的
    public int[] maxSlidingWindow(int[] nums, int k) {

        List<Integer> list=new ArrayList<>();
        int len=nums.length;
        for (int i = 0; i < len; i++) {
            list.add(nums[i]);
        }
        //n代表滑动窗口滑动的次数
        int n=len-k+1;
        int[] res=new int[n];
        System.out.println(res.length);
        for (int i = 0; i < n; i++) {
            int max=Integer.MIN_VALUE;
            for(int j=i;j<i+k;j++){
                max=Math.max(max,list.get(j));
            }
            res[i]=max;
        }
        return res;
    }

    //单调队列解决滑动窗口问题
    public int[] plus(int[] nums,int k){
        List<Integer> list=new ArrayList<>();
        MonotonicQueue queue=new MonotonicQueue();
        for (int i = 0; i < nums.length; i++) {
            //检查队列头部的元素，超过滑动窗口范围要移除掉。
            if(i>=k && queue.peek()==nums[i-k]){
                queue.poll();
            }
            int num=nums[i];
            queue.offer(num);
            if(i>=k-1){
                list.add(queue.peek());
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
