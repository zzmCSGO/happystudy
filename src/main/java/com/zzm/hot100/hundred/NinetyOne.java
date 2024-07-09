package com.zzm.hot100.hundred;

import java.util.LinkedList;

/**
 * @BelongsProject: leet
 * @BelongsPackage: com.zzm.hot100.hundred
 * @Author: zzm
 * @CreateTime: 2024-02-21  17:43
 * @Description: TODO
 * @Version: 1.0
 */
//91.解码方法
public class NinetyOne {
    public int numDecodings(String s) {
        int len = s.length();
        int[] dp = new int[len + 1];
        dp[0] = 1;
        //"1221"
        for (int i = 1; i <= len; i++) {
            if (s.charAt(i - 1) != '0') {
                dp[i] += dp[i - 1];//dp[1]=1 dp[3]=dp[3]+dp[2]=2
            }
            if (i > 1) {
                int num = (s.charAt(i - 2) - '0') * 10 + (s.charAt(i - 1) - '0');
                //确定s.charAt(i-2)不为0
                if (num >= 10 && num <= 26) {
                    dp[i] += dp[i - 2]; //dp[2]=dp[2]+dp[0]; dp[3]=dp[3]+dp[1]=3
                }
            }
        }
        return dp[len];
    }
}
