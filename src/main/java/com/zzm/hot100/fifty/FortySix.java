package com.zzm.hot100.fifty;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @BelongsProject: leet
 * @BelongsPackage: com.zzm.hot100.forty
 * @Author: zzm
 * @CreateTime: 2024-01-28  15:17
 * @Description: TODO
 * @Version: 1.0
 */
//46.
public class FortySix {
    public static void main(String[] args) {


    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        dfs(nums,new boolean[nums.length],new LinkedList<>(),res);
//        List<List<Integer>> collect = res.stream().distinct().collect(Collectors.toList());
        return res;
    }

    static void dfs(int[] nums, boolean[] visited, LinkedList<Integer> stack, List<List<Integer>> res){
        if(stack.size()==nums.length){

            res.add(new ArrayList<>(stack));//不用一个地址对象，创建一个新的对象
            return ;
        }
        //遍历nums数组，发现没有被使用的数组，则将其标记为使用，并加入stack
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                stack.push(nums[i]);
                visited[i]=true;//标记为已使用
                dfs(nums,visited,stack,res);
                visited[i]=false;//回溯,用完了就给他标记为未使用
                stack.pop();//回溯，弹出来
            }
        }
    }



}
