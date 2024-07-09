package com.zzm.hot300.thirty;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @BelongsProject: leet
 * @BelongsPackage: com.zzm.hot300
 * @Author: zzm
 * @CreateTime: 2024-01-24  10:51
 * @Description: TODO
 * @Version: 1.0
 */
//用队列实现栈
public class TwentyFive {
    public static void main(String[] args) {

    }

    Queue<Integer> q=new ArrayDeque<>();

    /*
      队列头     队列尾
      cba
      顶           底

      queue.offer(a)
      queue.offer(b)
      queue.offer(c)
   */
    public void push(int x) {
        q.offer(x);
        int size=q.size()-1;
        for (int i = 0; i < size; i++) {
            q.offer(q.poll());
        }
    }

    public int pop() {
        return q.poll();
    }

    public int top() {
        return q.peek();
    }

    public boolean empty() {
        return q.isEmpty();
    }
}
