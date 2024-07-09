package com.zzm.niuke;

/**
 * @BelongsProject: leet
 * @BelongsPackage: com.zzm.niuke
 * @Author: zzm
 * @CreateTime: 2024-03-13  14:31
 * @Description: TODO
 * @Version: 1.0
 */
public class EightySix {
    public static void main(String[] args) {
        String s="1";
        String t="99";
        System.out.println(solve(s, t));

    }
    public static String solve (String s, String t) {
        // write code here
        StringBuilder sbs=new StringBuilder(s);
        StringBuilder sbt=new StringBuilder(t);

        StringBuilder res=new StringBuilder();
        int carry=0;
        while(sbs.length()!=0||sbt.length()!=0){
            int a=0;
            int b=0;
            if(sbs.length()!=0){
                //字符变整形-‘0’
                a=sbs.charAt(sbs.length()-1)-'0';
                sbs.deleteCharAt(sbs.length()-1);
            }

            if(sbt.length()!=0){
                b=sbt.charAt(sbt.length()-1)-'0';
                sbt.deleteCharAt(sbt.length()-1);
            }
            int sum=a+b+carry;
            res.append(sum%10);
            carry=(a+b+carry)/10;
        }
        if(carry>0){
            res.append(1);
        }
        String r=res.reverse().toString();
        return r;
    }
}
