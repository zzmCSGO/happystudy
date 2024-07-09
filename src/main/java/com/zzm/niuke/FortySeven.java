package com.zzm.niuke;

/**
 * @BelongsProject: leet
 * @BelongsPackage: com.zzm.niuke
 * @Author: zzm
 * @CreateTime: 2024-03-03  17:49
 * @Description: TODO
 * @Version: 1.0
 */
public class FortySeven {
    public int findKth (int[] a, int n, int K) {
        // write code here
        quickSort(a,0,n-1);
        return a[K-1];
    }

    public void quickSort(int[] a,int left,int right){
        if(left>=right){
            return;
        }
        int p=partition(a,left,right);
        quickSort(a,left,p-1);
        quickSort(a,p+1,right);
    }

    public int partition(int[] a,int left,int right){
        int pv=a[right];//基准点
        int i=left;
        int j=left;
        while(j<right){
            if(a[j]<pv){
                //找到比基准点更小的了
                if(i!=j){
                    swap(a,i,j);
                }
                i++;
            }
            j++;
        }
        swap(a,i,right);
        return i;
    }

    public void swap(int[] a,int i,int j){
        int temp=a[i];
        a[i]=a[j];
        a[j]=temp;
    }


    public static void main(String[] args) {
        int[] a={10,10,9,9,8,7,5,6,4,3,4,2};//1,2,2,3,4,5 n-k+1
        FortySeven fs=new FortySeven();
        int kth = fs.findKth(a, 12, 9);
        System.out.println(kth);
    }
}
