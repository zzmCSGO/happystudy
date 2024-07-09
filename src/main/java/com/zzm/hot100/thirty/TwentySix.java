package com.zzm.hot100.thirty;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @BelongsProject: leet
 * @BelongsPackage: com.zzm.hot100
 * @Author: zzm
 * @CreateTime: 2024-01-17  12:58
 * @Description: TODO
 * @Version: 1.0
 */
//26.删除有序数组中的重复项
public class TwentySix {
    public static void main(String[] args) {
        int[] nums={1,1,2};
        System.out.println(new TwentySix().removeDuplicates(nums));

    }
    public int removeDuplicates(int[] nums) {
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            list.add(nums[i]);
        }
        //用stream流去重
        List<Integer> res = list.stream().distinct().collect(Collectors.toList());
        for(int i=0;i<res.size();i++){
            nums[i]=res.get(i);
        }
        return res.size();
    }
}
