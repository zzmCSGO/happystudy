package com.zzm.niuke;

/**
 * @BelongsProject: leet
 * @BelongsPackage: com.zzm.niuke
 * @Author: zzm
 * @CreateTime: 2024-02-28  18:54
 * @Description: TODO
 * @Version: 1.0
 */
public class Nineteen {

        public int findPeakElement (int[] nums) {
            int left = 0;
            int right = nums.length - 1;
            //二分法
            while(left < right){
                int mid = (left + right) / 2;
                //右边是往下，不一定有坡峰
                if(nums[mid] > nums[mid + 1])
                    right = mid;
                    //右边是往上，一定能找到波峰
                else
                    left = mid + 1;
            }
            //其中一个波峰
            return right;
        }


}
