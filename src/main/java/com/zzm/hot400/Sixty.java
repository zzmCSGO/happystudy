package com.zzm.hot400;

import com.zzm.algorithm.cache.MyCache;

import java.util.HashMap;

/**
 * @BelongsProject: leet
 * @BelongsPackage: com.zzm.hot400
 * @Author: zzm
 * @CreateTime: 2024-03-01  14:59
 * @Description: TODO
 * @Version: 1.0
 */
//460LFU缓存
public class Sixty {

    static class Node {
        int key;
        int value;
        Node pre;
        Node next;
        int freq=1;//使用频率

        public Node() {

        }

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

    }

    static class DeMyList {
        Node head;
        Node tail;

        int size;

        public DeMyList() {
            head = tail = new Node();
            head.next = tail;
            tail.pre = head;
            size=0;
        }

        public void addFirst(Node newNode) {
            Node old = head.next;
            head.next = newNode;
            newNode.pre = head;
            newNode.next = old;
            old.pre = newNode;
            size++;
        }

        public void remove(Node node) { //o(1)
            Node pre = node.pre;
            Node next = node.next;
            pre.next = next;
            next.pre = pre;
            size--;
        }

        public Node removeLast() {
            Node last = tail.pre;
            remove(last);//会调用remove节点，这里removeLast就不用再删除了。
            return last;
        }

        public boolean isEmpty(){
            return size==0;
        }
    }

    private HashMap<Integer,Node> kvMap=new HashMap<>();

    //频度map
    private HashMap<Integer,DeMyList> freqMap=new HashMap<>();

    private int capacity;

    private int minFreq=1;//freqMap的最小频度

    public Sixty(int capacity) {
        this.capacity = capacity;
    }

    //key不存在，返回-1
    //key存在，返回value值，增加节点的使用频次，将其转移到频次+1的链表当中
    public int get(int key){
        if(!kvMap.containsKey(key)){
            return -1;
        }
        Node node=kvMap.get(key);
        //从原有的链表里面移除该节点
        freqMap.get(node.freq).remove(node);
        //如果这个链表中的节点被移走之后为空了，并且正好是频次最小的那个链表，则更新最小频次
        if(freqMap.get(node.freq).isEmpty()&&node.freq==minFreq){
            minFreq++;
        }
        node.freq++;
    /*    //先从旧频度的链表里删除该节点，再去频度+1的链表添加该节点
        DeMyList list = freqMap.get(node.freq);
        //链表不存在的话先创建，链表已经有了的话就在上面添加
        if(list==null){
            list=new DeMyList();
            freqMap.put(node.freq,list);
        }
        //找到一个频度更高的链表，将该节点加入到链表头当中
        list.addFirst(node);*/
        freqMap.computeIfAbsent(node.freq,k->new DeMyList())
                .addFirst(node);
        return node.value;
    }

    //更新：将节点的value更新，增加节点的使用频度，将其转移到频度+1的链表中
    //新增：检查是否超过容量，若超过，淘汰minFreq链表的最后节点，
    // 创建新节点，放入kvMap，并加入频度为1的双向链表

    public void put(int key,int value){
        if(kvMap.containsKey(key)){
            //更新
            Node node=kvMap.get(key);
            //从原有的链表里面移除该节点
            freqMap.get(node.freq).remove(node);
            //如果这个链表中的节点被移走之后为空了，并且正好是频次最小的那个链表，则更新最小频次
            if(freqMap.get(node.freq).isEmpty()&&node.freq==minFreq){
                minFreq++;
            }
            node.freq++;
            freqMap.computeIfAbsent(node.freq,k->new DeMyList())
                    .addFirst(node);
            node.value=value;
        }else{
            //新增
            if(kvMap.size()==capacity){
                //淘汰，找到最小频次链表
                Node node = freqMap.get(minFreq).removeLast();
                kvMap.remove(node.key);
            }
            Node node=new Node(key,value);
            kvMap.put(key,node);
            freqMap.computeIfAbsent(1,k->new DeMyList())
                    .addFirst(node);
            //新增的节点，最小频度要恢复成1.
            minFreq=1;
        }
    }
}
