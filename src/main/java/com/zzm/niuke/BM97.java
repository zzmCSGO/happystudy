package com.zzm.niuke;

/**
 * @BelongsProject: leet
 * @BelongsPackage: com.zzm.niuke
 * @Author: zzm
 * @CreateTime: 2024-03-20  11:52
 * @Description: TODO
 * @Version: 1.0
 */
//翻转数组

public class BM97 {

    public int[] solve (int n, int m, int[] a) {
        // write code here
        //首先对反转的次数取余数,因为如果反转次数和原数组一样长就相当于没有反转
        m=m%n;
        //第一次反转反转整个数组
        reverse(a,0,n-1);
        //第二次反转反转开头m个
        reverse(a,0,m-1);
        //第二次反转m后面的部分
        reverse(a,m,n-1);
        return a;
    }

    //反转函数
    public void reverse(int[] nums,int start,int end){
        while(start<end){
            swap(nums,start++,end--);
        }
    }

    public void swap(int [] nums,int a,int b){
        int temp=nums[a];
        nums[a]=nums[b];
        nums[b]=temp;
    }
}
