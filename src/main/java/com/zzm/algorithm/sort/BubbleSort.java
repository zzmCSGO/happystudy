package com.zzm.algorithm.sort;

/**
 * @BelongsProject: leet
 * @BelongsPackage: com.zzm.algorithm.sort
 * @Author: zzm
 * @CreateTime: 2024-01-26  13:29
 * @Description: TODO
 * @Version: 1.0
 */
//冒泡排序

public class BubbleSort {
    public static void main(String[] args) {

    }

    public static void sort(int [] a){
        bubble(a,a.length-1);
    }

    private static void bubble(int [] a,int j){
        if(j==0){
            return;
        }
        int x=0;//可以保证x右侧是已经排序好的
        for (int i = 0; i < j; i++) {
            //交换数组元素
            if(a[i]>a[i+1]){
                int temp=a[i];
                a[i]=a[i+1];
                a[i+1]=temp;
                x=i;
            }
        }
//        bubble(a,j-1);
        //x即为最后一次交换的位置，也是下一次比较的边界
        bubble(a,x);//优化
    }

}
