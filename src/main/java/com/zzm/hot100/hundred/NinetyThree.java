package com.zzm.hot100.hundred;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: leet
 * @BelongsPackage: com.zzm.hot100.hundred
 * @Author: zzm
 * @CreateTime: 2024-02-19  12:55
 * @Description: TODO
 * @Version: 1.0
 */
//93. 复原IP地址
public class NinetyThree {
    public static void main(String[] args) {
        NinetyThree ninetyThree = new NinetyThree();
        List<String> strings = ninetyThree.restoreIpAddresses("25525511135");
        System.out.println(strings);
    }
    public List<String> restoreIpAddresses(String s) {
        List<String> res=new ArrayList<>();
        StringBuilder stringBuilder=new StringBuilder();
        dfs(s,0,stringBuilder,res);
        return res;
    }

    private void dfs(String s, int start, StringBuilder stringBuilder, List<String> res) {
        //为什么stringBuilder.length()==s.length()+4？因为ip地址有四个部分，每个部分最多三位数，所以最多有12位数，加上三个点，最多15位
        if(start==s.length()&&stringBuilder.length()==s.length()+4){
            //去掉最后一个点
            res.add(stringBuilder.substring(0,stringBuilder.length()-1));
            return;
        }

        for(int i=1;i<=3;i++){
            if(start+i>s.length()){
                break;
            }
            //substring是左闭右开,截取当前从s取到的字符串
            String substring = s.substring(start, start + i);
            //01,011是不允许的
            if(substring.length()>1&&substring.charAt(0)=='0'){
                break;
            }
            int parseInt = Integer.parseInt(substring);
            //判断是否在0-255之间
            if(parseInt>=0&&parseInt<=255){
                stringBuilder.append(substring).append(".");
                //在上一次递归的基础上，再加i个字符
                dfs(s,start+i,stringBuilder,res);
                //回溯  删除最后一个点和i个字符,所以起始位置是-i-1 start:stringBuilder.length()-i-1 end:stringBuilder.length()
                stringBuilder.delete(stringBuilder.length()-1-i,stringBuilder.length());
            }
        }


    }
}
