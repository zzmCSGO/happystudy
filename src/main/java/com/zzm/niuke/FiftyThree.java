package com.zzm.niuke;

import java.util.HashMap;

/**
 * @BelongsProject: leet
 * @BelongsPackage: com.zzm.niuke
 * @Author: zzm
 * @CreateTime: 2024-03-08  16:34
 * @Description: TODO
 * @Version: 1.0
 */
public class FiftyThree {
    public static int minNumberDisappeared (int[] nums) {
        // write code here
        HashMap<Integer, Integer> map = new HashMap<>();
        //对于长度为 n 的数组，第一个缺失的正整数一定在 [1, n+1] 范围内。
        // 将所有不在[1, n]范围内的数改为n+1（一个肯定不会影响结果的值）
        int n = nums.length;
        for(int i=0;i<n;i++){
            map.compute(nums[i],(k,v)->v==null?1:v+1);
        }
        for(int i=1;i<=n+1;i++){
            if(map.containsKey(i)){
                continue;
            }else{
                return i;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] a={1,3,2};
        int i = minNumberDisappeared(a);
        System.out.println(i);
    }
}
