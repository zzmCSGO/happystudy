package com.zzm.cz.ant;

import java.util.*;

/**
 * @BelongsProject: happystudy
 * @BelongsPackage: com.zzm.cz.ant
 * @Author: zzm
 * @CreateTime: 2024-04-06  19:14
 * @Description: TODO
 * @Version: 1.0
 */
public class First {

    //kmp算法
    public static void main(String[] args) {
        String str1="aaaaa";
        String pattern="bba";
        System.out.println(kmp_search(str1,pattern));
    }

    //先求出模式字符串的最长前后缀数组

    public static int[] next(String pattern) {
        //计算next数组
        //next数组每一项代表：当前子串最长前缀后缀的长度
        int[] next = new int[pattern.length()];
        next[0] = 0;//数组的初始值为0
        int i = 1;//i为模板字符串的指针
        int prefix_len = 0;//当前共同前后缀长度
        while (i < pattern.length()) {
            //如果下一个字符仍然相同的话，代表可以构成一个更长的前后缀
            if (pattern.charAt(i) == pattern.charAt(prefix_len)) {
                prefix_len++;
                next[i] = prefix_len;
                i++;
            } else {
                //如果下个字符不同，直接查表next[prefix_len-1],看看表中是否存在更短的前后缀
                //如果不存在，那么当前位置的next值为0
                if (prefix_len == 0) {
                    next[i] = 0;
                    i++;
                } else {
                    //存在更短的前后缀,从上一个更短前缀的位置开始比较，更新前缀位置
                    prefix_len = next[prefix_len - 1];
                }
            }
        }
        return next;
    }


    public static int kmp_search(String str1,String pattern){
        //获得next数组
        int[] next=next(pattern);
        int i=0;//主串中的指针
        int j=0;//模板字符串的指针
        while(i<str1.length()){
            //字符串匹配，i指针永远不会回退
            if(str1.charAt(i)==pattern.charAt(j)){
                i++;
                j++;
            }else if(j>0){
                //如果字符匹配失败，根据next数组回退
                j=next[j-1];//指针上一个位置的值重新进行匹配
            }else{
                //子串第一个字符就匹配失败，主串指针后移
                i++;
            }
            //如果j指针全部匹配完了，说明匹配成功
            if(j==pattern.length()){
                return i-j;//返回字符串的首字符位置
            }
        }
        return -1;
    }



}
