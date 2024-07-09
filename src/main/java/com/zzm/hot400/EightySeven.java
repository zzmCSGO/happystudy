package com.zzm.hot400;

import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @BelongsProject: leet
 * @BelongsPackage: com.zzm.hot400
 * @Author: zzm
 * @CreateTime: 2024-01-29  21:59
 * @Description: TODO
 * @Version: 1.0
 */
//387.字符串中的第一个唯一字符
public class EightySeven {
    public static void main(String[] args) {
//        String s="loveleetcode";
//        String s="aabb";
        String s="leetcode";
        int i = firstUniqChar(s);
        System.out.println(i);
    }
    public static int firstUniqChar(String s) {

        char[] chars = s.toCharArray();
        HashMap<Character,Integer> map =new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            if(!map.containsKey(chars[i])){
                map.put(chars[i],i);
            }else{
                map.put(chars[i],-1);
            }
        }
        AtomicReference<Integer> res= new AtomicReference<>(Integer.MAX_VALUE);
        map.forEach((k,v)->{
            if(v!=-1){
                res.set(Math.min(v, res.get()));
            }
        });
        return res.get()==Integer.MAX_VALUE?-1:res.get();
    }

    public static int firstUniqCharTwo(String s){
        int[] array=new int[26];
        char[] chars = s.toCharArray();
        for(char ch:chars){
            array[ch-97]++;
        }
        for (int i = 0; i < chars.length; i++) {
            char ch=chars[i];
            if(array[ch-97]==1){
                return i;
            }
        }
        return -1;
    }


}
