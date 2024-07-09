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

    }
    public ListNode detectCycle(ListNode head) {
        //判断是否有环
        ListNode tortoise=head;//龟
        ListNode rabbit=head;//兔子
        boolean flag=false;

        while(rabbit!=null&&rabbit.next!=null){
            tortoise=tortoise.next;
            rabbit=rabbit.next.next;
            if(tortoise==rabbit){
                tortoise=head;
                flag=true;
                break;
            }
        }
        if(flag){
            while(tortoise!=rabbit){
                tortoise=tortoise.next;
                rabbit=rabbit.next;
            }
            return tortoise;
        }else{
            return null;
        }

    }
}
