package com.zzm.hot100.sixty;

/**
 * @BelongsProject: leet
 * @BelongsPackage: com.zzm.hot100.sixty
 * @Author: zzm
 * @CreateTime: 2024-02-20  13:26
 * @Description: TODO
 * @Version: 1.0
 */
//59. 螺旋矩阵 II
public class FiftyNine {
    public static void main(String[] args) {
        FiftyNine fiftyNine = new FiftyNine();
        int[][] ints = fiftyNine.generateMatrix(3);
        System.out.println(ints);
    }
    public int[][] generateMatrix(int n) {
        int[][]res=new int[n][n];
        int top=0,bottom=n-1,left=0,right=n-1;
        int num=1;
        while(true){
            for(int i=left;i<=right;i++){
                res[top][i]=num++;
            }
            if(++top>bottom){
                break;
            }
            for(int i=top;i<=bottom;i++){
                res[i][right]=num++;
            }
            if(--right<left){
                break;
            }
            for(int i=right;i>=left;i--){
                res[bottom][i]=num++;
            }
            if(--bottom<top){
                break;
            }
            for(int i=bottom;i>=top;i--){
                res[i][left]=num++;
            }
            if(++left>right){
                break;
            }
        }
        return res;
    }
}
