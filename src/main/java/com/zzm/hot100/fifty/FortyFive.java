package com.zzm.hot100.fifty;

/**
 * @BelongsProject: leet
 * @BelongsPackage: com.zzm.hot100.fifty
 * @Author: zzm
 * @CreateTime: 2024-02-17  20:44
 * @Description: TODO
 * @Version: 1.0
 */
//45. 跳跃游戏 II
public class FortyFive {


    public int jump(int[] nums) {
        int end=0;//使用 end 记录这次跳跃的边界，到达边界就跳跃次数 + 1
        int maxPosition=0;//使用 maxPosition 记录目前能够跳到的最高位置
        int steps=0;
        //找能跳的最远的
        for (int i = 0; i < nums.length-1; i++) {
            //每次遍历都会遍历[start,end]区间内的元素，找到这个区间内能跳的最远的
            maxPosition=Math.max(maxPosition,nums[i]+i);
            if(i==end){ ////遇到边界，就更新边界，并且步数加一
                end=maxPosition;
                steps++;
            }

            if(end>=nums.length-1){
                break;
            }
        }
        return steps;
    }
}
