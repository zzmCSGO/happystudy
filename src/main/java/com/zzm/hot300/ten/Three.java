package com.zzm.hot300.ten;

import com.zzm.structure.ListNode;

import java.util.ArrayList;

/**
 * @BelongsProject: leet
 * @BelongsPackage: com.zzm.hot300.ten
 * @Author: zzm
 * @CreateTime: 2024-01-25  13:41
 * @Description: TODO
 * @Version: 1.0
 */
//203.移除链表元素
public class Three {
    public static void main(String[] args) {

    }

    public ListNode removeElements(ListNode head, int val) {
    if(head==null){
          return null;
      }
      ListNode curr=new ListNode(0);
      ListNode res=curr;
      while(head!=null){
          if(head.val!=val){
              ListNode temp=new ListNode(head.val);
              curr.next=temp;
              curr=curr.next;
          }
      }
      return res.next;
    }

    public ListNode removeElements1(ListNode head, int val) {
        ListNode sentinel = new ListNode(-1, head);
        ListNode p1 = sentinel;
        ListNode p2;
        while ((p2 = p1.next) != null) {
            if (p2.val == val) {
                p1.next = p2.next;
            } else {
                p1 = p1.next;
            }
        }
        return sentinel.next;
    }

    public ListNode removeElementsRec(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        if (head.val == val) {
            return removeElements(head.next, val);
        } else {
            head.next = removeElements(head.next, val);
            return head;
        }
    }
}
