package com.zzm.hot100.seventy;

import com.zzm.structure.ListNode;

import java.util.LinkedList;

/**
 * @BelongsProject: leet
 * @BelongsPackage: com.zzm.hot100.seventy
 * @Author: zzm
 * @CreateTime: 2024-02-20  13:42
 * @Description: TODO
 * @Version: 1.0
 */
public class SixtyOne {
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null){
            return null;
        }
        LinkedList<Integer> stack=new LinkedList<>();
        while(head!=null){
            stack.addLast(new ListNode(head.val).val);
            head=head.next;
        }
        int realK=k%stack.size();
        for(int i=0;i<realK;i++){
            Integer pop=stack.pollLast();
            stack.addFirst(pop);
        }
        ListNode cur=new ListNode(0);
        ListNode res=cur;
        while(!stack.isEmpty()){
            cur.next=new ListNode(stack.pollFirst());
            cur=cur.next;
        }
        return res.next;
    }
}
