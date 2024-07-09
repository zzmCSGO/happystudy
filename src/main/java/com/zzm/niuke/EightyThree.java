package com.zzm.niuke;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @BelongsProject: leet
 * @BelongsPackage: com.zzm.niuke
 * @Author: zzm
 * @CreateTime: 2024-02-28  15:49
 * @Description: TODO
 * @Version: 1.0
 */
public class EightyThree {
    public static String trans(String s, int n) {
        if(n==0)
            return s;
        StringBuffer res=new StringBuffer();
        for (int i = 0; i < n; i++){
            //大小写转换
            if(s.charAt(i) <= 'Z' && s.charAt(i) >= 'A')
                res.append((char)(s.charAt(i) - 'A' + 'a'));
            else if(s.charAt(i) >= 'a' && s.charAt(i) <= 'z')
                res.append((char)(s.charAt(i) - 'a' + 'A'));
            else
                //空格直接复制
                res.append((char)(s.charAt(i)));
        }
        Stack<String> temp=new Stack<String>();
        for (int i = 0; i < n; i++){
            int j = i;
            //以空格为界，分割单词
            while(j < n && res.charAt(j) != ' ')
                j++;
            //单词进栈
            temp.push((String)(res.substring(i, j)));
            i = j;
        }
        //排除结尾空格的特殊情况
        if(s.charAt(n - 1) == ' ')
            res = new StringBuffer(" ");
        else
            res = new StringBuffer();
        //栈遵循先进后厨，单词顺序是反的
        while(!temp.empty()){
            res.append(temp.peek());
            temp.pop();
            if(!temp.empty())
                res.append(" ");
        }
        return res.toString();
    }

    public static String myTrans (String s, int n) {
        // write code here
        if(n==0){
            return s;
        }
        //首先遍历字符串，将大小写转换
        String s1=myReverse(s,n);
        //创建栈，倒序删除
        LinkedList<String> stack=new LinkedList<>();
        for(int i=0;i<n;i++){
            int j=i;
            char ch=s1.charAt(j);
            if(ch==' '){
                stack.push(" ");
            }else{
                while(ch!=' '){
                    j++;
                    if(j>=n){
                        break;
                    }
                    ch=s1.charAt(j);
                    //如果没遇到空格，就一直挪动指针
                }
                //遇到空格了
                String temp=s1.substring(i,j);
                stack.push(temp);
                if(j<n){
                    stack.push(" ");
                }
                //从空格处开始
                i=j;
            }

        }
        StringBuilder res=new StringBuilder();
        while(!stack.isEmpty()){
            res.append(stack.pop());
        }
        return res.toString();
    }


    //大小写转换方法
    public static String myReverse(String s,int n){
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(ch>='A'&&ch<='Z'){
                sb.append((char)(ch-'A'+'a'));
            }else if(ch>='a'&&ch<='z'){
                sb.append((char)(ch-'a'+'A'));
            }else{
                sb.append(ch);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {

//        String a=" h i";
        String a="abcde";
//        String res=myTrans(a,a.length());
        String res=a.substring(1,3);
        System.out.println(res);
        int[][]b={{1,2}};
        Arrays.sort(b, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
    }
}
