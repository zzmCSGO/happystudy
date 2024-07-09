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
//141. 环形链表
public class FortyOne {
    public static void main(String[] args) {

    }

    public boolean hasCycle(ListNode head) {
        ListNode p1=head;
        ListNode p2=head;
        while(p2!=null&&p2.next!=null){
            p1=p1.next;
            p2=p2.next.next;
            if(p1==p2){
                return true;
            }
        }
        return false;
    }

}
