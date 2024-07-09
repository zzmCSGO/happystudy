package com.zzm.algorithm.sort;

import java.util.Arrays;

/**
 * @BelongsProject: leet
 * @BelongsPackage: com.zzm.algorithm.sort
 * @Author: zzm
 * @CreateTime: 2024-03-07  16:29
 * @Description: TODO
 * @Version: 1.0
 */
public class HeapSort {

    public static void main(String[] args) {
        int[] a={1,3,4,5,6,2,3,4};
        System.out.println(Arrays.toString(a));
        sort(a);
        System.out.println(Arrays.toString(a));
    }

    //排序
    public static void  sort(int[] a){
        heapify(a,a.length);
        //用一个变量表示最右侧的变量，用来记录交换,等于0的时候就剩一个元素了
        for (int right = a.length-1; right >0 ; right--) {
            //每一次最左面，堆顶元素都是最大的。与最后一位交换
            swap(a,0,right);
            //重新调整大顶堆
            down(a,0,right);

        }
    }

    
    //建堆，不断利用下潜算法建堆
    private static void heapify(int[] array,int size){
        //array.length/2-1 >=0
        for (int i = size/2-1; i >=0 ; i--) {
            down(array,i,size);
        }
    }

    //下潜
    public static void down(int[]array,int parent,int size){
        //这里down方法用非递归实现
        while(true){
            //左孩子索引，有一定的规律
            int left=parent*2+1;
            int right=left+1;
            int max=parent;//假设自己是最大的
            //这两波交换的结果就是parent与两个子节点中最大值进行交换
            if(left<size&&array[left]>array[max]){
                max=left;
            }
            if(right<size&&array[right]>array[max]){
                max=right;
            }
            if(max==parent){
                //没有找到孩子,退出
                break;
            }
            if(max!=parent){
                //如果找到了最大的孩子进行下潜，如果找不到孩子了，就退出
                swap(array,max,parent);
                //更新一下父亲的位置
                parent=max;
            }
        }

    }
    //交换
    private static void swap(int[] array, int max, int parent) {
        int temp=array[max];
        array[max]=array[parent];
        array[parent]=temp;
    }

}
