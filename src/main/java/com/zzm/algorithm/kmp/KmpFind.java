package com.zzm.algorithm.kmp;

import java.util.Arrays;

/**
 * @BelongsProject: leet
 * @BelongsPackage: com.zzm.algorithm.kmp
 * @Author: zzm
 * @CreateTime: 2024-02-22  21:31
 * @Description: TODO
 * @Version: 1.0
 */
//字符串匹配
public class KmpFind {

    /*
    最长前后缀数组：只跟模式字符串有关
    1.索引：使用了模式字符串前j个字符串-1
    2.值：最长前后缀的长度（恰好是j所要跳转的位置）
     **/
    static int[] lps(char[] pattern){
//        return new int[]{0,0,1,2,3,0,1};
        int[] lps=new int[pattern.length];
        int i=1;//i是在
        int j=0;
        while(i<pattern.length){
            //遇到相同字符
            if(pattern[i]==pattern[j]){
                lps[i]=j+1;//数组的索引位置
                i++;
                j++;
            }else if(j==0){
                //前面没有匹配到的字符串
                i++;
            }else{
                //前面有匹配到的字符串,跳到哪里取决于j前面有几个字符
                //j-1就是解的位置。
                j=lps[j-1];
            }
        }
        return lps;

    }

    static int strStr(String str1,String str2){
        char[] origin=str1.toCharArray();//原始字符串
        char[] pattern=str2.toCharArray();//模式字符串
        int[] lps=lps(pattern);//最长前后缀数组
        //1.匹配成功:i++,j++，直到j==模式字符串长度
        //2.匹配失败j!=0,跳过最长前后缀字符串，继续匹配.j==0则i++
        int i=0,j=0;//i是在原始字符串的指针，j是在模式字符串的指针
       // pattern.length-j<=origin.length-i;
        while(i<origin.length){
            if(origin[i]==pattern[j]){
                i++;
                j++;
            }else if(j==0){
                //模式字符串和原始字符串的字符不匹配
                i++;
            }else{
                j=lps[j-1];
            }
            if(j==pattern.length){
                //找到解
//                return i-pattern.length;
                // 第一个判断中的i++;//当i遍历到6的时候，如果仍然相等，那么找到解还会再+1，所以i可以取到7，只是不进入下一层循环了
                return i-j;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(strStr("abaabab","abab"));
        System.out.println("abaabab".indexOf("abab"));
        System.out.println(Arrays.toString(lps("abcabc".toCharArray())));
    }


}
