package com.zzm.hot300.ten;


import com.zzm.structure.ListNode;

import java.util.LinkedList;

/**
 * @BelongsProject: leet
 * @BelongsPackage: com.zzm.hot300
 * @Author: zzm
 * @CreateTime: 2024-01-25  13:03
 * @Description: TODO
 * @Version: 1.0
 */
//206. 反转链表
public class Six {
    public static void main(String[] args) {
        ListNode l1=new ListNode(1);
        ListNode l2=new ListNode(2);
        ListNode l3=new ListNode(3);
        ListNode l4=new ListNode(4);
        l1.next=l2;
        l2.next=l3;
        l3.next=l4;
        ListNode node = new Six().reverseList(l1);

    }
    public ListNode reverseList(ListNode head) {
        LinkedList<ListNode> stack=new LinkedList<>();
        if(head==null){
            return null;
        }
        while(head!=null){
            ListNode temp=new ListNode();
            temp.val=head.val;
            stack.push(temp);
            head=head.next;
        }
        ListNode curr=new ListNode(0);
        ListNode res=curr;
        while(!stack.isEmpty()){
            curr.next=stack.pop();
            curr=curr.next;
        }

        return res.next;
    }

    //递归
//    public ListNode reverseList(ListNode head) {
//        if(head==null||head.next==null){
//            return head;//最后一个节点
//        }
//        //last就是最后一次的最后一个节点
//        ListNode last = reverseList(head.next);
//        //head 4  head.next 5   让5指向4 4指向null
//        //相邻节点逆序
//        head.next.next=head;
//        head.next=null;
//        return last;
//    }
}
