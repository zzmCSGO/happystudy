package com.zzm.niuke;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @BelongsProject: leet
 * @BelongsPackage: com.zzm.niuke
 * @Author: zzm
 * @CreateTime: 2024-03-19  13:29
 * @Description: TODO
 * @Version: 1.0
 */
//求滑动窗口最大值

public class BM45 {

    public static void main(String[] args) {
        int[] num={2,3,4,2,6,2,5,1};
        int size=3;
        System.out.println(maxInWindows(num, size));
    }

    public static ArrayList<Integer> maxInWindows (int[] num, int size) {
        // write code here
        //创建一个单调递减队列
        LinkedList<Integer> queue=new LinkedList<>();
        //2,3,4,2,6,2,5,1
        ArrayList<Integer> res=new ArrayList<>();
        for(int i=0;i<num.length;i++){
            int n=num[i];
            if(i>=size&&queue.peek()==num[i-size]){
                queue.pollFirst();
            }
            //4,3,2,6
            while(!queue.isEmpty()&&n>queue.peekLast()){
                queue.pollLast();
            }
            queue.offerLast(n);
            if(i>=(size-1)){
                //队头是最大的
                res.add(queue.peekFirst());
            }
        }
        return res;

    }

}
