package com.zzm.hot100.ninety;

import java.util.Arrays;
import java.util.stream.LongStream;

/**
 * @BelongsProject: leet
 * @BelongsPackage: com.zzm.hot100.ninety
 * @Author: zzm
 * @CreateTime: 2024-01-26  10:50
 * @Description: TODO
 * @Version: 1.0
 */
//88. 合并两个有序数组
public class EightyEight {
    public static void main(String[] args) {
        int [] nums1={1,2,3,0,0,0};
        int [] nums2={2,5,6};
        int [] nums3={3,4,5};
        //将数组num3的元素替换nums2中的元素
        System.arraycopy(nums3,0,nums2,0,3);
        System.arraycopy(nums2,0,nums1,3,3);
        //将num1排序
        nums1 = Arrays.stream(nums1).asLongStream().sorted().mapToInt(value -> (int) value).toArray();
        System.out.println(Arrays.toString(nums1));
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //将num2中的元素，从nums1索引为m的位置开始，复制到nums1中
        //arraycopy的五个参数分别意义是：源数组，源数组的起始位置，目标数组，目标数组的起始位置，复制的长度
        System.arraycopy(nums2, 0, nums1, m, n);




    }


    public static void merge(int[] a1, int i, int iEnd, int j, int jEnd,
                             int[] a2, int k) {
        if (i > iEnd) {
            System.arraycopy(a1, j, a2, k, jEnd - j + 1);
            return;
        }
        if (j > jEnd) {
            System.arraycopy(a1, i, a2, k, iEnd - i + 1);
            return;
        }

        if (a1[i] < a1[j]) {
            a2[k] = a1[i];
            merge(a1, i + 1, iEnd, j, jEnd, a2, k + 1);
        } else {
            a2[k] = a1[j];
            merge(a1, i, iEnd, j + 1, jEnd, a2, k + 1);
        }
    }


    public void merges(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2,0,nums1,m,n);
        int [] news=new int[m+n];
        mergeGB(nums1,0,m-1,m,m+n-1,news,0);
        System.arraycopy(news,0,nums1,0,m+n);
    }

    //归并排序
    public void mergeGB(int [] olds,int i,int iEnd,int j ,int jEnd,int [] news,int k){
        if(i>iEnd){
            //说明左边遍历完事了
            System.arraycopy(olds,j,news,k,jEnd-j+1);
            return;
        }
        if(j>jEnd){
            System.arraycopy(olds,i,news,k,iEnd-i+1);
            return;
        }
        if(olds[i]>olds[j]){
            //把较小的值给新数组
            news[k]=olds[j];
            //较小值那一边往下移动指针,并且移动新数组的指针
            mergeGB(olds,i,iEnd,j+1,jEnd,news,k+1);
        }else{
            news[k]=olds[i];
            mergeGB(olds,i+1,iEnd,j,jEnd,news,k+1);
        }


    }
}
