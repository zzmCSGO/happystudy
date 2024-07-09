package com.zzm.niuke;

/**
 * @BelongsProject: leet
 * @BelongsPackage: com.zzm.niuke
 * @Author: zzm
 * @CreateTime: 2024-02-29  16:46
 * @Description: TODO
 * @Version: 1.0
 */
//BM21 旋转数组的最小数字
public class TwentyOne {
//    旋转数组将原本有序的数组分成了两部分有序的数组，因为在原始有序数组中，
//    最小的元素一定是在首位，旋转后无序的点就是最小的数字。我们可以将旋转前的前半段命名为A，旋转后的前半段命名为B，旋转数组即将AB变成了BA，我们想知道最小的元素到底在哪里。
    public int minNumberInRotateArray(int [] array) {
        // 特殊情况判断
        if (array.length== 0) {
            return 0;
        }
        // 左右指针i j
        int i = 0, j = array.length - 1;
        // 循环
        while (i < j) {
            // 找到数组的中点 m
            int m = (i + j) / 2;
            // m在左排序数组中，旋转点在 [m+1, j] 中
            if (array[m] > array[j]) i = m + 1;
                // m 在右排序数组中，旋转点在 [i, m]中
            else if (array[m] < array[j]) j = m;
                // 缩小范围继续判断
            else j--;
        }
        // 返回旋转点
        return array[i];
    }
}
