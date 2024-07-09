package com.zzm.cz.meituan.second;

import java.util.Scanner;

/**
 * @BelongsProject: leet
 * @BelongsPackage: com.zzm.meituan.second
 * @Author: zzm
 * @CreateTime: 2024-03-16  18:33
 * @Description: TODO
 * @Version: 1.0
 */
public class Exam4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int n=in.nextInt();//数组的大小
        int[] nums=new int[n];
        for(int i=0;i<n;i++){
            nums[i]=in.nextInt()-1;
        }
        //前缀和
        int[] preSum=new int[n+1];
        preSum[0]=0;
        for(int i=1;i<n+1;i++){
            preSum[i]=preSum[i-1]+nums[i-1];
        }

        int res=0;
        for(int i=1;i<=n;i++){
            for(int j=0;j<n-i+1;j++){
                //这里是i
                int total=i;
                int twoNum=preSum[j+i]-preSum[j];
                if(twoNum>total-twoNum){
                    res+=2;
                }else{
                    res+=1;
                }
            }
        }
        System.out.println(res);

    }
}
