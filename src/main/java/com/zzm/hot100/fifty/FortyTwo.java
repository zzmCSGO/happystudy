package com.zzm.hot100.fifty;

import java.util.LinkedList;

/**
 * @BelongsProject: leet
 * @BelongsPackage: com.zzm.hot100.fifty
 * @Author: zzm
 * @CreateTime: 2024-02-02  21:13
 * @Description: TODO
 * @Version: 1.0
 */
//42.接雨水 单调栈
public class FortyTwo {

    public int trap(int[] heights) {

        LinkedList<Data> stack = new LinkedList<>();
        int sum=0;
        for (int i = 0; i < heights.length; i++) {
            Data right=new Data(i,heights[i]);
            //把栈内小于加入柱子高度的元素全部弹出
            while(!stack.isEmpty()&&stack.peek().height< right.height){
                //4324
                Data pop = stack.pop();
                Data left = stack.peek();
                if(left!=null){//计算水的容量
                    int width=right.index-left.index-1;
                    int height = Math.min(left.height, right.height) - pop.height;//中间的高度
                    sum+=width*height;
                }
            }
            stack.push(right);
        }
        return -1;
    }

    static class Data{
        int index;
        int height;

        public Data(int index, int height) {
            this.index = index;
            this.height = height;
        }
    }

}
