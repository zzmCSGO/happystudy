package com.zzm.hot100.forty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @BelongsProject: leet
 * @BelongsPackage: com.zzm.hot100.forty
 * @Author: zzm
 * @CreateTime: 2024-01-28  23:35
 * @Description: TODO
 * @Version: 1.0
 */
//40.组合之和2
public class Forty {
    public static void main(String[] args) {

    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res= new ArrayList<>();
        Arrays.sort(candidates);
        dfs(0,candidates,new boolean[candidates.length],target,new LinkedList<>(),res);
        return res;

    }

    public void dfs(int start,int[] candidates,boolean[] visited,int target,LinkedList<Integer> stack,List<List<Integer>> res){

        if(target==0){
            res.add(new ArrayList<>(stack));
        }

        for(int i=start;i<candidates.length;i++){
            if(target<candidates[i]){
                continue;
            }
            if(i>0&&candidates[i]==candidates[i-1]&&!visited[i-1]){
                continue;
            }
            visited[i]=true;
            stack.push(candidates[i]);
            dfs(i+1,candidates,visited,target-candidates[i],stack,res);
            stack.pop();
            visited[i]=false;
        }
    }
}
