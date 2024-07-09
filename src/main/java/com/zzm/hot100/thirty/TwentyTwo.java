package com.zzm.hot100.thirty;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: leet
 * @BelongsPackage: com.zzm.hot100
 * @Author: zzm
 * @CreateTime: 2024-01-16  13:02
 * @Description: TODO
 * @Version: 1.0
 */
//22.括号生成
    //深度优先遍历，剪枝算法。左括号数量应该严格大于右括号才符合规则。
public class TwentyTwo {
    public static void main(String[] args) {
        int n=2;
        System.out.println(new TwentyTwo().generateParenthesis(2));

    }


    public List<String> generateParenthesis(int n) {
        List<String> res=new ArrayList<>();
        dfs("",n,n,res);
        return res;
    }

    public void dfs(String cur,int left,int right,List<String> res){


        if(left==0&&right==0){
            res.add(cur);
            return;
        }

        if(left>right){
            return;
        }

        if(left>0){
            dfs(cur+"(",left-1,right,res);
        }

        if(right>0){
            dfs(cur+")",left,right-1,res);
        }
    }
}
