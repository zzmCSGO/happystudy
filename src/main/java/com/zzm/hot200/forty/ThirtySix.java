package com.zzm.hot200.forty;

import java.util.HashSet;

/**
 * @BelongsProject: leet
 * @BelongsPackage: com.zzm.hot200.forty
 * @Author: zzm
 * @CreateTime: 2024-01-29  21:44
 * @Description: TODO
 * @Version: 1.0
 */
//136.只出现一次的数字
public class ThirtySix {
    public static void main(String[] args) {

    }

//    public int singleNumber(int[] nums) {
//        HashSet<Integer> set=new HashSet<>();
//        for(int key:nums){
//            if(!set.add(key)){
//                set.remove(key);
//            }
//        }
//        return set.iterator().next();
//    }

    public int singleNumber(int[] nums) {
       int num=nums[0];
       for(int i=1;i<nums.length;i++){
           num=num^nums[i];
       }
       return num;
    }
}
