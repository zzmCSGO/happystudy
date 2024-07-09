package com.zzm.hot100.fifty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @BelongsProject: leet
 * @BelongsPackage: com.zzm.hot100.forty
 * @Author: zzm
 * @CreateTime: 2024-01-28  15:46
 * @Description: TODO
 * @Version: 1.0
 */
//47.全排列2 ，不重复版本
public class FortySeven {
    public static void main(String[] args) {

    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res= new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums,new boolean[nums.length],new LinkedList<>(),res);
        return res;


    }

    public void dfs(int[] nums,boolean[] visited,LinkedList<Integer> stack,List<List<Integer>> res){
        if(stack.size()==nums.length){
            res.add(new ArrayList<>(stack));
            return;
        }

        for(int i=0;i<nums.length;i++){
            if (i>0&&nums[i]==nums[i-1] && !visited[i-1]) {
                continue;//前面的相同数字没有呗访问过的话就结束本次循环，剪枝
            }
            //如果这个数字没被固定
            if(!visited[i]){
                stack.push(nums[i]);
                //固定第n个数字
                visited[i]=true;
                //递归
                dfs(nums,visited,stack,res);
                //回溯
                visited[i]=false;
                stack.pop();
            }
        }
    }

}
