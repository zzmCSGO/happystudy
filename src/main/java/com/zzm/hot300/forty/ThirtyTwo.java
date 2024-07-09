package com.zzm.hot300.forty;

import java.util.LinkedList;

/**
 * @BelongsProject: leet
 * @BelongsPackage: com.zzm.hot300
 * @Author: zzm
 * @CreateTime: 2024-01-24  10:40
 * @Description: TODO
 * @Version: 1.0
 */
//用栈实现队列
public class ThirtyTwo {
    public static void main(String[] args) {

    }
    //队列头   队列尾
    //顶 底    底 顶
    //s1         s2
    //入的时候往s2里放，弹的时候把s2里挪到s1里，再弹出

    public ThirtyTwo() {

    }
    LinkedList<Integer> s1 =new LinkedList<>();
    LinkedList<Integer> s2 =new LinkedList<>();

    public void push(int x) {
        s2.push(x);
    }

    public int pop() {
        if(s1.isEmpty()){
            while(!s2.isEmpty()){
                Integer pop = s2.pop();
                s1.push(pop);
            }
        }
        return s1.pop();
    }

    public int peek() {
        if(s1.isEmpty()){
            while(!s2.isEmpty()){
                Integer pop = s2.pop();
                s1.push(pop);
            }
        }
        return s1.peek();
    }

    public boolean empty() {
        return s1.isEmpty()&&s2.isEmpty();
    }

}
