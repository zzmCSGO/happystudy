package com.zzm.niuke;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @BelongsProject: leet
 * @BelongsPackage: com.zzm.niuke
 * @Author: zzm
 * @CreateTime: 2024-03-01  14:49
 * @Description: TODO
 * @Version: 1.0
 */
public class Lfu {

    public static void main(String[] args) {
        int[][] operators={
                {1,1,1},{1,2,2},{1,3,2},{1,2,4},{1,3,5},{2,2},{1,4,4},{2,1}
                 };
        int k=3;
        Lfu l=new Lfu();
        int[] lfu = l.LFU(operators, k);
        for (int i = 0; i < lfu.length; i++) {
            System.out.println(lfu[i]);
        }
    }
    public int[] LFU (int[][] operators, int k) {
        // write code here
        LfuCache lfu = new LfuCache(k);
        List<Integer> res=new ArrayList<>();
        for(int i=0;i<operators.length;i++){
            //逐行遍历
            int[] operator=operators[i];
            //put操作
            if(operator[0]==1){
                lfu.put(operator[1],operator[2]);
            }
            //get操作
            else if(operator[0]==2){
                int v=lfu.get(operator[1]);
                res.add(v);
            }
        }
        int[] r=new int[res.size()];
        for(int i=0;i<res.size();i++){
            r[i]=res.get(i);
        }
        return r;
    }

}
class LfuCache {


    int capacity;//容量
    int minFreq=1;//最小的频次
    HashMap<Integer, Node> kvMap = new HashMap<>();
    HashMap<Integer, MyDeList> freqMap = new HashMap<>();

    public LfuCache(int capacity){
        this.capacity=capacity;
    }

    static class Node {
        Node pre;
        Node next;
        int key;
        int value;
        int freq = 1; //频次,节点创建的时候默认为1.
        public Node() {
        }
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    static class MyDeList {
        Node head;
        Node tail;
        int size;

        public MyDeList() {
            head = tail = new Node();
            head.next = tail;
            tail.pre = head;
            size = 0;
        }

        public void addFirst(Node node) {
            Node old = head.next;
            head.next = node;
            node.pre = head;
            node.next = old;
            old.pre = node;
            size++;
        }

        public void remove(Node node) {
            Node p = node.pre;
            Node n = node.next;
            p.next = n;
            n.pre = p;
            size--;
        }

        public Node removeLast() {
            Node last = tail.pre;
            remove(last);
            return last;
        }

        public boolean isEmpty() {
            return size == 0;
        }

    }

    public int get(int key) {
        if (kvMap.containsKey(key)) {
            //如果有
            Node node = kvMap.get(key);
            //从频次map里面移除该节点
            MyDeList list = freqMap.get(node.freq);
            list.remove(node);
            //如果移除了该节点后本频次链表为空，并且该节点是最低频次的节点，那么就需要频次加1
            if (list.isEmpty() && node.freq == minFreq) {
                minFreq++;//更新最小频率值
            }
            node.freq++;
            //有则返回原来的，没有则创建并添加
            freqMap.computeIfAbsent(node.freq, k->new MyDeList())
                    .addFirst(node);
            return node.value;
        } else {
            //没有
            return -1;
        }
    }
    public void put(int key, int value) {
        //如果 原来的链表里面存在该节点
        if (kvMap.containsKey(key)) {
            //如果有
            Node node = kvMap.get(key);
            //从频次map里面移除该节点
            MyDeList list = freqMap.get(node.freq);
            list.remove(node);
            //如果移除了该节点后本频次链表为空，并且该节点是最低频次的节点，那么就需要频次加1
            if (list.isEmpty() && node.freq == minFreq) {
                minFreq++;//更新最小频率值
            }
            node.freq++;
            //有则返回原来的，没有则创建并添加
            freqMap.computeIfAbsent(node.freq, k->new MyDeList())
                    .addFirst(node);
            //更新一下值
            node.value = value;
        } else {
            //如果不存在
            Node node = new Node(key, value);
            if (kvMap.size() >= capacity) {
                //需要删除最小频次下，最早使用的节点
                Node last = freqMap.get(minFreq).removeLast();
                kvMap.remove(last.key);

            }
            kvMap.put(key, node);
            freqMap.computeIfAbsent(node.freq, k->new MyDeList())
                    .addFirst(node);
            //新创建的节点，minFreq肯定是1
            minFreq = 1;
        }

    }
}
