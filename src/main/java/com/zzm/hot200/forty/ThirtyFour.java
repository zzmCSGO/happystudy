package com.zzm.hot200.forty;

import com.zzm.structure.ListNode;

/**
 * @BelongsProject: leet
 * @BelongsPackage: com.zzm.hot200.forty
 * @Author: zzm
 * @CreateTime: 2024-01-25  15:14
 * @Description: TODO
 * @Version: 1.0
 */
//234.回文链表
public class ThirtyFour {
    public static void main(String[] args) {

    }

    /*
    步骤1. 找中间点
    步骤2. 中间点后半个链表反转
    步骤3. 反转后链表与原链表逐一比较
*/

    public boolean isPalindrome(ListNode head) {
        ListNode reverse= reverse(middle(head));
        while(reverse!=null){
            if(reverse.val!=head.val){
                return false;
            }
            reverse=reverse.next;
            head=head.next;
        }
        return true;

    }

    //查找中间节点
    public ListNode middle(ListNode head){
        //先找到中间点
        ListNode p1=head;
        ListNode p2=head;
        while(p2!=null&&p2.next!=null){
            p1=p1.next;
            p2=p2.next.next;
        }
        return p1;
    }


    //反转链表
    public ListNode reverse(ListNode o1){
        //o1 :1 2 3 4
        ListNode n1=null;//新链表头节点
        while(o1!=null){
            ListNode o2=o1.next;//原链表的下一个节点
            o1.next=n1;//原链表的下一个节点指向新链表的头节点
            n1=o1;//新链表的头节点指向原链表的当前节点
            o1=o2;//原链表的当前节点指向原链表的下一个节点
        }
        return n1;
    }

    //优化版本
    public boolean isPalindromePlus(ListNode h1) {
        if (h1 == null || h1.next == null) {
            return true;
        }
        ListNode p1 = h1; 	// 慢指针，中间点
        ListNode p2 = h1; 	// 快指针
        ListNode n1 = null;	// 新头
        ListNode o1 = h1;	// 旧头
        // 快慢指针找中间点
        while (p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;

            // 反转前半部分
            o1.next = n1;
            n1 = o1;
            o1 = p1;
        }
        if (p2 != null) { // 节点数为奇数
            p1 = p1.next;
        }
        // 同步比较新头和后半部分
        while (n1 != null) {
            if (n1.val != p1.val) {
                return false;
            }
            p1 = p1.next;
            n1 = n1.next;
        }
        return true;
    }



}
