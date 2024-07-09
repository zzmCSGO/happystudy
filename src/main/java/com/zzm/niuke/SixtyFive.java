package com.zzm.niuke;

/**
 * @BelongsProject: leet
 * @BelongsPackage: com.zzm.niuke
 * @Author: zzm
 * @CreateTime: 2024-02-29  20:53
 * @Description: TODO
 * @Version: 1.0
 */
//65.最长公共子序列(二)
public class SixtyFive {
//    题目要求获取最长公共子序列，我们肯定要先知道最长到底是多长，因此肯定要先求最长公共子序列的长度，
//    然后根据这个长度获取这个子序列。（注意：子序列不是子串，子串要求所有字符必须连续，子序列不要求连续，
//    只要求相对位置不变）
    public static String LCS (String s1, String s2) {
        // write code here
        int row=s1.length();
        int col=s2.length();
        //定义数组：dp[i][j] ：s1第i个和s2第j个开始的最长公共子数列的长度
        //子问题初始化
        int[][]dp=new int[row+1][col+1];
        for(int i=0;i<=row;i++){
            dp[i][0]=0;
        }
        for(int i=0;i<=col;i++){
            dp[0][i]=0;
        }
        for(int i=1;i<=row;i++){
            for(int j=1;j<=col;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    //两个字符相等
                    dp[i][j]=dp[i-1][j-1]+1;
                }else{
                    //不相等的话，取左边或上边的最大值
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        //反推结果
        int i=row;
        int j=col;
        StringBuilder sb=new StringBuilder();
        while(i>0&&j>0){
            if(s1.charAt(i-1)==s2.charAt(j-1)){
                sb.append(s1.charAt(i-1));
                i--;
                j--;
            }else{
                //如果字符串不相等
                if(dp[i-1][j]>dp[i][j-1]){
                    //说明是从上面来的
                    i--;
                }else if(dp[i-1][j]<dp[i][j-1]){
                    //说明是从左面来的
                    j--;
                }else if(dp[i-1][j]==dp[i][j-1]){
                    //如果两者相等，选取一个分支来看，就选从上面来的
                    i--;
                }
            }
        }
        //由于倒叙相加，这里反转
        String s = sb.reverse().toString();
        return s;
    }

    public static void main(String[] args) {
        String a="1A2C3D4B56";
        String b="B1D23A456A";
        System.out.println(LCS(a,b));
    }
}
