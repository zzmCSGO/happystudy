package com.zzm.hot500.twenty;

/**
 * @BelongsProject: leet
 * @BelongsPackage: com.zzm.hot500.twenty
 * @Author: zzm
 * @CreateTime: 2024-02-26  21:49
 * @Description: TODO
 * @Version: 1.0
 */
//518. 零钱兑换 II
public class Eighteen {


    //index:当前硬币索引
    public int rec(int index, int[] coins, int remainder) {
        //情况1: 剩余金额<0 无解
        //情况2: 剩余金额>0 继续递归
        //情况3: 剩余金额=0 有解
        int count = 0;
        if (remainder < 0) {
//            return 0;
        } else if (remainder == 0) {
//            return 1;
            count = 1;
        } else {
            for (int i = index; i < coins.length; i++) {
                count += rec(i, coins, remainder - coins[i]);
            }
//            return count;
        }
        return count;
    }

    public static void main(String[] args) {
        Eighteen eighteen = new Eighteen();
//        int i = eighteen.rec(0, new int[]{1, 2, 5}, 5);
        //由大到小递归，效率高
//        int i = eighteen.rec(0, new int[]{5, 2, 1}, 5);
        int i = eighteen.change(5, new int[]{1, 2, 5});
        System.out.println(i);
    }

    //动态规划
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int i = 0; i < coins.length; i++) {
            for (int j = 1; j < amount + 1; j++) {
                if (j >= coins[i]) {
                    dp[j] += dp[j - coins[i]];
                } else {
                    //放不下
                    dp[j] = dp[j];
                }
            }
        }
        return dp[amount];
    }
}
