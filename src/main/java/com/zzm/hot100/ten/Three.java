package com.zzm.hot100.ten;

import java.util.HashMap;

/**
 * @BelongsProject: leet
 * @BelongsPackage: com.zzm.hot100.ten
 * @Author: zzm
 * @CreateTime: 2024-01-29  19:42
 * @Description: TODO
 * @Version: 1.0
 */
//3.无重复字符的最长子串
public class Three {
    public static void main(String[] args) {

    }

    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> map =new HashMap<>();
        int begin=0;//
        int maxLength=0;
        for(int end=0;end<s.length();end++){
            char ch=s.charAt(end);
            if(map.containsKey(ch)){
                //在原来索引位置+1
                //防止回退
                begin=Math.max(begin,map.get(ch)+1); //map.get(ch)+1为新的起点
                //hash表里始终保存最新的索引
                map.put(ch,end);
            }else{
                map.put(ch,end);
            }
            maxLength=Math.max(maxLength,end-begin+1);
            // System.out.println(s.substring(begin,end+1)) ;
        }
        return maxLength;
        
    }
}
