package com.zzm.hot100.seventy;

/**
 * @BelongsProject: leet
 * @BelongsPackage: com.zzm.hot100.seventy
 * @Author: zzm
 * @CreateTime: 2024-01-30  13:44
 * @Description: TODO
 * @Version: 1.0
 */
//62. 不同路径
public class SixtyTwo {
    public static void main(String[] args) {
        System.out.println(uniquePaths(3, 7));

    }

    public static int uniquePaths(int m, int n) {
        //首先创建一个m行n列数组
        int[][] table=new int[m][n];
        //给数组进行赋初值
        for(int i=0;i<m;i++){
            table[i][0]=1;
        }
        for(int i=0;i<n;i++){
            table[0][i]=1;
        }

        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                table[i][j]=table[i-1][j]+table[i][j-1];
            }
        }
        return table[m-1][n-1];
    }
}
