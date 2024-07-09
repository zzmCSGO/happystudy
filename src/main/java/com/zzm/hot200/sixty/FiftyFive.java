package com.zzm.hot200.sixty;

import java.util.LinkedList;

/**
 * @BelongsProject: leet
 * @BelongsPackage: com.zzm.hot200.sixty
 * @Author: zzm
 * @CreateTime: 2024-02-16  21:06
 * @Description: TODO
 * @Version: 1.0
 */
public class FiftyFive {

    static class MinStack{
        LinkedList<Integer> stack=new LinkedList<>();
        LinkedList<Integer> min=new LinkedList<>();

        public MinStack() {
            min.push(Integer.MAX_VALUE);
        }

        public void push(int val){
            stack.push(val);
            //每次放的时候都跟栈顶元素比较，把小的放在上面
            min.push(Math.min(val,min.peek()));
        }

        public void pop(){
            if (stack.isEmpty()){
                return;
            }
            stack.pop();
            min.pop();
        }

        public int top(){
            return stack.peek();
        }


        public int getMin(){
            return min.peek();
        }

    }

    static class MinStack2{

    }
}
