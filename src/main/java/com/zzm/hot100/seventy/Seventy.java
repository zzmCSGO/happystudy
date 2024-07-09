package com.zzm.hot100.seventy;

/**
 * @BelongsProject: leet
 * @BelongsPackage: com.zzm.hot100.seventy
 * @Author: zzm
 * @CreateTime: 2024-02-19  00:16
 * @Description: TODO
 * @Version: 1.0
 */
//70.+爬楼梯
public class Seventy {
    public int climbStairs(int n) {
        int [] dp=new int[n+1];
        dp[0]=1;
        dp[1]=1;
        for(int i=2;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
}
