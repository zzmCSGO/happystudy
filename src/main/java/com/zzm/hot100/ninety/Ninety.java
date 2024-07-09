package com.zzm.hot100.ninety;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

/**
 * @BelongsProject: leet
 * @BelongsPackage: com.zzm.hot100.ninety
 * @Author: zzm
 * @CreateTime: 2024-02-19  22:15
 * @Description: TODO
 * @Version: 1.0
 */
public class Ninety {
    public static void main(String[] args) {
        int[] nums = {1,2,2};
        Ninety ninety = new Ninety();
        List<List<Integer>> lists = ninety.subsetsWithDup(nums);
        System.out.println(lists);
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        for(int i=0;i<=nums.length;i++){
            dfs(i,0,nums,new LinkedList<>(),res);
        }
        List<List<Integer>> r = res.stream().distinct().collect(Collectors.toList());
        return r;
    }

    public void dfs(int n,int start,int[] nums,LinkedList<Integer> stack,List<List<Integer>> res){
        if(stack.size()==n){
            List<Integer> collect = stack.stream().sorted().collect(Collectors.toList());
            res.add(collect);
            return;
        }
        for(int i=start;i<nums.length;i++){
            stack.push(nums[i]);
            dfs(n,i+1,nums,stack,res);
            stack.pop();
        }

    }
}
