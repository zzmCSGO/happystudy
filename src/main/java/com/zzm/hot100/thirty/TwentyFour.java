package com.zzm.hot100.thirty;

import com.zzm.structure.ListNode;

import java.util.LinkedList;

/**
 * @BelongsProject: leet
 * @BelongsPackage: com.zzm.hot100
 * @Author: zzm
 * @CreateTime: 2024-01-16  16:10
 * @Description: TODO
 * @Version: 1.0
 */
//24.两两交换链表中的节点
public class TwentyFour {
    public static void main(String[] args) {
        ListNode l1=new ListNode(1);
        ListNode l2=new ListNode(2);
        ListNode l3=new ListNode(3);
        ListNode l4=new ListNode(4);
        l1.next=l2;
        l2.next=l3;
        l3.next=l4;
        ListNode node = new TwentyFour().swapPairs(l1);
        //依次输出链表各个节点的值
        while (node!=null){
            System.out.print(node.val+" ");
            node=node.next;
        }

    }

    public ListNode swapPairsPlus(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode temp = dummyHead;
        while (temp.next != null && temp.next.next != null) {
            ListNode node1 = temp.next;
            ListNode node2 = temp.next.next;
            temp.next = node2;
            node1.next = node2.next;
            node2.next = node1;
            temp = node1;
        }
        return dummyHead.next;
    }

    public ListNode swapPairs(ListNode head) {
        LinkedList<ListNode> stack = new LinkedList<>();
        int length = getLength(head);

        if (length==0){
            return null;
        }
        for (int i = 0; i < length; i++) {
            stack.push(head);
            head = head.next;
        }
        if(stack.size()==1){
            return stack.pop();
        }
        //stack 1,2,3,4,5
        LinkedList<ListNode> newStack= new LinkedList<>();
        if(stack.size()%2==1){
            ListNode pop = stack.pop();
            pop.next=null;
            while (stack.size()!=0){
                //stack 1,2,3,4
                ListNode node1 =stack.pop();//4 2
                node1.next=null;
                ListNode node2=stack.pop();//3 1
                node2.next=null;
                //从头部填入列表 //3,4,1,2
                newStack.push(node2);
                newStack.push(node1);
            }
            ListNode res=new ListNode(0);
            ListNode cur=res;
            while (newStack.size()!=0){
                res.next=newStack.pop();
                res=res.next;
            }
            res.next=pop;
            return cur.next;

        }else{
            while (stack.size()!=0){
                //stack 1,2,3,4
                ListNode node1=stack.pop();//4 2
                node1.next=null;
                ListNode node2=stack.pop();//3 1
                node2.next=null;
                //从头部填入列表 //3,4,1,2
                newStack.push(node2);
                newStack.push(node1);
            }
            ListNode res=new ListNode(0);
            ListNode cur=res;
            while (newStack.size()!=0){
                res.next=newStack.pop();
                res=res.next;
            }
            return cur.next;
        }

    }

    //交换节点位置
    public void swap(ListNode node1,ListNode node2){
        ListNode temp = node1;
        node1 = node2;
        node2 = temp;
    }

    public int getLength(ListNode head){
        int length = 0;
        while(head!=null){
            length++;
            head = head.next;
        }
        return length;
    }
}
