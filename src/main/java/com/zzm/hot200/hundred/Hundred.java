package com.zzm.hot200.hundred;

/**
 * @BelongsProject: leet
 * @BelongsPackage: com.zzm.hot200.hundred
 * @Author: zzm
 * @CreateTime: 2024-03-02  14:46
 * @Description: TODO
 * @Version: 1.0
 */
//200岛屿数量 ：dfs
public class Hundred {

    public static void main(String[] args) {
        char[][] ch = {
            {'1','1','0','0','0'},
            {'0','1','0','1','1'},
            {'0','0','0','1','1'},
            {'0','0','0','0','0'},
            {'0','0','1','1','1'}
        };
        Hundred h=new Hundred();
        int i = h.numIslands(ch);
        System.out.println(i);
    }

    public int numIslands(char[][] grid) {
        int i=grid.length;
        int j=grid[0].length;
        int res=0;
        for(int row=0;row<i;row++) {
            for (int col = 0; col < j; col++) {
                if(grid[row][col]=='1'){
                    res+=1;
                    //修改岛屿周围的状态
                    dfs(grid,row,col);
                }
            }
        }
        return res;
    }

    public void dfs(char[][] grid,int r,int c){
        //判断格子，如果超出网格范围，直接返回
        if(!inArea(grid,r,c)){
            return ;
        }
        //为了避免重复遍历，标记一下
        if(grid[r][c]!='1'){
            return ;
        }
        grid[r][c]='2';//遍历过了
        dfs(grid,r-1,c);
        dfs(grid,r+1,c);
        dfs(grid,r,c-1);
        dfs(grid,r,c+1);
    }

    //判断坐标(r,c)是否在网格中
    private boolean inArea(char[][] grid, int r, int c) {
        return 0<=r&&r< grid.length
                &&0<=c&&c<grid[0].length;
    }
}
