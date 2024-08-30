package com.zzm.hot200.fifty;

import com.zzm.structure.ListNode;

/**
 * @BelongsProject: leet
 * @BelongsPackage: com.zzm.hot200.fifty
 * @Author: zzm
 * @CreateTime: 2024-01-25  19:12
 * @Description: TODO
 * @Version: 1.0
 */
//142. 环形链表 II
public class FortyTwo {
    public static void main(String[] args) {
        // 创建节点
        ListNode node3 = new ListNode(3);
        ListNode node0 = new ListNode(0);
        ListNode node2 = new ListNode(2);
        ListNode node4 = new ListNode(4);

        // 连接节点
        node3.next = node0;
        node0.next = node2;
        node2.next = node4;
        node4.next = node2;
        detectCycle2(node3);
    }

    public static ListNode detectCycle(ListNode head) {
        //判断是否有环
        ListNode tortoise = head;//龟
        ListNode rabbit = head;//兔子
        boolean flag = false;

        while (rabbit != null && rabbit.next != null) {
            tortoise = tortoise.next;
            rabbit = rabbit.next.next;
            if (tortoise == rabbit) {
                tortoise = head;
                flag = true;
                break;
            }
        }
        if (flag) {
            while (tortoise != rabbit) {
                tortoise = tortoise.next;
                rabbit = rabbit.next;
            }
            return tortoise;
        } else {
            return null;
        }

    }


    public static ListNode detectCycle2(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }
        if (fast == null || fast.next == null) {
            return null;
        }
        slow = head;
        while (true) {
            fast = fast.next;
            slow = slow.next;
            if (slow == fast) {
                return slow;
            }
        }
    }
}
