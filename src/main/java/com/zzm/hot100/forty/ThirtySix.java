package com.zzm.hot100.forty;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @BelongsProject: leet
 * @BelongsPackage: com.zzm.hot100.forty
 * @Author: zzm
 * @CreateTime: 2024-02-02  20:20
 * @Description: TODO
 * @Version: 1.0
 */
public class ThirtySix {
    public static void main(String[] args) {
        int[] nums={5,7,7,8,8,10};
        int target=8;
        int[] ints = new ThirtySix().searchRange(nums, target);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }
    public int[] searchRange(int[] nums, int target) {
        int leftIdx = binarySearch(nums, target, true);
        int rightIdx = binarySearch(nums, target, false) - 1;
        if (leftIdx <= rightIdx && rightIdx < nums.length && nums[leftIdx] == target && nums[rightIdx] == target) {
            return new int[]{leftIdx, rightIdx};
        }
        return new int[]{-1, -1};
    }

    public int binarySearch(int[] nums, int target, boolean lower) {
        int left = 0, right = nums.length - 1, ans = nums.length;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > target || (lower && nums[mid] >= target)) {
                right = mid - 1;
                ans = mid;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    // 两次二分查找，分开查找第一个和最后一个
    // 时间复杂度 O(log n), 空间复杂度 O(1)
    // [1,2,3,3,3,3,4,5,9]
    public int[] searchRange2(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int first = -1;
        int last = -1;
        // 找第一个等于target的位置
        while (left <= right) {
            int middle = (left + right) / 2;
            if (nums[middle] == target) {
                first = middle;
                right = middle - 1; //重点
            } else if (nums[middle] > target) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }

        // 最后一个等于target的位置
        left = 0;
        right = nums.length - 1;
        while (left <= right) {
            int middle = (left + right) / 2;
            if (nums[middle] == target) {
                last = middle;
                left = middle + 1; //重点
            } else if (nums[middle] > target) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }

        return new int[]{first, last};
    }

}
