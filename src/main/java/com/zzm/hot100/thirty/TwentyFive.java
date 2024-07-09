package com.zzm.hot100.thirty;

import com.zzm.structure.ListNode;

import java.util.LinkedList;

/**
 * @BelongsProject: leet
 * @BelongsPackage: com.zzm.hot100
 * @Author: zzm
 * @CreateTime: 2024-01-17  00:19
 * @Description: TODO
 * @Version: 1.0
 */
//25.K个一组翻转链表
public class TwentyFive {
    public static void main(String[] args) {
        ListNode l1=new ListNode(1);
        ListNode l2=new ListNode(2);
        ListNode l3=new ListNode(3);
        ListNode l4=new ListNode(4);
        l1.next=l2;
        l2.next=l3;
        l3.next=l4;
        ListNode node = new TwentyFive().reverseKGroup(l1, 3);
        while (node!=null){
            System.out.print(node.val+"");
            node=node.next;
        }

    }
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null){
            return null;
        }
        //首先获得链表的长度
        int length=getLength(head);
        //用链表的长度/k=n组k个反转
        int n=length/k;
        //链表长度%k，判断条件，如果为0的话恰好为n组，否则先弹出余数，反转n组之后再相加
        int remainder=length%k;
        LinkedList<ListNode> list=new LinkedList<>();
        ListNode dummyHead=new ListNode(0);
        ListNode res=dummyHead;

        for (int i = 0; i < length; i++) {
            list.push(head);
            head=head.next;
        }
        LinkedList<ListNode> stack=new LinkedList<>();
        LinkedList<ListNode> temp=new LinkedList<>();
        if(remainder==0){
            //说明正好为n组
            while (n>0){
                //list:1,2,3,4,5 k=2
                for (int i = 0; i < k; i++) {
                    ListNode pop = list.pop();
                    pop.next=null;
                    stack.push(pop); //2,1
                }
                //temp:2,1
                while (!stack.isEmpty()){
                    temp.push(stack.pop());//3,4,1,2
                }
                n--;
            }
            while (!temp.isEmpty()){
                dummyHead.next=temp.pop();
                dummyHead=dummyHead.next;//2,1,4,3
            }
            return res.next;
        }else {
            //1,2,3,4,5,6,7,8 k=3
            //先弹出余数
            for (int i = 0; i < remainder; i++) {
                ListNode pop = list.pop();
                pop.next=null;
                temp.push(pop);//8,7
            }
            //stack:1,2
            while (n>0){
                //list:3,4 k=2
                for (int i = 0; i < k; i++) {
                    ListNode pop = list.pop();
                    pop.next=null;
                    stack.push(pop); //6,5,4.3,2,1
                }
                //temp:2,1
                while (!stack.isEmpty()){
                    temp.push(stack.pop());//8,7,4,5,6,1,2,3
                }
                n--;
            }
            //stack:1,2
              while (!temp.isEmpty()){
                    dummyHead.next=temp.pop();
                    dummyHead=dummyHead.next;//3,2,1,6,5,4,7,8
              }
            return res.next;
        }


    }

    public int getLength(ListNode head){
        int length=0;
        while (head!=null){
            length++;
            head=head.next;
        }
        return length;
    }
}
