package com.zzm.hot100.thirty;

import com.zzm.structure.ListNode;

import java.util.*;

/**
 * @BelongsProject: leet
 * @BelongsPackage: com.zzm.hot100
 * @Author: zzm
 * @CreateTime: 2024-01-16  13:45
 * @Description: TODO
 * @Version: 1.0
 */
//23.合并k个升序链表
public class TwentyThree {
    public static void main(String[] args) {
        ListNode l1=new ListNode(2);
        ListNode l2=new ListNode(5);
        ListNode l3=new ListNode(4);
        l1.next=l2;
        l2.next=l3;
        ListNode l4=new ListNode(1);
        ListNode l5=new ListNode(3);
        ListNode l6=new ListNode(4);
        l4.next=l5;
        l5.next=l6;
        ListNode l7=new ListNode(3);
        ListNode l8=new ListNode(3);
        ListNode l9=new ListNode(4);
        l7.next=l8;
        l8.next=l9;
        ListNode [] listNodes={l1,l4,l7};
        ListNode node = new TwentyThree().mergeKListsPriorityQueue(listNodes);
        System.out.println(node);


    }

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode curList = null;
        LinkedList<ListNode> list = new LinkedList<>();
        if (lists.length == 0) {
            return null;
        }
        for (int i = 0; i < lists.length; i++) {
            list.push(lists[i]);
        }
        if (list.size() == 1) {
            return list.pop();
        }
        if (list.size() == 2) {
            ListNode node1 = list.pop();
            ListNode node2 = list.pop();
            ListNode node = mergeTwoLists(node1, node2);
            return node;
        }
        while (list.size() != 0) {
            if (curList == null) {
                ListNode node1 = list.pop();
                ListNode node2 = list.pop();
                curList = mergeTwoLists(node1, node2);

            } else {
                ListNode node = list.pop();
                curList = mergeTwoLists(node, curList);
            }
        }
        return curList;
    }



    public ListNode mergeTwoLists(ListNode l1,ListNode l2){

        ListNode res=new ListNode(0);
        ListNode cur=res;
        while(true){
            if(l1==null){
                res.next=l2;
                break;
            }
            if(l2==null){
                res.next=l1;
                break;
            }

            if(l1.val>l2.val){
                //l1不动，l2移位
                res.next=l2;
                l2=l2.next;
            }else {
                res.next=l1;
                l1=l1.next;
            }
            res=res.next;
        }
        return cur.next;
    }

    public ListNode mergeKListsPriorityQueue(ListNode[] lists) {
        // 1. 使用 jdk 的优先级队列实现
        PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));

        //1->2->4
        //1->3->4
        //1->3->4
        for (ListNode head : lists) {
            if (head != null) {
                queue.offer(head);
            }
        }
        ListNode s = new ListNode(-1, null);//哨兵节点
        ListNode p = s;
        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            p.next = node;
            p = node;
            if (node.next != null) {
                //被移除元素的下一个元素
                queue.offer(node.next);
            }
        }
        return s.next;
    }
}
