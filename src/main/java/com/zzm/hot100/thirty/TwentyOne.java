package com.zzm.hot100.thirty;

import com.zzm.structure.ListNode;

import java.awt.*;
import java.util.LinkedList;

/**
 * @BelongsProject: leet
 * @BelongsPackage: com.zzm.hot100
 * @Author: zzm
 * @CreateTime: 2024-01-16  10:39
 * @Description: TODO
 * @Version: 1.0
 */
//21.合并两个有序链表
public class TwentyOne {
    public static void main(String[] args) {
        ListNode l1=new ListNode(1);
        ListNode l2=new ListNode(2);
        ListNode l3=new ListNode(4);
        l1.next=l2;
        l2.next=l3;
        ListNode l4=new ListNode(1);
        ListNode l5=new ListNode(3);
        ListNode l6=new ListNode(4);
        l4.next=l5;
        l5.next=l6;
//        System.out.println(mergeTwoLists(l1,l4));
        System.out.println(self(l1,l4));
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    public static ListNode self(ListNode l1, ListNode l2){
        ListNode cur=new ListNode(0);
        ListNode res=cur;
        while(true){
            if(l1==null){
                cur.next=l2;
                break;
            }
            if(l2==null){
                cur.next=l1;
                break;
            }
            if(l1.val>l2.val){
                cur.next=l2;
                l2=l2.next;

            }else {
                cur.next=l1;
                l1=l1.next;
            }
            cur=cur.next;
        }
        return res.next;
    }

    public ListNode mergeTwoLists2(ListNode list1, ListNode list2) {
        ListNode dum = new ListNode(0), cur = dum;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                cur.next = list1;
                list1 = list1.next;
            }
            else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }
        cur.next = list1 != null ? list1 : list2;
        return dum.next;
    }


}




