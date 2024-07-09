package com.zzm.hot100.eighty;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @BelongsProject: leet
 * @BelongsPackage: com.zzm.hot100.seventy
 * @Author: zzm
 * @CreateTime: 2024-01-28  16:03
 * @Description: TODO
 * @Version: 1.0
 */
//77.组合
public class SeventySeven {
    public static void main(String[] args) {

    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res= new ArrayList<>();
        dfs(1,n,new LinkedList<>(),res,k);
        return res;
    }

    public void dfs(int start,int n,  LinkedList<Integer> stack, List<List<Integer>> res, int k){
        if(stack.size()==k){
            res.add(new ArrayList<>(stack));
            return;
        }
        //i=1,2,3,4
        for (int i = start; i <=n; i++) {
            //k-stack.length 还差几个能凑满
            //n-i+1:还剩几个备用数字
            if(k-stack.size()>n-i+1){
                break;
            }
            stack.push(i);
            dfs(i+1,n,stack,res,k);
            stack.pop();
        }
    }


}
