package com.zzm.hot100.hundred;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @BelongsProject: leet
 * @BelongsPackage: com.zzm.hot100.hundred
 * @Author: zzm
 * @CreateTime: 2024-02-14  15:08
 * @Description: TODO
 * @Version: 1.0
 */
//97.交错字符串
public class NinetySeven {

    public static void main(String[] args) {
        NinetySeven ninetySeven = new NinetySeven();
        boolean interleave = ninetySeven.isInterleave("aabcc", "dbbca", "aadbbbaccc");
        System.out.println(interleave);
    }
    public boolean isInterleave2(String s1, String s2, String s3) {

        if(s1.length()+s2.length()!=s3.length()){
            return false;
        }

        String s=s1+s2;
        char [] cOld=s.toCharArray();
        char [] cNew=s3.toCharArray();
        Arrays.sort(cOld);
        Arrays.sort(cNew);
        if(!Arrays.equals(cOld,cNew)){
            return false;
        }
        return true;
    }

    public boolean isInterleave(String s1, String s2, String s3) {

        int m=s1.length();
        int n=s2.length();
        int k=s3.length();
        if(m+n!=k){
            return false;
        }
        //s1前i个和s2前j个能否组成s3的前i+j个
        boolean[][]dp=new boolean[m+1][n+1];
        dp[0][0]=true;

        //初始化数组 行
        for(int i=1;i<=m;i++){
            //保证前面的是true，dp[i-1][0]才可以继续。出现false了就停止了。因为不连续
            if(s1.charAt(i-1)==s3.charAt(i-1)&&dp[i-1][0]){
                dp[i][0]=true;
            }
        }
        //列
        for(int i=1;i<=n;i++){
            if(s2.charAt(i-1)==s3.charAt(i-1)&&dp[0][i-1]){
                dp[0][i]=true;
            }
        }
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                //分为两种情况
                //1.s1的前i-1个字符和s2的前j个字符能组成s3的前i+j-1个，并且s1的第i个等于s3的i+j个
                //2.s2的前j-1个字符和s1的前i个字符能组成s3的前i+j-1个，并且s2的第j个等于s3的i+j个
                dp[i][j]=(dp[i-1][j]&&s1.charAt(i-1)==s3.charAt(i+j-1))||
                        (dp[i][j-1]&&s2.charAt(j-1)==s3.charAt(i+j-1));
            }
        }
        return dp[m][n];
    }

}
