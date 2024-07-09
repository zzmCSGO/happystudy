package com.zzm.hot100.forty;

import java.util.*;

/**
 * @BelongsProject: leet
 * @BelongsPackage: com.zzm.hot100.forty
 * @Author: zzm
 * @CreateTime: 2024-02-16  21:46
 * @Description: TODO
 * @Version: 1.0
 */
//31.下一个排列
public class ThirtyOne {


    /*
    从后向前 查找第一个 相邻升序 的元素对 (i,j)，满足 A[i] < A[j]。此时 [j,end) 必然是降序
    在 [j,end) 从后向前 查找第一个满足 A[i] < A[k] 的 k。A[i]、A[k] 分别就是上文所说的「小数」、「大数」
    将 A[i] 与 A[k] 交换
    可以断定这时 [j,end) 必然是降序，逆置 [j,end)，使其升序
    如果在步骤 1 找不到符合的相邻元素对，说明当前 [begin,end) 为一个降序顺序，则直接跳到步骤 4
     **/

    public static void main(String[] args) {
        int[] nums = {3, 2, 1};
        new ThirtyOne().nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }


    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= i + 1 && nums[i] >= nums[j]) {
                j--;
            }
            swap(nums, i, j);
        }
        Arrays.sort(nums, i + 1, nums.length);
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
