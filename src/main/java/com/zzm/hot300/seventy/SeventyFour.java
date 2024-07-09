package com.zzm.hot300.seventy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @BelongsProject: happystudy
 * @BelongsPackage: com.zzm.hot300.seventy
 * @Author: zzm
 * @CreateTime: 2024-03-30  14:27
 * @Description: TODO
 * @Version: 1.0
 */
//274.H 指数
public class SeventyFour {

    public static void main(String[] args) {
        int[] citations={1,1};
        System.out.println(hIndex(citations));
    }

    public static int hIndex(int[] citations) {
        Arrays.sort(citations);
        //0,1,3,5,6
        int len=citations.length;
        //引用次数，引用次数的数量
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=len;i>0;i--){
            for(int j=len-1;j>=0;j--){
                if(citations[j]>=i){
                    map.merge(i,1,Integer::sum);
                }else{
                    break;
                }
            }
        }
        AtomicInteger max= new AtomicInteger();
        map.forEach((k,v)->{
            if(k>=v){
                max.set(Math.max(max.get(), v));
            }
        });

        return max.get();
    }
}

class RandomizedSet {

    private HashMap<Integer,Integer> map=new HashMap<>();

    public RandomizedSet() {

    }

    public boolean insert(int val) {
        if(map.containsKey(val)){
            return false;
        }else{
            map.put(val,val);
            return true;
        }

    }

    public boolean remove(int val) {
        if(map.containsKey(val)){
            map.remove(val);
            return true;
        }else{
            return false;
        }

    }


}
