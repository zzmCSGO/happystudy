package com.zzm.hot100.fifty;

/**
 * @BelongsProject: leet
 * @BelongsPackage: com.zzm.hot100.fifty
 * @Author: zzm
 * @CreateTime: 2024-01-30  13:49
 * @Description: TODO
 * @Version: 1.0
 */
//50. Pow(x, n)
public class Fifty {
    public static void main(String[] args) {
        System.out.println(myPow(2.00000, 4));
    }

    public static double myPow(double x, int n) {
        long p=n;//-2
        if(p<0){
            p=-p;
        }
        double r=myPowPositive(x,p);
        return n<0?1/r:r;

    }
    public static double myPowPositive(double x, long n) {
        if(n==0){
            return 1.0;
        }
        if(n==1){
            return x;
        }
        double v = myPowPositive(x, n / 2);
        //奇偶数可以用位运算来判断，可以跟1按位与运算，如果是奇数则结果为..0001，偶数则为..0000
        if((n&1)==0){
            //偶数
           return v*v;
        }else{
            //奇数
            return v*v*x;
        }
    }
}
