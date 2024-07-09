package com.zzm.niuke;

import java.util.ArrayList;

/**
 * @BelongsProject: leet
 * @BelongsPackage: com.zzm.niuke
 * @Author: zzm
 * @CreateTime: 2024-03-19  10:05
 * @Description: TODO
 * @Version: 1.0
 */
//括号生成
public class BM60 {
    public static void main(String[] args) {
        System.out.println(generateParenthesis(2));
    }
    public static ArrayList<String> generateParenthesis (int n) {
        // write code here
        //() ()  ()
        ArrayList<String> res=new ArrayList<>();
        StringBuilder sb=new StringBuilder();
        dfs(res,n,sb,0);
        return res;

    }

    public static void dfs(ArrayList<String> res, int n, StringBuilder sb, int k){
        //(()())
        if(k>=n){
            if(k==n){
                res.add(new String(sb.toString()));
            }
            return ;
        }
        for(int i=1;i<=n;i++){
            int r=sb.length();
            int len=gP(i).length();
            sb.append(gP(i));
            dfs(res,n,sb,k+i);
            //回溯
            sb.delete(r,r+len);
        }

    }


    public static String gP(int n){
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<n;i++){
            sb.append("(");
        }
        for(int i=0;i<n;i++){
            sb.append(")");
        }
        return sb.toString();
    }
}
