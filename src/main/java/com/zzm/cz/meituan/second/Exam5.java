package com.zzm.cz.meituan.second;

import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @BelongsProject: leet
 * @BelongsPackage: com.zzm.meituan.second
 * @Author: zzm
 * @CreateTime: 2024-03-16  18:33
 * @Description: TODO
 * @Version: 1.0
 */
public class Exam5 {

    private static int count = 0; //成员变量


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        //数组大小
        int n = in.nextInt();
        int a[] = new int[n];
//        int res[]=new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        //对每个元素依次取反
        for (int i = 0; i < n; i++) {
            a[i] = -a[i];
            System.out.print(mergeSort(a)+" ");
//            res[i]=mergeSort(a);
            //回溯
            a[i] = -a[i];
            count = 0;
        }
    }
    //先定义一个求逆序对的函数
    //归并排序
    //写一个归并排序
    public static int mergeSort(int arr[]) {
        int arrNew[] = new int[arr.length];
//        AtomicInteger count=new AtomicInteger(0);
        split(arr, 0, arr.length - 1, arrNew);
        return count;
    }

    //拆分
    public static void split(int arr[], int left, int right, int arrNew[]) {
        if (left >= right) {
            return;
        }
        int mid = (left + right) / 2;
        split(arr, left, mid, arrNew);
        split(arr, mid + 1, right, arrNew);
        merge(arr, left, mid, mid + 1, right, arrNew);
        System.arraycopy(arrNew, left, arr, left, right - left + 1);
    }


    public static void merge(int arr[], int i, int iEnd, int j, int jEnd,
                             int arrNew[]) {
        int k = i;
        while (i <= iEnd && j <= jEnd) {
            //左边大于右边,这个就是逆序的
            if (arr[i] > arr[j]) {
                arrNew[k] = arr[j];
                count = count + (iEnd-i+1);
                j++;
            } else {
                arrNew[k] = arr[i];
                i++;
            }
            k++;
        }

        if (i > iEnd) {
            System.arraycopy(arr, j, arrNew, k, jEnd - j + 1);
        }
        if (j > jEnd) {
            System.arraycopy(arr, i, arrNew, k, iEnd - i + 1);
        }
    }

}
