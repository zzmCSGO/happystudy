package com.zzm.niuke;

import java.util.HashMap;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @BelongsProject: leet
 * @BelongsPackage: com.zzm.niuke
 * @Author: zzm
 * @CreateTime: 2024-02-27  21:15
 * @Description: TODO
 * @Version: 1.0
 */
//数组中出现次数超过一半的数字
public class FiftyOne {
    public int MoreThanHalfNum_Solution (int[] numbers) {
        // write code here
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<numbers.length;i++){
           //如果没有这个数则创建，有则加1
            if(map.containsKey(numbers[i])){
                map.put(numbers[i],map.get(numbers[i])+1);
            }else{
                map.put(numbers[i],1);
            }
        }
        for(int i=0;i<numbers.length;i++){
            if(map.get(numbers[i])>numbers.length/2){
                return numbers[i];
            }
        }
        return 0;


    }
}
