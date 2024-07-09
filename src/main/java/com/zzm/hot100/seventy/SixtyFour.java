package com.zzm.hot100.seventy;

/**
 * @BelongsProject: leet
 * @BelongsPackage: com.zzm.hot100.seventy
 * @Author: zzm
 * @CreateTime: 2024-02-21  15:03
 * @Description: TODO
 * @Version: 1.0
 */
public class SixtyFour {
    public static void main(String[] args) {
        SixtyFour sixtyFour = new SixtyFour();
        int i = sixtyFour.minPathSum(new int[][]{{1, 2, 3}, {4, 5, 6}});
        System.out.println(i);
    }
    public int minPathSum(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int [][]dp=new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0]=grid[i][0];
            if(i>0){
                dp[i][0]+=dp[i-1][0];
            }
        }
        for(int i=0;i<n;i++){
            dp[0][i]=grid[0][i];
            if(i>0){
                dp[0][i]+=dp[0][i-1];
            }
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                dp[i][j]=Math.min(dp[i-1][j],dp[i][j-1])+grid[i][j];
            }
        }
        return dp[m-1][n-1];
    }
}
