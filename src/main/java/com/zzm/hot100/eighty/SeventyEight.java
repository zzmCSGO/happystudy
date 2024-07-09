package com.zzm.hot100.eighty;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @BelongsProject: leet
 * @BelongsPackage: com.zzm.hot100.eighty
 * @Author: zzm
 * @CreateTime: 2024-02-19  21:02
 * @Description: TODO
 * @Version: 1.0
 */
//78. 子集
public class SeventyEight {
    public static void main(String[] args) {
        SeventyEight seventyEight = new SeventyEight();
        int[] nums = {1,2,3};
        List<List<Integer>> subsets = seventyEight.subsets(nums);
        System.out.println(subsets);
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res= new ArrayList<>();
        for (int i = 0; i <=nums.length; i++) {
            dfs(i,0,nums,new LinkedList<>(),res);
        }
        return res;

    }


    public void dfs(int n, int start,int[] nums,LinkedList<Integer> stack, List<List<Integer>> res){
        if(stack.size()==n){
            res.add(new ArrayList<>(stack));
            return;
        }
        for(int i=start;i<nums.length;i++){
            stack.push(nums[i]);
            dfs(n,i+1,nums,stack,res);
            stack.pop();
        }
    }
}
