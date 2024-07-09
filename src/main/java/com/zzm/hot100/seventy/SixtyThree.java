package com.zzm.hot100.seventy;

/**
 * @BelongsProject: leet
 * @BelongsPackage: com.zzm.hot100.seventy
 * @Author: zzm
 * @CreateTime: 2024-02-20  13:52
 * @Description: TODO
 * @Version: 1.0
 */
//63.不同路径 II
public class SixtyThree {
    public static void main(String[] args) {
        SixtyThree sixtyThree = new SixtyThree();
//        int i = sixtyThree.uniquePathsWithObstacles(new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}});
        int i = sixtyThree.uniquePathsWithObstacles(new int[][]{{1},{0}});
        System.out.println(i);
    }

    public int uniquePathsWithObstacles2(int[][] obstacleGrid) {

        boolean [][] flag=new boolean[obstacleGrid.length][obstacleGrid[0].length];//标记是否可以到达
        for(int i=0;i<obstacleGrid.length;i++){
            for(int j=0;j<obstacleGrid[i].length;j++){
                if(obstacleGrid[i][j]==1){
                    flag[i][j]=false;
                }else{
                    flag[i][j]=true;
                }
            }
        }
        //当数组只有一行/一列的时候，如果存在障碍则结果为0，否则为1
        if(obstacleGrid.length==1){
            for(int i=0;i<obstacleGrid[0].length;i++){
                if(!flag[0][i]){
                    return 0;
                }
            }
            return 1;
        }
        if(obstacleGrid[0].length==1){
            for(int i=0;i<obstacleGrid.length;i++){
                if(!flag[i][0]){
                    return 0;
                }
            }
            return 1;
        }
        if(!flag[0][0]){
            return 0;
        }
        int [][]dp=new int[obstacleGrid.length][obstacleGrid[0].length];
        for(int i=0;i<obstacleGrid.length;i++){
            if(flag[i][0]){
                dp[i][0]=1;
            }
        }
        for(int i=0;i<obstacleGrid[0].length;i++){
            if(flag[0][i]){
                dp[0][i]=1;
            }
        }
        for(int i=1;i<obstacleGrid.length;i++){
            for(int j=1;j<obstacleGrid[i].length;j++){
                if(flag[i][j]){
                    dp[i][j]=dp[i-1][j]+dp[i][j-1];
                }
            }
        }
        return dp[obstacleGrid.length-1][obstacleGrid[0].length-1];
    }

//    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
//        int n = obstacleGrid.length, m = obstacleGrid[0].length;
//        int[] f = new int[m];
//
//        f[0] = obstacleGrid[0][0] == 0 ? 1 : 0;
//        for (int i = 0; i < n; ++i) {
//            for (int j = 0; j < m; ++j) {
//                if (obstacleGrid[i][j] == 1) {
//                    f[j] = 0;
//                    continue;
//                }
//                if (j - 1 >= 0 && obstacleGrid[i][j - 1] == 0) {
//                    f[j] += f[j - 1];
//                }
//            }
//        }
//
//        return f[m - 1];
//    }
      public int uniquePathsWithObstacles(int[][] obstacleGrid) {
             int row=obstacleGrid.length;
             int col=obstacleGrid[0].length;
             int [] res=new int [col];
             res[0]=obstacleGrid[0][0]==1?0:1;
             for(int i=0;i<row;++i){
                 for(int j=0;j<col;++j){
                     if(obstacleGrid[i][j]==1){
                         res[j]=0;
                         continue;
                     }
                     if(j-1>=0&&obstacleGrid[i][j-1]==0){
                         res[j]+=res[j-1];
                     }
                 }
             }
             return res[col-1];
     }

}
