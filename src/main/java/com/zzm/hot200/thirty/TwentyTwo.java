package com.zzm.hot200.thirty;

/**
 * @BelongsProject: leet
 * @BelongsPackage: com.zzm.hot200.thirty
 * @Author: zzm
 * @CreateTime: 2024-02-20  17:55
 * @Description: TODO
 * @Version: 1.0
 */
public class TwentyTwo {
    public int maxProfit(int[] prices) {
        int i=0;
        int j=1;
        int sum=0;
        while(j<prices.length){
            if(prices[j]>prices[i]){//有利润
                sum+=prices[j]-prices[i];
            }
            i=j;
            j++;
        }
        return sum;
    }

}
