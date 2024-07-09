package com.zzm.cz.meituan.second;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @BelongsProject: leet
 * @BelongsPackage: com.zzm.meituan.second
 * @Author: zzm
 * @CreateTime: 2024-03-16  18:33
 * @Description: TODO
 * @Version: 1.0
 */
public class Exam3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();//数组的大小
        int q=sc.nextInt();//操作的次数
        int num[]=new int[n];
        for(int i=0;i<n;i++){
            num[i]=sc.nextInt();
        }

        int[] ops=new int[n];
        Arrays.fill(ops,q);

        for(int i=0;i<q;i++){
            int index=sc.nextInt()-1;
            ops[index]--;
        }

        long res=0;
        long mod=1000000007;

        for(int i=0;i<n;i++){
            //*
            res=(res+num[i]*pow(2,ops[i],mod))%mod;
        }
        System.out.println(res);
    }

    private static long pow(long num,int n,long mod){
        long res=1;
        num=num%mod;
        while(n>0){
            if(n%2==1){
                res=(res*num)%mod;
            }
            num=(num*num)%mod;
            n=n/2;
        }
        return res;
    }
}
