package com.zzm.hot100.ten;

/**
 * @BelongsProject: leet
 * @BelongsPackage: com.zzm.hot100
 * @Author: zzm
 * @CreateTime: 2024-01-12  12:43
 * @Description: TODO
 * @Version: 1.0
 */
//回文数
public class Nine {

    public static void main(String[] args) {
        int x=121;


    }

    public static boolean isPalindrome(int x) {
        int origin=x;
        int res=0;
        if(x==0){
            return true;
        }
        if(x<0){
            return false;
        }
        while(x!=0){
            //获取最后最后一位的数字
            int temp=x%10;
            //除掉最后一位数字
            x=x/10;
            res=res*10+temp;
        }

        if(res==origin){
            return true;
        }else{
            return false;
        }
    }
}
