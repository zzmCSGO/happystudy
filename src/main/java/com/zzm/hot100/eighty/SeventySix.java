package com.zzm.hot100.eighty;

import java.util.Arrays;

/**
 * @BelongsProject: leet
 * @BelongsPackage: com.zzm.hot100.eighty
 * @Author: zzm
 * @CreateTime: 2024-02-19  17:24
 * @Description: TODO
 * @Version: 1.0
 */
public class SeventySix {
    public static void main(String[] args) {
        String s="ADOBECODEBANC";
        String t="ABC";
        System.out.println(minWindow(s,t));
    }

    static String minWindow(String s,String t){
        char[] target=t.toCharArray();
        int[] targetCount=new int[128];//一共有128个字符
        for(char ch:target){
            targetCount[ch]++;
        }
        int passTotal=0;//满足目标串中的条件总数
        for(int count:targetCount){
            if(count>0){
                passTotal++;
            }
        }
        int passed=0;//已经通过的条件数

        //拿到原始串的字符数组
        char[] source=s.toCharArray();
        int [] sourceCount=new int[128];//记录原始串中i~j内个字符串出现的次数
        int i=0;
        int j=0;
        Result res=null;
        while(j<source.length){
            char right=source[j];
            sourceCount[right]++;

            if(sourceCount[right]==targetCount[right]){
                passed++;
            }
            //若通过条件数已经满足所有条件，缩小i范围，更新范围内字符计数和通过条件数
            while(passed==passTotal&&i<=j){
                if(res==null){
                    res=new Result(i,j);
                }else{
                    if(j-i<res.j-res.i){
                        res.i=i;
                        res.j=j;
                    }
                }
                char left=source[i];
                sourceCount[left]--;
                //0<1
                if(sourceCount[left]<targetCount[left]){
                    passed--;
                }
                i++;
            }
            j++;
        }
        return res==null?"":s.substring(res.i,res.j+1);
    }

    static class Result{
        int i;
        int j;

        public Result(int i,int j){
            this.i=i;
            this.j=j;
        }
    }
}
