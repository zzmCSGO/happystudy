package com.zzm.cz.meituan.second;

import java.util.Scanner;

/**
 * @BelongsProject: leet
 * @BelongsPackage: com.zzm.meituan.second
 * @Author: zzm
 * @CreateTime: 2024-03-16  18:33
 * @Description: TODO
 * @Version: 1.0
 */
public class Exam2 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String s=in.nextLine();
        char[] chars=s.toCharArray();
        int len=chars.length;
        int lowCount=0;
        for(int i=0;i<len;i++){
            if(chars[i]<='z'&&chars[i]>='a'){
                lowCount++;
            }
        }
        boolean flag=false;
        if(chars[0]<='Z'&&chars[0]>='A'){
            flag=true;
        }
        if(!flag){
            if(lowCount<=len-lowCount){
                System.out.println(lowCount);
            }else{
                System.out.println(len-lowCount);
            }
        }else{
            if(lowCount<=len-lowCount-1){
                System.out.println(lowCount);
            }else{
                System.out.println(len-lowCount-1);
            }
        }
    }
}
