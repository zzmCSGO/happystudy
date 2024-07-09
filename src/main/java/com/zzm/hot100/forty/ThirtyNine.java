package com.zzm.hot100.forty;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @BelongsProject: leet
 * @BelongsPackage: com.zzm.hot100.forty
 * @Author: zzm
 * @CreateTime: 2024-01-28  17:26
 * @Description: TODO
 * @Version: 1.0
 */
//39.组合总和
public class ThirtyNine {
    public static void main(String[] args) {
        ThirtyNine thirtyNine = new ThirtyNine();
        int[] nums = {2,3,6,7};
        List<List<Integer>> lists = thirtyNine.combinationSum(nums, 7);
        System.out.println(lists);

    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res=new ArrayList<>();
        dfs(0,candidates,target,new LinkedList<>(),res);
        return res;
    }

    //组合中为了避免重复，总会设置一个start来记录起点
    public void dfs(int start,int[] candidates, int target, LinkedList<Integer> stack, List<List<Integer>> res){

        if(target==0){
            res.add(new ArrayList<>(stack));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            //剪枝
            if(target-candidates[i]<0){
                continue;
            }
            stack.push(candidates[i]);
            dfs(i,candidates,target-candidates[i],stack,res);
            stack.pop();
        }
    }
}
