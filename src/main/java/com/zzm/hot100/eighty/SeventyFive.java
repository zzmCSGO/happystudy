package com.zzm.hot100.eighty;

/**
 * @BelongsProject: leet
 * @BelongsPackage: com.zzm.hot100.eighty
 * @Author: zzm
 * @CreateTime: 2024-02-22  14:54
 * @Description: TODO
 * @Version: 1.0
 */
//75.颜色分类
public class SeventyFive {
    public static void main(String[] args) {
        SeventyFive seventyFive = new SeventyFive();
        int[] nums={2,0,2,1,1,0};
        seventyFive.sortColors(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }


    public void sortColors(int[] nums) {
        quickSort(nums,0,nums.length-1);
    }

    public void quickSort(int[] nums,int left,int right){
        if(left>=right){
            return;
        }
        int p=partition(nums,left,right);
        quickSort(nums,left,p-1);
        quickSort(nums,p+1,right);
    }




    public int partition(int[] nums,int left,int right){
        int pv=nums[right];
        int i=left;
        int j=left;
        while(j<right){
            if(nums[j]<pv){
                if(i!=j){
                    swap(nums,i,j);
                }
                //没有找到比pv小的
                i++;
            }
            //找到比pv大的i就不移动了
            j++;
        }
        swap(nums,i,right);
        return i;
    }

    public void swap(int nums[],int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }

    class Solution {
        public void sortColors(int[] nums) {
            int n = nums.length;
            //使用两个指针分别用来交换 0 和 1.用指针 p0交换0，指针 p1交换 1
            int p0 = 0, p1 = 0;
            for (int i = 0; i < n; ++i) {
                if (nums[i] == 1) {
                    int temp = nums[i];
                    nums[i] = nums[p1];
                    nums[p1] = temp;
                    ++p1;
                } else if (nums[i] == 0) {//如果交换的是0，p1和p0都要移动
                    //先交换p0和i
                    int temp = nums[i];
                    nums[i] = nums[p0];
                    nums[p0] = temp;
                    if (p0 < p1) {//如果p0<p1,说明p1已经交换过了，所以要交换一下i和p1
                        temp = nums[i];
                        nums[i] = nums[p1];
                        nums[p1] = temp;
                    }
                    ++p0;
                    ++p1;
                }
            }
        }
    }

}
