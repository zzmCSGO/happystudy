package com.zzm;

import java.util.*;

/**
 * @BelongsProject: leet
 * @BelongsPackage: com.zzm
 * @Author: zzm
 * @CreateTime: 2024-03-19  15:53
 * @Description: TODO
 * @Version: 1.0
 */
public class E2 {

    public static void main(String[] args) {
        int n=5;
        List<Integer> vecInit=new ArrayList<>();
        vecInit.add(1);
        vecInit.add(-1);
        vecInit.add(-2);
        vecInit.add(-3);
        vecInit.add(1);
        vecInit.add(-1);
        vecInit.add(-2);
        vecInit.add(3);
        System.out.println(jump(n, vecInit));
    }

    public static int jump(int m, List<Integer> list){
        int n=list.size();
        int[] dp=new int[n];
        dp[0]=m;
        for(int i=1;i<n;i++){
            if(list.get(i)>0){
                dp[i]=Math.max(dp[i-1],dp[i-1]+list.get(i));
            }else{
                dp[i]=Math.max(dp[i-1],dp[i-1]+list.get(i));
                if(dp[i]<0){
                    return -1;
                }
            }
        }
        return dp[n-1];

    }









}
