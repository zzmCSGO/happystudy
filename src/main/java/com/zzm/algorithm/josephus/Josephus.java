package com.zzm.algorithm.josephus;

/**
 * @BelongsProject: leet
 * @BelongsPackage: com.zzm.algorithm.josephus
 * @Author: zzm
 * @CreateTime: 2024-02-23  21:39
 * @Description: TODO
 * @Version: 1.0
 */
//约瑟夫环问题
public class Josephus {
    //编号为 1-n 的循环报 1-3，报道 3 的出列，求最后一人的编号
    //f(n,k)=(f(n-1,k)+k)%n

    public static int f(int n,int k){
        //如果只有一个人，那么它的编号起始人的编号0
        if(n==1){
            return 0;
        }
        return (f(n-1,k)+k)%n;
    }


    public static void main(String[] args) {
        int n=10;
        int k=3;
        System.out.println("最后那个人的编号为:"+f(n,k));
    }
}
