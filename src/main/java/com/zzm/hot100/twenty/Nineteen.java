package com.zzm.hot100.twenty;

import com.zzm.structure.ListNode;

import java.util.LinkedList;

/**
 * @BelongsProject: leet
 * @BelongsPackage: com.zzm.hot100
 * @Author: zzm
 * @CreateTime: 2024-01-15  15:59
 * @Description: TODO
 * @Version: 1.0
 */
// 19. 删除链表的倒数第 N 个结点
    //链表的问题需要设置一个预先节点
public class Nineteen {
    public static void main(String[] args) {
        ListNode l1=new ListNode(1);
        ListNode l2=new ListNode(2);
        ListNode l3=new ListNode(3);
        ListNode l4=new ListNode(4);
        l1.next=l2;
        l2.next=l3;
        l3.next=l4;
        ListNode node = new Nineteen().removeNthFromEndPlus(l1, 2);

    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        //1,2,3,4,5
        //预先节点
        ListNode dummy=new ListNode(0,head);
        LinkedList<ListNode> stack=new LinkedList();
        ListNode cur=dummy;

        while(cur!=null){
            stack.push(cur);
            cur=cur.next;
        }
        //stack://dummy(0)->1->2->3->4->5
        for(int i=0;i<n;i++){
            stack.pop();//
        }
        //此时栈顶元素就是要删除元素的前一个元素,peek()方法返回栈顶元素，但不弹出
        ListNode prev=stack.peek();
        prev.next=prev.next.next;
        ListNode ans=dummy.next;
        return ans;
    }
    //双指针->快慢指针
    public ListNode removeNthFromEndPlus(ListNode head, int n) {
        ListNode s = new ListNode(-1, head);
        ListNode p1 = s;
        ListNode p2 = s;
        for (int i = 0; i < n + 1; i++) {
            p2 = p2.next;
        }
        while (p2 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        p1.next = p1.next.next;
        return s.next;
    }
}






