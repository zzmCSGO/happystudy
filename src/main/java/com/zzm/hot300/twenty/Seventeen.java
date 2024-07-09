package com.zzm.hot300.twenty;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @BelongsProject: leet
 * @BelongsPackage: com.zzm.hot300.twenty
 * @Author: zzm
 * @CreateTime: 2024-01-29  21:37
 * @Description: TODO
 * @Version: 1.0
 */
//217存在重复元素
public class Seventeen {
    public static void main(String[] args) {

    }

    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer,Object> map=new HashMap<>();
        Object value=new Object();
        for(int key:nums){
            Object put=map.put(key,value );
            if(put!=null){
                return true;
            }
        }
        return false;
    }

//    public boolean containsDuplicate(int[] nums) {
//        HashSet<Integer> set=new HashSet<>();
//        for(int key:nums){
//          if(!set.add(key)){
//              return true;
//          }
//        }
//        return false;
//    }
}
