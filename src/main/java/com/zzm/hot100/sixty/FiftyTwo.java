package com.zzm.hot100.sixty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @BelongsProject: leet
 * @BelongsPackage: com.zzm.hot100.sixty
 * @Author: zzm
 * @CreateTime: 2024-01-29  14:47
 * @Description: TODO
 * @Version: 1.0
 */
//52.N皇后II
public class FiftyTwo {
    public static void main(String[] args) {
        FiftyTwo fiftyTwo = new FiftyTwo();
//        List<List<String>> lists = fiftyTwo.solveNQueens(4);
//        System.out.println(lists.size());
        Integer a=1;
        int i = fiftyTwo.totalNQueens(4);
        System.out.println(i);

    }
    public List<List<String>> solveNQueens(int n) {
        //记录列
        boolean[] col=new boolean[n];
        //记录左斜线，定位：i+j 从左上角0开始
        boolean[] left=new boolean[2*n-1];
        //记录右斜线 定位:(n-1)-(i-j) 从左下角0 开始
        boolean[] right=new boolean[2*n-1];
        //数组
        char[][] tables=new char[n][n];
        //初始化表格
        for(char[] table:tables){
            Arrays.fill(table,'.');
        }
        List<List<String>> res = new ArrayList<>();
        dfs(0,n,tables,col,left,right,res);
        return res;

    }

    public void dfs(int i,int n,char[][]tables,boolean[] col,boolean[] left,boolean[] right,List<List<String>> res){
        //找到了就返回
        if(i==n){
            List<String> temp = new ArrayList<>();
            //遍历到第四行了
            for(char[]table:tables){
                temp.add(new String(table));
            }
            res.add(new ArrayList<>(temp));
        }
        for(int j=0;j<n;j++){
            //判断是否冲突
            if(col[j]||left[i+j]||right[(n-1)-(i-j)]){
                continue;
            }
            tables[i][j]='Q';
            col[j]=left[i+j]=right[(n-1)-(i-j)]=true;
            dfs(i+1,n,tables,col,left,right,res);
            tables[i][j]='.';
            col[j]=left[i+j]=right[(n-1)-(i-j)]=false;
        }
    }


    public int totalNQueens(int n) {
        boolean[] col=new boolean[n];
        boolean[] left=new boolean[2*n-1];
        boolean[] right=new boolean[2*n-1];
        char[][] table=new char[n][n];
        for(char[] t:table){
            Arrays.fill(t,'.');
        }
        AtomicInteger res=new AtomicInteger(0);
        dfs(res,n,0,table,col,left,right);
        return res.intValue();
    }

    public void dfs(AtomicInteger res,int n, int i,char[][]table,boolean[] col,boolean[] left,boolean[] right){
        if(n==i){
            res.getAndAdd(1);
            return;
        }
        for(int j=0;j<n;j++){
            if(col[j]||left[i+j]||right[n-1-(i-j)]){
                continue;
            }
            col[j]=left[i+j]=right[n-1-(i-j)]=true;
            table[i][j]='Q';
            dfs(res,n,i+1,table,col,left,right);
            table[i][j]='.';
            col[j]=left[i+j]=right[n-1-(i-j)]=false;
        }

    }
}
