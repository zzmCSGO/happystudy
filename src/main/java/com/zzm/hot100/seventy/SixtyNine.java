package com.zzm.hot100.seventy;

/**
 * @BelongsProject: leet
 * @BelongsPackage: com.zzm.hot100.seventy
 * @Author: zzm
 * @CreateTime: 2024-01-30  14:16
 * @Description: TODO
 * @Version: 1.0
 */
//69. x 的平方根
public class SixtyNine {
    public int mySqrt(int x) {
        int i = 1, j = x;
        int r = 0;//记录最大尝试mid的数字
        while (i <= j) {
            //先求取中间值
            int mid = (i + j) / 2;
//            int mm = mid * mid;
            if (mid <= x/mid) {
                i = mid + 1;
                r = mid;
            } else {
                j = mid - 1;
            }
        }
        return r;
    }
}
