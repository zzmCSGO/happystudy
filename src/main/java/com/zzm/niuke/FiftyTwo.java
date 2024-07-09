package com.zzm.niuke;

import java.util.*;

/**
 * @BelongsProject: leet
 * @BelongsPackage: com.zzm.niuke
 * @Author: zzm
 * @CreateTime: 2024-03-06  11:09
 * @Description: TODO
 * @Version: 1.0
 */
public class FiftyTwo {
    public static int[] FindNumsAppearOnce (int[] nums) {
        // write code here
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.compute(nums[i], (key, val) -> (val == null) ? 1 : val + 1);
//            map.merge(nums[i], 1, Integer::sum);

//            if(!map.containsKey(nums[i])){
//                map.put(nums[i],1);
//            }else{
//                map.put(nums[i],map.get(nums[i])+1);
//            }
        }
        List<Integer> list=new ArrayList<>();
        map.forEach((k,v)->{
            if (v==1){
                list.add(k);
            }
        });
        int[] intArray = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            intArray[i] = list.get(i);
        }

        return intArray;
    }

    public static void main(String[] args) {
        int[] nums={1,2,2,3,3,4};
        int[] ints = FindNumsAppearOnce(nums);
        System.out.println("");
    }
}
