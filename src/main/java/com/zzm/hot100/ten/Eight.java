package com.zzm.hot100.ten;

import java.util.HashMap;
import java.util.Map;

/**
 * @BelongsProject: leet
 * @BelongsPackage: com.zzm.hot100
 * @Author: zzm
 * @CreateTime: 2024-01-11  17:53
 * @Description: TODO
 * @Version: 1.0
 */
public class Eight {
    public static void main(String[] args) {
        String s="-2147483649";
        System.out.println(new Eight().myAtoi2(s));
        System.out.println(new Eight().myAtoiRight(s));
    }


    public int myAtoi(String s) {

        if(s.equals("")||s.equals("-")||s.equals("+")){
            return 0;
        }
        //记录字符串的前导空格数
        int count=0;
        //过滤空格后的字符
        String s1=s;
        if(s.substring(0,1).equals(" ")){
            count=1;
            for(int i=0;i<s.length();i++){
                if(s.substring(i+1,i+2).equals(" ")){
                    count++;
                }else{
                    break;
                }
            }
            //去除前导空格的字符串
            s1=s.substring(count);
        }

        //如果首字符为字母，直接返回0
        if(!s1.substring(0,1).equals("-")&&!s1.substring(0,1).equals("+")){
            if(s1.charAt(0)<'0'||s1.charAt(0)>'9'){
                return 0;
            }
        }

        //去0
        int count_0=0;
        if(s1.substring(0,1).equals("0")){
            count_0=1;
            for(int i=0;i<s.length();i++){
                if(s1.substring(i+1,i+2).equals("0")){
                    count_0++;
                }else{
                    break;
                }
            }
            //去除前导空格的字符串
            s1=s1.substring(count_0);
        }


        System.out.println(s1);

        if(s1.substring(0,1).equals("-")){
            String temp=s1.substring(1);
            //遍历字符串s1,正则匹配字符0~9
            StringBuffer buffer=new StringBuffer(temp);
            StringBuffer bufferResult=new StringBuffer();
            if(temp.charAt(0)<'0'||temp.charAt(0)>'9'){
                return 0;
            }
            for (int i = 0; i < buffer.length(); i++) {
                if(buffer.charAt(i)>='0'&&buffer.charAt(i)<='9'){
                    bufferResult.append(buffer.charAt(i));
                }else if(buffer.charAt(i)=='.'){
                    break;
                }
                else {
                    //截取索引i之后的字符串
                    String s2=temp.substring(i);
                    //遍历s2,如果遇到0~9的字符，直接返回0
                    for(int j=0;j<s2.length();j++){
                        if(s2.charAt(j)>='0'&&s2.charAt(j)<='9'){
                            return 0;
                        }
                    }
                    break;
                }
            }
            //如果bufferResult全是以0组成的字符串，返回0


            String sResult="-"+bufferResult.toString();
            long sLong=Long.parseLong(sResult);
            if(sLong>Math.pow(2,31)-1||sLong<-Math.pow(2,31)){
                return (int) (-1*Math.pow(2,31)-1);
            }
            int result=Integer.parseInt(sResult);
            return result;

        }else if(s1.substring(0,1).equals("+")) {
            String temp=s1.substring(1);
            //遍历字符串s1,正则匹配字符0~9
            StringBuffer buffer=new StringBuffer(temp);
            StringBuffer bufferResult=new StringBuffer();

            if(temp.charAt(0)<'0'||temp.charAt(0)>'9'){
                return 0;
            }
            for (int i = 0; i < buffer.length(); i++) {
                if(buffer.charAt(i)>='0'&&buffer.charAt(i)<='9'){
                    bufferResult.append(buffer.charAt(i));
                }else if(buffer.charAt(i)=='.'){
                    break;
                }
                else {
                    //截取索引i之后的字符串
                    String s2=temp.substring(i);
                    //遍历s2,如果遇到0~9的字符，直接返回0
                    for(int j=0;j<s2.length();j++){
                        if(s2.charAt(j)>='0'&&s2.charAt(j)<='9'){
                            return 0;
                        }
                    }
                    break;
                }
            }
            String sResult=bufferResult.toString();
            long sLong=Long.parseLong(sResult);
            if(sLong>Math.pow(2,31)-1||sLong<-Math.pow(2,31)){
                return (int) (Math.pow(2,31)-1);
            }
            int result=Integer.parseInt(sResult);
            return result;
        }else if(s1.charAt(0)==' '){
           return 0;
        }else {
                //遍历字符串s1,正则匹配字符0~9
                StringBuffer buffer=new StringBuffer(s1);
                StringBuffer bufferResult=new StringBuffer();
                for (int i = 0; i < buffer.length(); i++) {
                    if(buffer.charAt(i)>='0'&&buffer.charAt(i)<='9'){
                        bufferResult.append(buffer.charAt(i));
                    }else if(buffer.charAt(i)=='.'){
                        break;
                    }else{
                        //截取索引i之后的字符串
                        String s2=s1.substring(i);
                        //遍历s2,如果遇到0~9的字符，直接返回0
                        for(int j=0;j<s2.length();j++){
                            if(s2.charAt(j)>='0'&&s2.charAt(j)<='9'){
                                return 0;
                            }
                        }
                        break;

                    }
                }
                long sLong=Long.parseLong(bufferResult.toString());
                if(sLong>Math.pow(2,31)-1||sLong<-Math.pow(2,31)){
                    return (int) (Math.pow(2,31));
                }
                int result=Integer.parseInt(bufferResult.toString());
                return result;
            }
        }


    public int myAtoiRight(String s) {
        int sign = 1;
        int res = 0;
        int m = s.length();
        int i = 0;
        while(i < m && s.charAt(i)==' '){
            i++;
        }
        //从第一个非空格字符开始
        int start = i;
        //从第一个非空格字符开始遍历字符串
        for(; i < m; i++){
            char c = s.charAt(i);
            //如果第一个非空格字符是正负号，记录正负号
            if(i==start && c=='+'){
                sign = 1;
            }else if(i==start && c=='-'){
                sign = -1;
                //Character.isDigit(c)：判断字符是否是数字
            }else if(Character.isDigit(c)){
                //c-'0'：将字符转换为数字
                int num = c-'0';
                //判断是否越界
                if(res > Integer.MAX_VALUE/10 || (res == Integer.MAX_VALUE/10&&num>Integer.MAX_VALUE%10)){
                    return Integer.MAX_VALUE;
                }
                //判断是否越界
                if(res < Integer.MIN_VALUE/10 || (res == Integer.MIN_VALUE/10&&-num<Integer.MIN_VALUE%10)){
                    return Integer.MIN_VALUE;
                }
                res = res*10+sign*num;
            }else{
                break;
            }
        }
        return res;
    }


    public int myAtoi2(String str) {
        int res=0;
        int sign=1;
        int length=str.length();
        int i=0;

        while(i < length && str.charAt(i)==' '){
            i++;
        }
        //记录一下首个字母的位置
        int start=i;

        for(;i<length;i++){
            if(str.charAt(start)==('+')&&i==start){
                sign=1;
            }else if(str.charAt(start)==('-')&&i==start){
                sign=-1;
            }else if(Character.isDigit(str.charAt(i))){
                int num=str.charAt(i)-'0';
                if(res>Integer.MAX_VALUE/10||res==Integer.MAX_VALUE/10&&num>Integer.MAX_VALUE%10){
                    return Integer.MAX_VALUE;
                }

                if(res<Integer.MIN_VALUE/10 || res==Integer.MIN_VALUE/10&&-num<Integer.MIN_VALUE%10){
                    return Integer.MIN_VALUE;
                }
                res=res*10+sign*num;
            }else{
                break;
            }
        }

        return res;
    }


    }


class Automaton {
    public int sign = 1;
    public long ans = 0;
    private String state = "start";
    private Map<String, String[]> table = new HashMap<String, String[]>() {{
        put("start", new String[]{"start", "signed", "in_number", "end"});
        put("signed", new String[]{"end", "end", "in_number", "end"});
        put("in_number", new String[]{"end", "end", "in_number", "end"});
        put("end", new String[]{"end", "end", "end", "end"});
    }};

    public void get(char c) {
        state = table.get(state)[get_col(c)];
        if ("in_number".equals(state)) {
            ans = ans * 10 + c - '0';
            ans = sign == 1 ? Math.min(ans, (long) Integer.MAX_VALUE) : Math.min(ans, -(long) Integer.MIN_VALUE);
        } else if ("signed".equals(state)) {
            sign = c == '+' ? 1 : -1;
        }
    }

    private int get_col(char c) {
        if (c == ' ') {
            return 0;
        }
        if (c == '+' || c == '-') {
            return 1;
        }
        if (Character.isDigit(c)) {
            return 2;
        }
        return 3;
    }
}


