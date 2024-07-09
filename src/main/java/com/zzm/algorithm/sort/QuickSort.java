package com.zzm.algorithm.sort;

/**
 * @BelongsProject: leet
 * @BelongsPackage: com.zzm.algorithm.sort
 * @Author: zzm
 * @CreateTime: 2024-02-20  17:28
 * @Description: TODO
 * @Version: 1.0
 */
public class QuickSort {

    private static void quick(int [] a,int left,int right){
        if(left>=right){
            return;
        }
        int p=partition(a,left,right);
        quick(a,left,p-1);
        quick(a,p+1,right);
    }

    private static int partition(int[] a, int left, int right) {
        int pv=a[right];//基准点元素的值
        int i=left;
        int j=left;
        while(j<right){
            if(a[j]<pv){//j找到比基准点小的了,
                if(i!=j){
                    swap(a,i,j);
                }
                i++;//i没有找到比基准点大的，所以i++
            }
            j++;
        }
        swap(a,i,right);
        return i;
    }

    private static void swap(int[] a, int i, int j) {
        int temp=a[i];
        a[i]=a[j];
        a[j]=temp;
    }

    public static void main(String[] args) {
        int[] a={1,3,5,2,2};
        quick(a,0,4);
        System.out.println(1);
    }
}
