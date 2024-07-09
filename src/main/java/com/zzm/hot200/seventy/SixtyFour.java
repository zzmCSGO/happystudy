package com.zzm.hot200.seventy;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @BelongsProject: leet
 * @BelongsPackage: com.zzm.hot200.seventy
 * @Author: zzm
 * @CreateTime: 2024-01-30  11:31
 * @Description: TODO
 * @Version: 1.0
 */
//164. 最大间距
public class SixtyFour {
    public static void main(String[] args) {

    }

    public int maximumGap(int[] nums) {
        if(nums.length<2){
            return 0;
        }
        int max=nums[0];
        for(int i=1;i<nums.length;i++){
            max=Math.max(max,nums[i]);
        }
        //准备桶
        ArrayList<Integer>[] buckets=new ArrayList[10];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<>();
        }

        int m=1;
        while(m<=max){
             //一轮基数排序
             for(int i:nums){
                 buckets[i/m%10].add(i);
             }
             int k=0;
             for(ArrayList<Integer> bucket:buckets){
                 for(Integer i:bucket){
                     nums[k++]=i;
                 }
                 bucket.clear();
             }
             m=m*10;
         }
         int res=0;
         for(int i=1;i<nums.length;i++){
             res=Math.max(res,nums[i]-nums[i-1]);
         }
         return res;
    }

    public int maximumGap2(int[] a) {
        if (a.length < 2) {
            return 0;
        }

        // 计算最大值
        int max = a[0];
        for (int i = 1; i < a.length; i++) {
            max = Math.max(a[i], max);
        }

        // 准备10个桶
        ArrayList<Integer>[] buckets = new ArrayList[10];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<>();
        }

        // 没超过最大值
        long exp = 1;
        while (max >= exp) {
            for (int j : a) {
                buckets[(j / (int) exp) % 10].add(j);
            }
            int k = 0;
            for (ArrayList<Integer> bucket : buckets) {
                for (Integer i : bucket) {
                    a[k++] = i;
                }
                bucket.clear();
            }
            exp *= 10;
        }

        // 求最大间距
        int r = 0;
        for (int i = 1; i < a.length; i++) {
            r = Math.max(r, a[i] - a[i - 1]);
        }
        return r;
    }

}
