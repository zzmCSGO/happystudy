package com.zzm.cz.pdd;

import java.util.*;

/**
 * @BelongsProject: happystudy
 * @BelongsPackage: com.zzm.cz.pdd
 * @Author: zzm
 * @CreateTime: 2024-03-24  19:09
 * @Description: TODO
 * @Version: 1.0
 */
public class Exam2 {
/*  有 n 个正整数，a_1, ..., a_n
    Alice 会先去掉其中最多 d 个数
    Bob 接下来会将剩余的数中最多 m 个数乘以 -k
    Alice 想要剩余数之和尽可能大，Bob 想要剩余数之和尽可能小。假设 Alice 和 Bob 都足够聪明，请问最后剩余数之和是多少。*/

    public static void main(String[] args) {
        int[] arr = {1,8,2,9,3,3,4,5,3,200};
        int d = 6;
        int m = 4;
        int k = 1;
        System.out.println(maxSum(arr, d, m, k));
    }
    //2<=n<=10^5 0<=m,d<=n 1<=k<=10^4 1<=ai<=10^9
    //考虑边界问题进行优化
    private static long maxSum(int[] arr, int d, int m, int k) {
        //Alice 想要剩余数之和尽可能大。排序去掉头部开始d个数
        Arrays.sort(arr);
        //将arr放入到list中
        LinkedList<Long> queue = new LinkedList<>();
        //114
        for (int a : arr) {
            queue.addLast((long)a);
        }
        //11
        for (int i = 0; i < d; i++) {
            queue.pollLast();
        }
        int last = arr.length - d;
//        Bob 想要剩余数之和尽可能小
        //将剩余数里面最大的m个数乘以-k
        for (int i = 0; i < m; i++) {
            if (last > 0) {
                long max = queue.pollLast();
                queue.addFirst(max * (-k));
                last--;
            }else{
                break;
            }
        }
        //将queue里面的数求和
        long sum = 0;
        for (long a : queue) {
            sum += a;
        }
        return sum;
    }

}
