package com.zzm.hot100.twenty;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: leet
 * @BelongsPackage: com.zzm.hot100
 * @Author: zzm
 * @CreateTime: 2024-01-13  14:50
 * @Description: TODO
 * @Version: 1.0
 */
public class Fourteen {
    public static void main(String[] args) {
//        String [] strs={"dog","racecar","car"};
        String [] strs={"flower","flow","flight"};
//        String [] strs={"aca","cba"};
        String res=new Fourteen().longestCommonPrefix(strs);
        System.out.println(res);

    }
    public String longestCommonPrefix(String[] strs) {
        List<StringBuilder> list=new ArrayList();

        //给每个builder赋值
        for(int i=0;i<strs.length;i++){
            StringBuilder sb=new StringBuilder(strs[i]);
            list.add(sb);
        }

        String result="";
        int min=0;
        for(int i=0;i<list.size();i++){
            if(i==0){
                min=list.get(i).length();
            }else{
                min=Math.min(min,list.get(i).length());
            }
        }
        int count=0;
        for(int i=0;i<min;i++){
            String res="";
            //遍历每个字符串的首字母
            for(int j=0;j<list.size();j++){
                 res=String.valueOf(list.get(0).charAt(i));
                if(res.equals(list.get(j).charAt(i)+"")){
                    count++;
                }else{
                    //跳出所有的循环
                    return res=result.equals("")?"":result;
                }
            }
            if(count==list.size()){
                result=result+res;
                count=0;
            }
        }
        return result;
    }


    public String plus(String [] strs){

        if (strs == null || strs.length == 0) {
            return "";
        }
        int length = strs[0].length();
        int count = strs.length;
        for (int i = 0; i < length; i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < count; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];

    }
}
