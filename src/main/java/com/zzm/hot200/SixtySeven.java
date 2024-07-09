package com.zzm.hot200;

/**
 * @BelongsProject: leet
 * @BelongsPackage: com.zzm.hot200
 * @Author: zzm
 * @CreateTime: 2024-01-14  13:40
 * @Description: TODO
 * @Version: 1.0
 */
//167.两数之和II-输入有序数组
public class SixtySeven {
    public static void main(String[] args) {
        int[] numbers = {2, 7, 11, 15};
        System.out.println(twoSum(numbers, 9));
    }


    public static int[] twoSum(int[] numbers, int target) {
        //[2,7,11,15]
        int left = 0;
        int length = numbers.length;
        int right = length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum < target) {
                left++;
            } else if (sum > target) {
                right--;
            } else {
                break;
            }
        }
        return new int[]{left + 1, right + 1};
    }

}
