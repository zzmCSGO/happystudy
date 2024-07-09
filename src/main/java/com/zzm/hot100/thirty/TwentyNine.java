package com.zzm.hot100.thirty;

/**
 * @BelongsProject: leet
 * @BelongsPackage: com.zzm.hot100
 * @Author: zzm
 * @CreateTime: 2024-01-17  15:08
 * @Description: TODO
 * @Version: 1.0
 */
//29.两数相除
public class TwentyNine {
    public static void main(String[] args) {
        int dividend = -2147483648;
        int divisor = 2;
//        System.out.println(Integer.MIN_VALUE);
//        System.out.println(Integer.MAX_VALUE);
        System.out.println(new TwentyNine().plus(dividend, divisor));

    }
    //不使用 乘法、除法和取余运算
    public int divide(int dividend, int divisor) {
        long flag = 1;
        if(dividend<0&&divisor>0||dividend>0&&divisor<0){
            flag = -flag;
        }
        System.out.println(flag);
        long dend = dividend;
        long isor = divisor;
        long count = 0;
        dend=dend<0?-dend:dend;
        isor=isor<0?-isor:isor;
        while(dend>=isor){
            dend -= isor;
            count++;
        }
        System.out.println("count"+count);
        long res = count*flag;
        if(res>Integer.MAX_VALUE||res<Integer.MIN_VALUE){
            return Integer.MAX_VALUE;
        }
        return (int)res;
    }

    // 60/8 = (60-32)/8 + 4 = (60-32-16)/8 + 2 + 4 = 1 + 2 + 4 = 7
    public int plus(int dividend, int divisor){
        if(dividend==Integer.MIN_VALUE&&divisor==-1){
            return Integer.MAX_VALUE;
        }
        if(divisor==1){
            return dividend;
        }
        // 考虑被除数为 0 的情况
        if (dividend == 0) {
            return 0;
        }

        int flag = 1;
        int res=0;
        if(dividend<0&&divisor>0||dividend>0&&divisor<0){
            flag = -flag;
        }
        res=dfs(dividend,divisor);
        return flag*res;
    }

    int dfs(long a,long b){
        a=a<0?-a:a;
        b=b<0?-b:b;
        //a:11 b:3
        if(a<b){
            return 0;
        }
        int count = 1;
        long tb = b; //b是被除数
        //tb+tb就相当于b*2,
        while((tb+tb)<=a){
            //count记录倍数
            count += count;
            //更新tb为当前2倍，下一轮循环判断
            tb += tb;
        }
        return count+dfs(a-tb,b);
    }

}
