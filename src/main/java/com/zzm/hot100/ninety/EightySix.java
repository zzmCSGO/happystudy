package com.zzm.hot100.ninety;

import com.zzm.structure.ListNode;

import java.util.LinkedList;

/**
 * @BelongsProject: leet
 * @BelongsPackage: com.zzm.hot100.ninety
 * @Author: zzm
 * @CreateTime: 2024-02-19  14:24
 * @Description: TODO
 * @Version: 1.0
 */
//86.分隔链表
public class EightySix {
    public ListNode partition(ListNode head, int x) {
        LinkedList<ListNode> small=new LinkedList<>();
        LinkedList<ListNode> old=new LinkedList<>();
        while(head!=null){
            if(head.val<x){
                small.addLast(new ListNode(head.val));
            }else{
                old.addLast(new ListNode(head.val));
            }
            head=head.next;
        }

        ListNode cur=new ListNode(0);
        ListNode res=cur;
        while(!small.isEmpty()){
            cur.next=small.pollFirst();
            cur=cur.next;
        }
        while(!old.isEmpty()){
            cur.next=old.pollFirst();
            cur=cur.next;
        }
        return res.next;
    }
}
