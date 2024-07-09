package com.zzm.hot100.sixty;

import java.util.Arrays;
import java.util.List;

/**
 * @BelongsProject: leet
 * @BelongsPackage: com.zzm.hot100.sixty
 * @Author: zzm
 * @CreateTime: 2024-01-29  14:14
 * @Description: TODO
 * @Version: 1.0
 */
//51.N皇后
public class FiftyOne {
    public static void main(String[] args) {
        FiftyOne fiftyOne = new FiftyOne();
        fiftyOne.solveNQueens(8);

    }

    public List<List<String>> solveNQueens(int n) {
        boolean[] ca=new boolean[n];//记录列冲突
        //true false false false
        boolean[] cb=new boolean[2*n-1];//记录左斜线冲突
        //i+j
        boolean[] cc=new boolean[2*n-1];//记录右斜线冲突
        //n-1-(i-j)
        char[][] table=new char[n][n];//棋盘
        for(char[] t:table){
            Arrays.fill(t,'.');
        }
        dfs(0,n,table,ca,cb,cc);
//        for(char[] t:table){
//            System.out.println(Arrays.toString(t));
//        }
        return null;
    }

    static void dfs(int i,int n,char[][] table,
                    boolean[] ca,boolean[] cb,boolean[] cc){
        if(i==n){
            //找到一个解
            System.out.println("---------------");
            for(char[] t:table){
                System.out.println(Arrays.toString(t));
            }
            return ;
        }
        //尝试在第i行的每一个位置(每一列)放置皇后
        for(int j=0;j<n;j++){
            if(ca[j]||cb[i+j]||cc[n-1-(i-j)]){
                //如果冲突，跳过该位置
                continue;
            }
            table[i][j]='Q';
            ca[j]=true;
            //左斜线
            cb[i+j]=true;
            //右斜线
            cc[n-1-(i-j)]=true;
            //再尝试往第i+1行放入皇后
            dfs(i+1,n,table,ca,cb,cc);
            //回溯
            table[i][j]='.';
            ca[j]=false;
            //左斜线
            cb[i+j]=false;
            //右斜线
            cc[n-1-(i-j)]=false;
        }

    }
}
