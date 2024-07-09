//package com.zzm.hot200.fifty;
//
//import java.util.LinkedList;
//
///**
// * @BelongsProject: leet
// * @BelongsPackage: com.zzm.hot200
// * @Author: zzm
// * @CreateTime: 2024-01-23  20:56
// * @Description: TODO
// * @Version: 1.0
// */
////150.逆波兰表达式求值
//public class Fifty {
//    public static void main(String[] args) {
//
//    }
//
//    public int evalRPN(String[] tokens) {
//        LinkedList<Integer> stack=new LinkedList<>();
//        for (String token:tokens){
//            switch (token){
//                case "+" ->{
//                    Integer a = stack.pop();
//                    Integer b = stack.pop();
//                    stack.push(a+b);
//                }
//                case "-" ->{
//                    Integer a = stack.pop();
//                    Integer b = stack.pop();
//                    stack.push(b-a);
//                }
//                case "*" ->{
//                    Integer a = stack.pop();
//                    Integer b = stack.pop();
//                    stack.push(a*b);
//                }
//                case "/" ->{
//                    Integer a = stack.pop();
//                    Integer b = stack.pop();
//                    stack.push(b/a);
//                }
//                default -> {
//                    //数字
//                    int i = Integer.parseInt(token);
//                    stack.push(i);
//                }
//            }
//        }
//        return stack.pop();
//    }
//
//    static int priority(char c){
//        return switch(c){
//            case '(' ->0;
//            case '*','/'-> 2;
//            case '+','-' ->1;
//            default -> throw new IllegalArgumentException("不合法的运算符:"+c);
//        };
//    }
//
//    static String infixToSuffix(String exp){
//        LinkedList<Character> stack=new LinkedList<>();
//        StringBuilder sb=new StringBuilder(exp.length());
//        //a+b+c ab+c+
//        for (int i = 0; i < exp.length(); i++) {
//            char c=exp.charAt(i);
//            switch (c){
//                case '+','-','*','/' ->{
//                    if(stack.isEmpty()){
//                        stack.push(c);
//                    }else{
//                        if (priority(c)>priority(stack.peek())) {
//                            stack.push(c);
//                        }else{
//                            while(!stack.isEmpty()&&priority(stack.peek())>=priority(c)){
//                                sb.append(stack.pop());
//                            }
//                            stack.push(c);
//                        }
//                    }
//
//                }
//                case '(' ->{
//                    stack.push(c);
//                }
//                case ')'->{
//                    while(!stack.isEmpty()&&stack.peek()!='('){
//                        sb.append(stack.pop());
//                    }
//                    stack.pop();//把左括号弹出去，不用做拼接
//                }
//                default -> {
//                    sb.append(c);
//                }
//            }
//        }
//        //清除栈里的运算符
//        while(!stack.isEmpty()){
//            sb.append(stack.pop());
//        }
//
//        return sb.toString();
//    }
//}
