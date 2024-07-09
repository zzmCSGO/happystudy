package com.zzm.hot100.ninety;

import com.zzm.structure.ListNode;

/**
 * @BelongsProject: leet
 * @BelongsPackage: com.zzm.hot100.ninety
 * @Author: zzm
 * @CreateTime: 2024-01-25  14:39
 * @Description: TODO
 * @Version: 1.0
 */
//82. 删除排序链表中的重复元素 II
public class EightyTwo {
    public static void main(String[] args) {

    }

    //重复的元素一个不留
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        if(head.val==head.next.val){
            ListNode x=head.next.next;
            while(x!=null&&x.val==head.val){
                x=x.next;//不断循环向后找
            }
            return deleteDuplicates(x);//与p取值不同的节点
        }else{
            //将head.next后面的节点进行递归去重后赋值给head.next
            head.next=deleteDuplicates(head.next);
            return head;
        }

    }

    public ListNode deleteDuplicates2(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode s=new ListNode(-1,head);
        ListNode p1=s;
        ListNode p2,p3;
        while((p2=p1.next)!=null&&(p3=p2.next)!=null){
            if(p2.val==p3.val){
                //需要直到p3的下一个不为null
                while((p3=p3.next)!=null&&p2.val==p3.val){
                }
                p1.next=p3;
            }else{
                p1=p1.next;
            }
        }
        return s.next;
    }

}
