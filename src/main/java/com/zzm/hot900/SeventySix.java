package com.zzm.hot900;

import com.zzm.structure.ListNode;

/**
 * @BelongsProject: leet
 * @BelongsPackage: com.zzm.hot900
 * @Author: zzm
 * @CreateTime: 2024-01-25  15:02
 * @Description: TODO
 * @Version: 1.0
 */
//查找链表的中间节点
//快慢指针
public class SeventySix {
    public static void main(String[] args) {

    }
    public ListNode middleNode(ListNode head) {
        ListNode p1=head;
        ListNode p2=head;
        while(p2!=null && p2.next!=null){
            p1=p1.next;
            p2=p2.next;
            p2=p2.next;
        }
        return p1;
    }

}
