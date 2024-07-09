package com.zzm.hot300.twenty;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @BelongsProject: leet
 * @BelongsPackage: com.zzm.hot300.twenty
 * @Author: zzm
 * @CreateTime: 2024-01-29  00:03
 * @Description: TODO
 * @Version: 1.0
 */
//216. 组合总和 III
public class Sixteen {
    public static void main(String[] args) {

    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        int [] nums={1,2,3,4,5,6,7,8,9};
        List<List<Integer>> res=new LinkedList<>();
        dfs(0,n,k,nums,new LinkedList<>(),res);
        return res;
    }

    public void dfs(int start,int target,int k,int [] nums,LinkedList<Integer> stack,List<List<Integer>> res){
        if(target==0&&stack.size()==k){
            res.add(new ArrayList<>(stack));
            return;
        }

        for(int i=start;i<nums.length;i++){
            if(target-nums[i]<0){
                continue;
            }
            stack.push(nums[i]);
            dfs(i+1,target-nums[i],k,nums,stack,res);
            stack.pop();
        }
    }
}
