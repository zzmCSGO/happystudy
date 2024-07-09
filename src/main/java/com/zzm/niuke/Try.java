package com.zzm.niuke;

import java.util.Arrays;

/**
 * @BelongsProject: leet
 * @BelongsPackage: com.zzm.niuke
 * @Author: zzm
 * @CreateTime: 2024-03-04  09:24
 * @Description: TODO
 * @Version: 1.0
 */
public class Try {

    public void sort(int[] a){
        quick(a,0,a.length-1);
    }

    public void quick(int[]a ,int left,int right){
        //递归终止条件
        if(left>=right){
            return;
        }
        int p=partition(a,left,right);
        quick(a,left,p-1);
        quick(a,p+1,right);
    }

    public int partition(int []a,int left,int right){
        int pv=a[right];
        int i=left;
        int j=left;
        while (j<right){
            if(a[j]<a[pv]){
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

    public void swap(int[]a ,int left,int right){
        int temp=a[left];
        a[left]=a[right];
        a[right]=temp;
    }



    public void sort2(int[] a){
        int []b=new int[a.length];
        split(a,0,a.length-1,b);
    }

    public void split(int []a,int left,int right,int[] b){
        if(left==right){
            return;
        }
        int mid=(left+right)/2;
        split(a,left,mid,b);
        split(a,mid+1,right,b);
        merge(a,left,mid,mid+1,right,b);
        System.arraycopy(b,left,a,left,right-left+1);
    }

    public void merge(int[]a,int i,int iEnd,int j,int jEnd,int [] b){
        int k=i;
        while(i<=iEnd&&j<=jEnd){
            if(a[i]>a[j]){
                b[k]=a[j];
                j++;
            }else{
                b[k]=a[i];
                i++;
            }
            k++;
        }
        if(i>iEnd){
            System.arraycopy(a,j,b,k,jEnd-j+1);
        }
        if(j>jEnd){
            System.arraycopy(a,i,b,k,iEnd-i+1);
        }
    }

    public static void main(String[] args) {
        int[] a={3,2,5,1};
        Try b=new Try();
        b.sort2(a);
        System.out.println(a);
    }
}
