package com.zzm.algorithm.sort;

/**
 * @BelongsProject: leet
 * @BelongsPackage: com.zzm.algorithm.sort
 * @Author: zzm
 * @CreateTime: 2024-03-21  12:44
 * @Description: TODO
 * @Version: 1.0
 */
public class AllSort {

    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 5, 4, 7, 6, 9, 8};
        int[] array=new int[arr.length];
//        split(arr, 0,array.length-1,array);
        heapSort(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }


    //快排
    public static void quickSort(int[] arr,int left,int right){
        if(left>=right){
            return;
        }
        int p=partition(arr,left,right);
        quickSort(arr,left,p-1);
        quickSort(arr,p+1,right);
    }

    public static int partition(int[] arr,int left,int right){
        //定义基准点
        int p=arr[right];
        int i=left;//遇到比基准点大的就停下来
        int j=left;//找基准点小的
        while(j<right){
            if(arr[j]<p){
                //找到比基准点小的了
                if(i!=j){
                    swap(arr,i,j);
                }
                i++;
            }
            j++;
        }
        swap(arr,i,right);
        return i;
    }


    //归并排序
    public static void split(int[] arr, int left,int right,int[] array){
        //拆分数组
        if(left>=right){
            return;
        }
        int mid=(left+right)/2;
        split(arr,left,mid,array);
        split(arr,mid+1,right,array);
        merge(arr,left,mid,mid+1,right,array);
        System.arraycopy(array,left,arr,left,right-left+1);
    }

    public static void merge(int[] arr,int i,int iEnd,int j,int jEnd,int[] array){
        int k=i;
        while(i<=iEnd&&j<=jEnd){
            if(arr[i]<arr[j]){
                array[k]=arr[i];
                i++;
            }else{
                array[k]=arr[j];
                j++;
            }
            k++;
        }

        if(i>iEnd){
            System.arraycopy(arr,j,array,k,jEnd-j+1);
        }
        if(j>jEnd){
            System.arraycopy(arr,i,array,k,iEnd-i+1);
        }

    }


    //堆排序
    public static void heapSort(int[] arr){
        //建堆
        heapify(arr,arr.length);
        for(int i=arr.length-1;i>0;i--){
            swap(arr,0,i);
            down(arr,0,i);
        }

    }

    //建堆
    public static void heapify(int[] arr,int size){
        for(int i=size/2-1;i>=0;i--){
            down(arr,i,size);
        }
    }

    //下降
    public static void down(int[] arr,int parent,int size){
        while(true){
            int left=2*parent+1;
            int right=left+1;
            int max=parent;
            if(left<size&&arr[left]>arr[max]){
                //如果左边比右边大
                max=left;
            }
            if(right<size&&arr[right]>arr[max]){
                max=right;
            }
            if(max==parent){
                break;
                //没有发生交换
            }
            if(max!=parent){
                swap(arr,max,parent);
                parent=max;
            }
        }
    }




    public static void swap(int [] arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}
