package com.zzm.cz.meituan.first;

import java.util.Scanner;

/**
 * @BelongsProject: leet
 * @BelongsPackage: com.zzm.meituan
 * @Author: zzm
 * @CreateTime: 2024-03-09  11:30
 * @Description: TODO
 * @Version: 1.0
 */
public class Exam4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n=in.nextInt();
        int k=in.nextInt();
        long[]arr=new long[n];
        for(int i=0;i<n;i++){
            arr[i]=in.nextLong();
        }


        long[][] fc=new long[n][2];
        for(int i=0;i<n;i++){
            fc[i]=countFactors(arr[i]);
        }


        long result=0;
        long[][] ps=new long[n+1][2];
        for(int i=1;i<=n;i++){
            ps[i][0]=ps[i-1][0]+fc[i-1][0];
            ps[i][1]=ps[i-1][1]+fc[i-1][1];
        }

        for(int i=0;i<n;i++){
            for(int j=i+1;j<=n;j++){
                long zero2=ps[n][0]-(ps[j][0]-ps[i][0]);
                long zero5=ps[n][1]-(ps[j][1]-ps[i][1]);
                if(Math.min(zero2,zero5)>=k){
                    result++;
                }
            }
        }
        System.out.println(result);
    }

    private static long[] countFactors(long number){
        long[] counts=new long[2];
        while(number%2==0){
            counts[0]++;
            number/=2;
        }
        while(number%5==0){
            counts[1]++;
            number/=5;
        }
        return counts;
    }
}
