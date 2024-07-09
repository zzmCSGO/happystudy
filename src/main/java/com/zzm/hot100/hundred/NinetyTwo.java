package com.zzm.hot100.hundred;

import com.zzm.structure.ListNode;

import java.util.LinkedList;

/**
 * @BelongsProject: leet
 * @BelongsPackage: com.zzm.hot100.hundred
 * @Author: zzm
 * @CreateTime: 2024-02-18  19:36
 * @Description: TODO
 * @Version: 1.0
 */
//92. 反转链表 II
public class NinetyTwo {
    public static void main(String[] args) {
        ListNode l1=new ListNode(1);
        ListNode l2=new ListNode(2);
        ListNode l3=new ListNode(3);
        ListNode l4=new ListNode(4);
        ListNode l5=new ListNode(5);
        l1.next=l2;
        l2.next=l3;
        l3.next=l4;
        l4.next=l5;
        ListNode node = new NinetyTwo().reverseBetween(l1, 2, 4);

    }
    public ListNode reverseBetween(ListNode head, int left, int right) {

        //1->2->3->4->5->6
        //1->5->4->3->2->6
        LinkedList<ListNode> stack=new LinkedList<>();
        while(head!=null){
            stack.addLast(head);
            head=head.next;
        }

        int start=left-1;
        int len=right-start;//几个数
        ListNode cur=new ListNode(0);
        ListNode res=cur;
        for(int i=0;i<stack.size();i++){
            if(start<=0&&len>0){
                cur.next=new ListNode(stack.get(left+len-2).val);
                len--;
                cur=cur.next;
            }else{
                cur.next=new ListNode(stack.get(i).val);
                cur=cur.next;
                start--;
            }
        }
        return res.next;
    }
}
