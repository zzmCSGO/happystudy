package com.zzm.niuke;

import com.zzm.structure.ListNode;

import java.util.LinkedList;

/**
 * @BelongsProject: leet
 * @BelongsPackage: com.zzm.niuke
 * @Author: zzm
 * @CreateTime: 2024-03-12  11:30
 * @Description: TODO
 * @Version: 1.0
 */
//两个链表相加
public class Eleven {
    public static void main(String[] args) {
        ListNode l1=new ListNode(1);
        ListNode l2=new ListNode(2);
        ListNode l3=new ListNode(3);
        ListNode l4=new ListNode(4);
        ListNode l5=new ListNode(5);
        ListNode l6=new ListNode(6);
        l1.next=l2;
        l2.next=l3;
        l4.next=l5;
        l5.next=l6;
        Eleven eleven = new Eleven();
        ListNode listNode = eleven.addInList(l1, l4);
        System.out.println(listNode);
    }
    public ListNode addInList (ListNode head1, ListNode head2) {
        // write code here
        LinkedList<Integer> stack1 = new LinkedList<>();
        LinkedList<Integer> stack2 = new LinkedList<>();
        while(head1!=null){
            stack1.push(head1.val);
            head1=head1.next;
        }
        while(head2!=null){
            stack2.push(head2.val);
            head2=head2.next;
        }

        LinkedList<Integer> res=new LinkedList<>();
        int carry=0;//进位,提到循环外面
        while(!stack1.isEmpty()||!stack2.isEmpty()){
            int a=0;
            int b=0;
            if(!stack1.isEmpty()){
                a=stack1.pop();
            }
            if(!stack2.isEmpty()){
                b=stack2.pop();
            }
            int sum=a+b;
            res.push((sum+carry)%10);
            carry=(sum+carry)/10;
        }
        if(carry>0){
            res.push(carry);
        }
        ListNode r=new ListNode(-1);
        ListNode cur=r;
        while(!res.isEmpty()){
            cur.next=new ListNode(res.pop());
            cur=cur.next;
        }
        return r.next;
    }
}
