package com.zzm.cz.meituan.third;

import java.util.HashMap;

/**
 * @BelongsProject: happystudy
 * @BelongsPackage: com.zzm.meituan.third
 * @Author: zzm
 * @CreateTime: 2024-03-23  10:16
 * @Description: TODO
 * @Version: 1.0
 */
public class Fourth {

//    定义一个字符串的权值为:字符串长度乘以字符的种类数。例如，"arcaea的双疆为 6*4=24
//    现有一个字符串，将该字符串切割成若千个连续子串，便得每个子串的权值不小于k。求出最终最多可以切割出的子串数量。
//    请注意，由于字符串过长，给出的字符串将是以连续段长度形式给出，例如:aabbaaa将描述为 a(2)b(2)a(3)，aaaaaaaaaaaab 将插述为 a(12)b(1)
//
//    第一行输入一个两个正整数n,k，代表原字符用长度和每个子串至少应取的权值第二行一个仅包含小写字母、数字和括号的字符用。长度不超过10，
//    保证所有括号内的数字之和恰好等于n。给定的每个字母后面必然包含一个括号加数字 //1 ≤ k,n ≤ 10的18次方


//    如果整个字符申的权值小于k，请直接输出 -1。否则输出一个正整数，代表可以切割的最多子串数量

  //给出答案
    private static int count=0;


    public static void main(String[] args) {
        Fourth f=new Fourth();
        String s="a(2)b(2)a(3)";
        //转为正常字符串aabbaaa
        String s1 = f.getStr(s);
        //计算权值
        int weight = getWeight(s1);
        System.out.println(s1);
        System.out.println(weight);
        int i = f.maxSubstrings(s1, 6);
        System.out.println(i);

    }

    //对字符串进行解析，递归解析，记录满足条件的子串数量
    public int maxSubstrings(String s,int k) {
        dfs(s,k,7);
        return count;
    }

    private static void dfs(String s,int k,int m) {
        //不符合条件的直接返回
        if(getWeight(s)<=k){
            return;
        }
        if(m==s.length()){
            return;
        }



        //符合条件的，记录数量
        for(int i=0;i<s.length();i++){
            //从当前字符串合法，再去遍历子串
           //记录当前的字符串
            String s1=s.substring(0,i+1);
            //如果当前的字符串权值大于k，就继续递归
            if(getWeight(s1)>=k){
                count++;
                //将该字符串后面的字符串继续递归
                String s2=s.substring(i);
                dfs(s2,k,m-s1.length());
            }
        }


    }

    private static String getStr(String s) {
        StringBuilder sb=new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c=='('){
                int count = s.charAt(i + 1) - '0';
                for (int j = 0; j < count; j++) {
                    sb.append(s.charAt(i-1));
                }
            }
        }
        return sb.toString();
    }


    //计算权值的函数抽取
    private static int getWeight(String s){
        char [] chars=s.toCharArray();
        int n=0;//记录字符串种类数
        //遍历chars，遇到不同的字符种类就加1
        HashMap<Character,Character> map=new HashMap<>();
        for(char ch:chars){
            if(!map.containsKey(ch)){
                map.put(ch,ch);
                n++;
            }
        }
        return chars.length*n;
    }



}
