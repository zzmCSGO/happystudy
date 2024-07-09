package com.zzm.hot100.ninety;

/**
 * @BelongsProject: leet
 * @BelongsPackage: com.zzm.hot100.ninety
 * @Author: zzm
 * @CreateTime: 2024-02-21  16:08
 * @Description: TODO
 * @Version: 1.0
 */
//81. 搜索旋转排序数组 II
public class EightyOne {
    public boolean search(int[] nums, int target) {
        int len = nums.length;
        if (len == 0) {
            return false;
        }
        if (len == 1) {
            return nums[0] == target;
        }


        int left = 0;
        int right = len - 1;
        while (left <= right) {

            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return true;
            }
            // 重复元素处理
            if (nums[left] == nums[mid] && nums[mid] == nums[right]) {
                left++;
                right--;

            } else if (nums[left] <= nums[mid]) {// 中间mid及左边有序
                if (nums[left] <= target && target < nums[mid]) {// target在左边
                    right = mid - 1;
                } else {// target在右边
                    left = mid + 1;
                }
            } else {// 右边有序   //[2,5,6,0,0,1,2]
                if (nums[mid] < target && target <= nums[len - 1]) {// target在右边
                    left = mid + 1;
                } else {// target在左边
                    right = mid - 1;
                }
            }
        }
        return false;
    }

}
