package com.zzm.hot100.thirty;

/**
 * @BelongsProject: leet
 * @BelongsPackage: com.zzm.hot100
 * @Author: zzm
 * @CreateTime: 2024-01-17  13:13
 * @Description: TODO
 * @Version: 1.0
 */
//27.移除元素
public class TwentySeven {
    public static void main(String[] args) {
        int[] nums = {3, 2, 2, 3};
        System.out.println(new TwentySeven().removeElement(nums, 3));
    }

    public int removeElement(int[] nums, int val) {
        int count=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=val){
                nums[count]=nums[i];
                count++;
            }
        }
        return count;
    }
}
