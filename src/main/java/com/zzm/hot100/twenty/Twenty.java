package com.zzm.hot100.twenty;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @BelongsProject: leet
 * @BelongsPackage: com.zzm.hot100
 * @Author: zzm
 * @CreateTime: 2024-01-15  16:13
 * @Description: TODO
 * @Version: 1.0
 */
// 20. 有效的括号
public class Twenty {
    public static void main(String[] args) {
//        String s = "({{{{}}}))";
//        String s="()[]{}";
//        String s="([)]";
        String s = ")(";
        System.out.println(new Twenty().isValidPlus(s));
        //输出：true

    }

    public boolean isValidPlus(String s) {
        int n = s.length();
        if (n % 2 == 1) {
            return false;
        }
        Map<Character, Character> pairs = new HashMap<Character, Character>() {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};
        LinkedList<Character> stack = new LinkedList<Character>();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (pairs.containsKey(ch)) {
                if (stack.isEmpty() || stack.peek() != pairs.get(ch)) {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }

    public boolean isValid(String s) {
        //初始的栈
        LinkedList<Character> stack = new LinkedList<>();
        //存放的栈
        LinkedList<Character> store = new LinkedList<>();
        //初始化栈
        for (int i = 0; i < s.length(); i++) {
            stack.push(s.charAt(i));
        }
        //如果栈的长度为奇数，直接返回false
        if (stack.size() % 2 != 0) {
            return false;
        }
        //如果栈不为空
        while (stack.size() != 0) {
            //弹出栈顶元素
            Character pop = stack.peek();
            //pop( store里还有)
            if(store.size()!=0&&stack.size()==0){
                return false;
            }
            if (pop.equals('(')) {
                if (store.size() != 0) {
                    if (store.peek().equals(')')) {
                        store.pop();
                    }else {
                        return false;
                    }
                }else{
                    return false;
                }
            } else if (pop.equals(')')) {

                if (stack.peek().equals('(')) {
                    stack.pop();
                } else if (stack.peek().equals('{') || stack.peek().equals('[')) {
                    return false;
                } else {
                    store.push(pop);
                }
            }
            if (pop.equals('[')) {
                if (store.size() != 0) {
                    if (store.peek().equals(']')) {
                        store.pop();
                    }else {
                        return false;
                    }
                }else{
                    return false;
                }
            } else if (pop.equals(']')) {
                if (stack.peek().equals('[')) {
                    stack.pop();
                } else if (stack.peek().equals('{') || stack.peek().equals('(')) {
                    return false;
                } else {
                    store.push(pop);
                }
            }
            if (pop.equals('{')) {
                if (store.size() != 0) {
                    if (store.peek().equals('}')) {
                        store.pop();
                    }else {
                        return false;
                    }
                }else{
                    return false;
                }
            } else if (pop.equals('}')) {
                if (stack.peek().equals('{')) {
                    stack.pop();
                } else if (stack.peek().equals('(') || stack.peek().equals('[')) {
                    return false;
                } else {
                    store.push(pop);
                }
            }
            stack.pop();
        }
        if(store.size()!=0) {
            return false;
        }
        return true;

    }
}
