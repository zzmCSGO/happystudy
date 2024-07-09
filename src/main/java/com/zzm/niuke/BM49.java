package com.zzm.niuke;

import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @BelongsProject: leet
 * @BelongsPackage: com.zzm.niuke
 * @Author: zzm
 * @CreateTime: 2024-03-18  14:20
 * @Description: TODO
 * @Version: 1.0
 */
//中缀表达式求值
public class BM49 {
    public static void main(String[] args) {
        String s="3+2*3*4-1";
        System.out.println(solve(s));
    }

    //16
    //+  -
    public static int solve(String s) {
        LinkedList<Integer> numStack=new LinkedList<>();
        LinkedList<Character> opStack=new LinkedList<>();
        int len=s.length();
        for(int i=0;i<len;i++){
            char c=s.charAt(i);
            if(c==' '){
                continue;
            }
            //判断是不是数字
            if(isNumber(c)){
                int num=0;
                //遇到连续的数字类似26
                while(i<len&&isNumber(s.charAt(i))){
                    num=num*10+s.charAt(i)-'0';
                    i++;
                }
                //放入栈中
                numStack.push(num);
                //因为for循环中有i++,所以这里要i--
                i--;
                //遇到左括号直接入栈
            }else if(c=='('){
                opStack.push(c);
            }else if(c==')'){
                //没遇到左括号之前，一直出栈
                while(opStack.peek()!='('){
                    int a=numStack.pop();
                    int b=numStack.pop();
                    char op=opStack.pop();
                    numStack.push(res(a,b,op));
                }
                opStack.pop();
            }else{
                //运算符,如果操作数栈不为空，并且当前运算符优先级小于等于栈顶运算符优先级，就一直出栈
                while(!opStack.isEmpty()&&priority(c)<=priority(opStack.peek())){
                    int a=numStack.pop();
                    int b=numStack.pop();
                    char op=opStack.pop();
                    numStack.push(res(a,b,op));
                }
                //当前运算符入栈
                opStack.push(c);
            }
        }
        //最后操作数栈和操作符栈中的元素出栈
        while(!opStack.isEmpty()){
            int a=numStack.pop();
            int b=numStack.pop();
            char op=opStack.pop();
            numStack.push(res(a,b,op));
        }
        return numStack.pop();
    }

    //定义优先级函数
    public static int priority(char r){
        //换成if的
        if(r=='+'||r=='-'){
            return 1;
        }
        if(r=='*'||r=='/'){
            return 2;
        }
        return 0;
    }
    public static int res(int a,int b,char c){
        if(c=='+'){
            return a+b;
        }
        if(c=='-'){
            return b-a;
        }
        if(c=='*'){
            return a*b;
        }
        if(c=='/'){
            return b/a;
        }
        return 0;
    }

    //看看是不是操作数
    public static boolean isNumber(char c){
        return c>='0'&&c<='9';
    }
}
