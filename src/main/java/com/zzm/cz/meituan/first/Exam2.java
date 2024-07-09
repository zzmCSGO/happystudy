package com.zzm.cz.meituan.first;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @BelongsProject: leet
 * @BelongsPackage: com.zzm.meituan
 * @Author: zzm
 * @CreateTime: 2024-03-09  10:51
 * @Description: TODO
 * @Version: 1.0
 */
public class Exam2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int n=0;//数组大小
        int q=0;//代表询问次数
       // 注意 while 处理多个 case
            n = in.nextInt();
            q = in.nextInt();
        int a[]=new int[n];
        HashMap<Integer,Integer> map=new HashMap<>();
        int res=0;
        int member=0;
        for(int i=0;i<n;i++){
            int temp=in.nextInt();
            a[i]=temp;
            if(temp!=0){
                res+=temp;
            }else{
                member++;
            }
        }
//        Res re[]=new Res[q];
        int max[]=new int[q];
        int min[]=new int[q];
        for(int i=0;i<q;i++){
            int l=in.nextInt();
            int r=in.nextInt();
            max[i]=res+member*Math.max(l,r);
            min[i]=res+member*Math.min(l,r);
        }
        for(int i=0;i<q;i++){
            System.out.println(min[i] +" "+max[i]);
        }
    }


}
