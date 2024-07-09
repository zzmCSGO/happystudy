package com.zzm.hot100.eighty;

/**
 * @BelongsProject: leet
 * @BelongsPackage: com.zzm.hot100.eighty
 * @Author: zzm
 * @CreateTime: 2024-02-22  14:22
 * @Description: TODO
 * @Version: 1.0
 */
//73.矩阵置零
public class SeventyThree {
    public static void main(String[] args) {
        SeventyThree seventyThree = new SeventyThree();
        int[][] matrix = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        seventyThree.setZeroes(matrix);
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.print(anInt);
            }
            System.out.println();
        }
    }

    public void setZeroes(int[][] matrix) {
        int row= matrix.length;
        int col=matrix[0].length;
        boolean[][]flag=new boolean[row][col];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(matrix[i][j]==0&&flag[i][j]==false){
                    //将第i行和第j列都变成0
                    for(int k=0;k<col;k++){
                        if(matrix[i][k]!=0){
                            matrix[i][k]=0;
                            flag[i][k]=true;
                        }
                    }
                    for(int k=0;k<row;k++){
                        if(matrix[k][j]!=0){
                            matrix[k][j]=0;
                            flag[k][j]=true;
                        }
                    }
                }
            }
        }
    }

}
