package com.zzm.hot100.ten;

import java.util.HashMap;

/**
 * @BelongsProject: leet
 * @BelongsPackage: com.zzm.hot100.ten
 * @Author: zzm
 * @CreateTime: 2024-01-29  19:35
 * @Description: TODO
 * @Version: 1.0
 */
//两数之和
public class One {
    public static void main(String[] args) {

    }

    public int[] twoSum(int [] nums,int target){
        HashMap<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(target-nums[i])){
                return new int[]{i,map.get(target-nums[i])};
            }else{
                map.put(nums[i],i);
            }
        }
        return null;

    }
}
