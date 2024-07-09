package com.zzm.hot100.eighty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @BelongsProject: leet
 * @BelongsPackage: com.zzm.hot100.eighty
 * @Author: zzm
 * @CreateTime: 2024-02-21  15:34
 * @Description: TODO
 * @Version: 1.0
 */
public class Eighty {
    public static void main(String[] args) {
        Eighty eighty = new Eighty();
        int i = eighty.removeDuplicates(new int[]{1, 1, 1, 2, 2, 3});
        System.out.println(i);
    }
    public int removeDuplicates(int[] nums) {
        int k=1;
        List<Integer> list=new ArrayList<>();
        list.add(nums[0]);
        for(int i=1;i<nums.length;i++){
            if(nums[i]==nums[i-1]&&k<2){
                list.add(nums[i]);
                k++;
            }else if(nums[i]!=nums[i-1]){
                list.add(nums[i]);
                k=1;
            }
        }
        for(int i=0;i<list.size();i++){
                nums[i]=list.get(i);
        }
        return list.size();

    }

    class Solution {
        public int removeDuplicates(int[] nums) {
            int n = nums.length;
            if (n <= 2) {
                return n;
            }
            int slow = 2, fast = 2;
            while (fast < n) {
                if (nums[slow - 2] != nums[fast]) {
                    nums[slow] = nums[fast];
                    ++slow;
                }
                ++fast;
            }
            return slow;
        }
    }

}
