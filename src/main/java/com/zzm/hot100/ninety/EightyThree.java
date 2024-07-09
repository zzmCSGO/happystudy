package com.zzm.hot100.ninety;

import com.zzm.structure.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @BelongsProject: leet
 * @BelongsPackage: com.zzm.hot100.ninety
 * @Author: zzm
 * @CreateTime: 2024-01-25  14:26
 * @Description: TODO
 * @Version: 1.0
 */
//83. 删除排序链表中的重复元素
public class EightyThree {

    public static void main(String[] args) {

    }


    public ListNode deleteDuplicates(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode s=new ListNode(-1,head);
        ListNode p1=s;
        ListNode p2;
        while((p2=p1.next)!=null){
            if(p1.val==p2.val){
                p1.next=p2.next;
            }else{
                //向后平移
                p1=p1.next;
            }
        }
        return s.next;
    }
    //超出内存限制
    public ListNode deleteDuplicates1(ListNode head) {
        if(head==null){
            return null;
        }
        ArrayList<Integer> list=new ArrayList<>();
        while(head!=null){
            list.add(head.val);
        }
        List<Integer> collect = list.stream().distinct().collect(Collectors.toList());
        ListNode curr=new ListNode(0);
        ListNode res=curr;
        for(int i=0;i<collect.size();i++){
            ListNode temp=new ListNode(collect.get(i));
            curr.next=temp;
            curr=curr.next;
        }
        return res.next;
    }
}
