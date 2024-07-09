package com.zzm;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @BelongsProject: leet
 * @BelongsPackage: com.zzm
 * @Author: zzm
 * @CreateTime: 2024-03-12  13:52
 * @Description: TODO
 * @Version: 1.0
 */
public class Exercise {



    public static void main(String[] args) throws InterruptedException {
        jump(new int[]{2,3,1,1,4,2,1});


    }

    public static  int jump(int[] nums) {

        //2 3 1 1 4 2 1
        int end=0;//表示上次跳跃可达范围右边界。(下次的最右起跳点)
        int maxPosition=0;//目前能跳的最远位置
        int steps=0;
        //-1
        for(int i=0;i<nums.length-1;i++){
            //贪心，每一次都找能跳的最远的
            maxPosition=Math.max(maxPosition,nums[i]+i);
            //到达上次跳跃的右边界,如果能跳到的最大位置要是大于等于数组长度，直接返回
            if(i==end){
                //目前能跳的最远的变成了下次起跳位置的右边界
                end=maxPosition;
                steps++;//进入下一次跳跃
            }
        }
        return steps;

    }





}
