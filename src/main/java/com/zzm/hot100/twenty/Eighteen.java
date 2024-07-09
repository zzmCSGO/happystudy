package com.zzm.hot100.twenty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @BelongsProject: leet
 * @BelongsPackage: com.zzm.hot100
 * @Author: zzm
 * @CreateTime: 2024-01-15  12:00
 * @Description: TODO
 * @Version: 1.0
 */
// 18. 四数之和
public class Eighteen {
    public static void main(String[] args) {
        int [] nums={1000000000,1000000000,1000000000,1000000000};
        System.out.println(new Eighteen().fourSum(nums,-294967296));

    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        LinkedList<Integer> stack = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        dfs(4,0,nums.length-1,target,nums,stack,res);
        return res;
    }

    static void dfs(int n,int i,int j,long target,int [] nums,LinkedList<Integer> stack,List<List<Integer>> result){

        if(n==2){
            //两数之和
            twoSum(i,j,nums,target,stack,result);
            return ;

        }
        for (int k = i; k <j-(n-2) ; k++) { //k代表固定的数字，四数之和(后三个数字不需要固定)可以i<j-2,三数之和(需要留两个数字)可以i<j-1
            //检查左边界是否重复,防止越界，第一个数字不用检查重复
            if(k>i&&nums[k]==nums[k-1]){
                //当前数字等于上一个数字，跳过该数字，尝试下一个数字
                continue;
            }
            //固定一个数字，再尝试n-1数字之和
            stack.push(nums[k]);
            dfs(n-1,k+1,j,target-nums[k],nums,stack,result);
            //固定的数字遍历之后，弹出
            stack.pop();
        }

    }

    static public void twoSum(int i,int j,int[] nums, long target,LinkedList<Integer> stack,List<List<Integer>> result) {
        while(i<j){
            //nums[j]是最右边的数字
            long sum=nums[i]+nums[j];
            if(sum<target){
                i++;
            }else if(sum>target){
                j--;
            }else{
                //找到解
                ArrayList<Integer> list = new ArrayList<>(stack);//固定的数字
                list.add(nums[i]);
                list.add(nums[j]);
                result.add(list);
                //继续查找其它的解，缩小范围
                i++;
                j--;
                while (i<j&&nums[i]==nums[i-1]){
                    i++;
                }
            }
        }
    }


}
