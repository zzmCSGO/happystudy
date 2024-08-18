package com.zzm.hot100.hundred;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @BelongsProject: leet
 * @BelongsPackage: com.zzm.hot100
 * @Author: zzm
 * @CreateTime: 2024-01-23  20:57
 * @Description: TODO
 * @Version: 1.0
 */
//96.不同的二叉搜索树
public class NinetySix {

    /*
        * 解题思路
    标签：动态规划
    假设 n 个节点存在二叉排序树的个数是 G (n)，令 f(i) 为以 i 为根的二叉搜索树的个数，则
    G(n)=f(1)+f(2)+f(3)+f(4)+...+f(n)

    当 i 为根节点时，其左子树节点个数为 i-1 个，右子树节点为 n-i，则
    f(i)=G(i−1)∗G(n−i)

    综合两个公式可以得到 卡特兰数 公式
    G(n)=G(0)∗G(n−1)+G(1)∗(n−2)+...+G(n−1)∗G(0)
    */
    public static void main(String[] args) {

        String a="hello nowcoder";
        String [] b = a.split(" ");
        System.out.println(b[b.length-1].length());


    }

    public int numTrees(int n) {
        long c=1;
        for (int i = 0; i < n; i++) {
            c=c*2*(i*2+1)/(i+2);
        }
        return (int)c;

    }

    class Solution {
        public int numTrees(int n) {

            //G(i) = f(1) + f(2) + .. + f(i)
            //f(i) = G(i - 1) * G(n - i)
            int[] dp = new int[n + 1];
            dp[0] = 1;
            dp[1] = 1;
            //外层循环 i 代表当前计算的卡特兰数是 G（i)，因为卡特兰数的计算需要用到前面的值，而前面的值也需要算出。
            for (int i = 2; i < n + 1; i++) {
                //内层是G(I)所有可能子问题的和。
                for (int j = 1; j < i + 1; j++) {
                    dp[i] += dp[i - j] * dp[j - 1];
                }
            }
            return dp[n];
        }
    }
}