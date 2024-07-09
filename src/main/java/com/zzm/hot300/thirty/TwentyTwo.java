package com.zzm.hot300.thirty;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @BelongsProject: leet
 * @BelongsPackage: com.zzm.hot300.thirty
 * @Author: zzm
 * @CreateTime: 2024-02-26  22:23
 * @Description: TODO
 * @Version: 1.0
 */
//零钱兑换 332
public class TwentyTwo {

    static int min=-1;//需要的最少硬币数目

    //index:当前硬币索引,count代表某一组合中，钱币的总数
    public void rec(int index, int[]coins, int remainder, AtomicInteger count, LinkedList<Integer> stack,boolean first){
        if(!first){
            stack.push(coins[index]);
        }
        //情况1: 剩余金额<0 无解
        //情况2: 剩余金额>0 继续递归
        //情况3: 剩余金额=0 有解
        count.incrementAndGet();//count++
        //无解就不计数了
//        if(remainder<0){
////            return 0;
//        } else
            if (remainder==0) {
                System.out.println(stack);
    //            return 1;
                if(min==-1){
                    //第一次有解先赋值
                    min=count.intValue();
                }else{
                    min=Math.min(min,count.intValue());
                }
            }else if(remainder>0){
                for(int i=index;i<coins.length;i++){
                    rec(i,coins,remainder-coins[i],count,stack,false);
                }
//            return count;
            }
             count.decrementAndGet();//count--
        if(!stack.isEmpty()){
            stack.pop();
        }
//        return count.intValue();
    }

    public static void main(String[] args) {
//        TwentyTwo twentyTwo = new TwentyTwo();
//        AtomicInteger count = new AtomicInteger(-1);
//        twentyTwo.rec(0, new int[]{5, 2,1 }, 5, count, new LinkedList<>(),true);
//        System.out.println(min);
        int [] a=new int[]{357,322,318,181,22,158,365};
        Arrays.sort(a);
//        int [] a=new int[]{2};
//        int [] a=new int[]{1,2,5};
//        int [] a=new int[]{15,10,1};//贪心算法会导致错误解
        TwentyTwo twentyTwo = new TwentyTwo();
//        int i = twentyTwo.coinChange(a, 11);
//        System.out.println(i);
        int i1 = twentyTwo.coinChange2(a, 4976);
        System.out.println(i1);


    }


    //贪心的原则:
        //1.每一次都选取当前的最优解
        //2.向前看，别回头：不会回溯

    //每次循环的时候找到当前的最优解：面值最大的硬币
    public int coinChange(int[] coins,int amount){
        int remainder=amount;
        int count=0;
        for(int coin:coins){
            //如果剩余金额大于coin,就一直减，小于当前的coin就换下一个coin
            while(remainder>coin){
                remainder-=coin;
                count++;
            }
            //不在while里写等于判断条件，是因为在while之外写break可以跳出for循环。
            if(remainder==coin){
                remainder=0;
                count++;
                break;
            }
        }
        if(remainder>0){
            return -1;
        }else{
            return count;
        }
    }

    //动态规划
    public int coinChange2(int[] coins,int amount){

        int[][]dp=new int[coins.length][amount+1];
        for(int i=1;i<amount+1;i++){
            //初始化第一行
            if(i>=coins[0]){
                //能放下
                dp[0][i]=dp[0][i-coins[0]]+1;
            }else{
                dp[0][i]=amount+1;//若方程最大值容易造成值溢出
            }
        }

        for(int i=1;i<coins.length;i++){
            for(int j=1;j<amount+1;j++){
                if(j>=coins[i]){
                    dp[i][j]=Math.min(dp[i-1][j],dp[i][j-coins[i]]+1);
                }else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }

        return dp[coins.length-1][amount]>amount?-1:dp[coins.length-1][amount];

    }

    //降为
    public int coinChangePlus(int[] coins,int amount){

        int[]dp=new int[amount+1];
        Arrays.fill(dp,amount+1);
        dp[0]=0;
//        for(int i=1;i<amount+1;i++){
//            //初始化第一行
//            if(i>=coins[0]){
//                //能放下
//                dp[i]=dp[i-coins[0]]+1;
//            }else{
//                dp[i]=amount+1;//若方程最大值容易造成值溢出
//            }
//        }
        for(int i=0;i<coins.length;i++){
            for(int j=1;j<amount+1;j++){
                if(j>=coins[i]){
                    dp[j]=Math.min(dp[j],dp[j-coins[i]]+1);
                }else{
                    dp[j]=dp[j];
                }
            }
        }

        return dp[amount]>=amount?-1:dp[amount];
    }


}
