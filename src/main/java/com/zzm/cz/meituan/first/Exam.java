package com.zzm.cz.meituan.first;

import java.util.Scanner;

/**
 * @BelongsProject: leet
 * @BelongsPackage: com.zzm.meituan
 * @Author: zzm
 * @CreateTime: 2024-03-09  10:01
 * @Description: TODO
 * @Version: 1.0
 */
public class Exam {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //首先先记录字符串里面有多少个MT数目n，然后查看剩下得字符，如果字符数目>=k,则有n+k个
        //如果小于k，则有字符串得.length个
        int n=0;
        int k=0;
        while(in.hasNextInt()){
            n=in.nextInt();//字符串长度
            k=in.nextInt();//操作次数
        }
        String str = in.next();
        int orignial = 0;
        int res=0;
        for (char c : str.toCharArray()) {
            if(c=='M'||c=='T'){
                orignial++;
            }
        }
        if(n>=k){
            res=orignial+k;
        }else{
            res=str.length();
        }
        System.out.println(res);
    }

}
