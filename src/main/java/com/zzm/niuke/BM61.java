package com.zzm.niuke;

import java.util.Arrays;

/**
 * @BelongsProject: leet
 * @BelongsPackage: com.zzm.niuke
 * @Author: zzm
 * @CreateTime: 2024-03-19  11:03
 * @Description: TODO
 * @Version: 1.0
 */
//矩阵最长递增路径
public class BM61 {
    public static void main(String[] args) {
        int[][] matrix = {{9, 9, 4}, {6, 6, 8}, {2, 1, 1}};
        //994
        //668
        //221
        System.out.println(longestIncreasingPath(matrix));
    }

    public static int longestIncreasingPath(int[][] matrix) {
        // write code here
        int m = matrix.length;//行
        int n = matrix[0].length;//列
        if (n < 1 || m < 1) {
            return 0;
        }
        int res = Integer.MIN_VALUE;
        int[][] dp = new int[m][n];
        //初始化记忆数组为0
        for (int[] line : dp) {
            Arrays.fill(line, 0);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //从某一个点出发，能到达的最大长度为多少
                res = Math.max(res, dfs(matrix, dp, i, j, Integer.MIN_VALUE));
            }
        }
        return res;

    }

    public static int dfs(int[][] matrix, int[][] dp, int i, int j, int last) {
        //不合法，直接返回
        if (!isValid(matrix, i, j)) {
            return 0;
        }
        //如果当前的值小于上一个值，直接返回
        if (matrix[i][j] <= last) {
            return 0;
        }
        //如果当前数组的元素已经被记录过了
        if (dp[i][j] != 0) {
            return dp[i][j];
        }
        //否则的话就是第一次搜索
        dp[i][j] = 1;
        //上下左右搜索
        int up = dfs(matrix, dp, i - 1, j, matrix[i][j]);
        int down = dfs(matrix, dp, i + 1, j, matrix[i][j]);
        int left = dfs(matrix, dp, i, j - 1, matrix[i][j]);
        int right = dfs(matrix, dp, i, j + 1, matrix[i][j]);
        //取最大值，取四边里面最大的再加上自己
        dp[i][j] = Math.max(dp[i][j], Math.max(Math.max(up, down), Math.max(left, right))+1) ;
        return dp[i][j];

    }


    public static boolean isValid(int[][] matrix, int i, int j) {
        return i >= 0 && i < matrix.length && j >= 0 && j < matrix[0].length;
    }


}
