package com.zzm.hot700;

/**
 * @BelongsProject: leet
 * @BelongsPackage: com.zzm.hot700
 * @Author: zzm
 * @CreateTime: 2024-03-02  15:23
 * @Description: TODO
 * @Version: 1.0
 */
//岛屿的最大面积 dfs
public class NinetyFive {

    public static void main(String[] args) {

    }

    public int maxAreaOfIsland(int[][] grid) {
        int i=grid.length;
        int j=grid[0].length;
        int res=0;
        for(int row=0;row<i;row++) {
            for (int col = 0; col < j; col++) {
                if(grid[row][col]==1){
                    //修改岛屿周围的状态
                    res=Math.max(res,dfs(grid,row,col));
                }
            }
        }
        return res;

    }

    public int dfs(int [][] grid,int r,int c){
        //判断格子，如果超出网格范围，直接返回
        if(!inArea(grid,r,c)){
            return 0 ;
        }
        //为了避免重复遍历，标记一下
        if(grid[r][c]!=1){
            return 0;
        }
        grid[r][c]='2';//遍历过了
        return 1+ dfs(grid,r-1,c)
        +dfs(grid,r+1,c)
        +dfs(grid,r,c-1)
        +dfs(grid,r,c+1);
    }

    //判断坐标(r,c)是否在网格中
    private boolean inArea(int[][] grid, int r, int c) {
        return 0<=r&&r< grid.length
                &&0<=c&&c<grid[0].length;
    }
}
