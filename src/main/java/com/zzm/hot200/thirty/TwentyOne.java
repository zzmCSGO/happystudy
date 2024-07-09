package com.zzm.hot200.thirty;

/**
 * @BelongsProject: leet
 * @BelongsPackage: com.zzm.hot200.thirty
 * @Author: zzm
 * @CreateTime: 2024-02-20  17:47
 * @Description: TODO
 * @Version: 1.0
 */
//121. 买卖股票的最佳时机
public class TwentyOne {

    public int maxProfit(int[] prices) {

        int i=0;
        int j=1;
        int max=0;
        while(j<prices.length){
            if(prices[j]>prices[i]){ //涨了
                max=Math.max(max,prices[j]-prices[i]);
                j++;
            }else{
                i=j;//i变成j
                j++;
            }
        }
        return max;
    }

}
