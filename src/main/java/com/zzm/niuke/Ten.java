package com.zzm.niuke;

import com.zzm.structure.ListNode;

/**
 * @BelongsProject: leet
 * @BelongsPackage: com.zzm.niuke
 * @Author: zzm
 * @CreateTime: 2024-02-26  15:40
 * @Description: TODO
 * @Version: 1.0
 */
//两个链表的第一个公共结点
public class Ten {
   /* 使用两个指针N1,N2，一个从链表1的头节点开始遍历，我们记为N1，一个从链表2的头节点开始遍历，我们记为N2。

    让N1和N2一起遍历，当N1先走完链表1的尽头（为null）的时候，则从链表2的头节点继续遍历，同样，如果N2先走完了链表2的尽头，则从链表1的头节点继续遍历，也就是说，N1和N2都会遍历链表1和链表2。

    因为两个指针，同样的速度，走完同样长度（链表1+链表2），不管两条链表有无相同节点，都能够到达同时到达终点。

            （N1最后肯定能到达链表2的终点，N2肯定能到达链表1的终点）。

    所以，如何得到公共节点：

    有公共节点的时候，N1和N2必会相遇，因为长度一样嘛，速度也一定，必会走到相同的地方的，所以当两者相等的时候，则会第一个公共的节点
    无公共节点的时候，此时N1和N2则都会走到终点，那么他们此时都是null，所以也算是相等了。*/

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode l1=pHead1;
        ListNode l2=pHead2;
        while(l1!=l2){
            l1=(l1==null)?pHead2:l1.next;
            l2=(l2==null)?pHead1:l2.next;
        }
        return l1;

    }
}
