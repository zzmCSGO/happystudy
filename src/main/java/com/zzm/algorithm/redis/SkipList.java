package com.zzm.algorithm.redis;

import java.util.Random;
import java.util.Set;

/**
 * @BelongsProject: leet
 * @BelongsPackage: com.zzm.algorithm.redis
 * @Author: zzm
 * @CreateTime: 2024-03-05  16:33
 * @Description: TODO
 * @Version: 1.0
 */
public class SkipList {

    static Random r=new Random();
    static int randomLevel(int max){
        //   50%                      25%                12.5%
        //return r.nextBoolean()?1:r.nextBoolean()?2:r.nextBoolean()?3:4
        int x=1;
        while(x<max){
            if(r.nextBoolean()){
                return x;
            }
            x++;
        }
        return x;
    }


    static class MySkipList{

        //next指针的个数
        private static final int Max=10; //redis 32,java 64
        //跳表的头节点,不回变也不会用来比较
        private final Node head=new Node(-1);
        static class Node{
            int val;//值
            Node[] next=new Node[Max];//实际上头节点可以取最大，剩下的节点可以根据实际高度来赋值，这里简化了

            public Node(int val){
                this.val=val;
            }

        }

        //下楼梯规则
        //若next指针为null，或者next指向的节点值>=目标，向下找
        //若next指针不为null，且next指向的节点值<目标，向右找
        public Node[] find(int val){//返回的是所找节点的前一个节点，层数为0
            Node[] path=new Node[Max];//记录经过的路径
            Node curr=head;
            //需要从高向下找。
            for(int level=Max-1;level>=0;level--){
                //从上向下找
                //拿当前层的next指针,但是向右找并不是找一次，而是一致找到比它大或者等于的才可以停下，所以这里应该用while而不用if
                while(curr.next[level]!=null&&curr.next[level].val<val){
                    curr=curr.next[level];
                }
                path[level]=curr;
                //向下找和向右找的条件互斥，不用再做额外判断了
            }
            return path;
        }
        public boolean search(int val){
            Node[] path=find(val);
            Node node = path[0].next[0];
            //要考虑到下一个指针可能为null
            return node!=null && node.val==val;
        }


        public void add(int val){
            //1.确定添加位置，把val当作目标查询，精力的路径就可以添加位置
            Node[] path = find(val);
            //2.创建新的节点随机高度
            Node node = new Node(val);//新节点
            //随机高度返回，不希望节点的高度一致。希望矮的节点概率更高些，高的节点概率更小些

            int level = randomLevel(Max);
            //3.修改路径节点的next指针，以及新节点的next指针
            //新节点的next指针有多高，就修改
            //只负责修改自己高度的指针就可以
            for(int i=0;i<level;i++){
                //path[i].next[i]同层的next指针
                node.next[i]=path[i].next[i];
                path[i].next[i]=node;
            }

        }
        //删除的逻辑
        public boolean erase(int val){
            Node[] path=find(val);
            Node node = path[0].next[0];
            if(node==null||node.val!=val){
                return false;
            }
            //我们只需要循环到节点的高度就可以了，但是节点的高度我们并没有设置成属性，那么就直接放最大了，可以优化
            for(int i=0;i<Max;i++){
                //路径节点的next指针指向的不是被删除节点的时候就break
                if(path[i].next[i]!=node){
                    break;
                }
                path[i].next[i]=node.next[i];
            }
            return true;
        }
    }
}
