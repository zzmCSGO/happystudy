package com.zzm.niuke;

import com.zzm.structure.ListNode;

/**
 * @BelongsProject: leet
 * @BelongsPackage: com.zzm.niuke
 * @Author: zzm
 * @CreateTime: 2024-03-16  16:57
 * @Description: TODO
 * @Version: 1.0
 */
public class Thriteen {

    public static void main(String[] args) {
        ListNode l1=new ListNode(1);
        ListNode l2=new ListNode(2);
        ListNode l3=new ListNode(3);
        ListNode l4=new ListNode(4);
        ListNode l5=new ListNode(5);
        ListNode l6=new ListNode(4);
        ListNode l7=new ListNode(3);
        ListNode l8=new ListNode(2);
        ListNode l9=new ListNode(1);
        ListNode l10=new ListNode(1);
        l1.next=l2;
        l2.next=l3;
        l3.next=l4;
        l4.next=l5;
        l5.next=l6;
        l6.next=l7;
        l7.next=l8;
        l8.next=l9;
        l9.next=l10;
        boolean pail = new Thriteen().isPail(l1);
        System.out.println(pail);
    }

    public boolean isPail (ListNode head) {

        // write code here
        ListNode curr=head;
        ListNode re=reverse(head);
        ListNode fast=head;
        ListNode slow=head;
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        //slow是中点
        slow=reverse(slow);
        fast=head;
        while(slow!=null){
            if(fast.val!=slow.val){
                return false;
            }
            fast=fast.next;
            slow=slow.next;
        }
        return true;

    }
    //反转链表
    public ListNode reverse(ListNode head){
        ListNode pre=null;
        ListNode cur=head;
        //1->2->3->4->5
        while(cur!=null){
            //先保存下一个节点
            ListNode next=cur.next; //3->4->5
            //反转1->null
            cur.next=pre;
            pre=cur;
            cur=next;
        }
        return pre;
    }

}
