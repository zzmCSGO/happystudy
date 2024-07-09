package com.zzm.hot100.sixty;

import java.util.Arrays;

/**
 * @BelongsProject: leet
 * @BelongsPackage: com.zzm.hot100.sixty
 * @Author: zzm
 * @CreateTime: 2024-02-18  00:49
 * @Description: TODO
 * @Version: 1.0
 */
//53.最大子数组合
public class FiftyThree {
    public int maxSubArray(int[] nums) {

        int ans=nums[0];
        int sum=0;

        for(int num:nums){
            if(sum>0){
                sum+=num;
            }else{
                //如果sum小于等于0，那么就不要加了，直接从当前位置开始
                sum=num;
            }
            ans=Math.max(ans,sum);
        }
        return ans;
    }


}
