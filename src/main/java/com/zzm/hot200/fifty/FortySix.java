package com.zzm.hot200.fifty;

import java.util.HashMap;

/**
 * @BelongsProject: leet
 * @BelongsPackage: com.zzm.hot200.fifty
 * @Author: zzm
 * @CreateTime: 2024-02-12  18:56
 * @Description: TODO
 * @Version: 1.0
 */
//146. LRU缓存机制
public class FortySix {

    //首先构建存放的节点
    //再次构建以该节点构成的链表
    //用hashmap和双向链表来构建缓存
    static class LRUCache {
        static class Node {
            int key;
            int value;
            Node pre;
            Node next;

            public Node(int key, int value) {
                this.key = key;
                this.value = value;
                Node head;
                Node tail;
            }

            //无参构造
            public Node() {
            }
        }


        static class DoublyLinkedList {

            private Node head;
            private Node tail;


            public DoublyLinkedList() {
                head = tail = new Node();
                head.next = tail;
                tail.pre = head;
            }

            //头部添加 head<->1<->2<->tail
            public void addFirst(Node newFirst) { //o(1)
                Node oldFirst = head.next;
                newFirst.pre = head;
                newFirst.next = oldFirst;
                head.next = newFirst;
                oldFirst.pre = newFirst;
            }
            //已知节点删除

            public void remove(Node node) { //o(1)
                Node pre = node.pre;
                Node next = node.next;
                pre.next = next;
                next.pre = pre;
            }

            //尾部删除
            public Node removeLast() {
                Node last = tail.pre;
                remove(last);
                return last;
            }

        }

        private HashMap<Integer, Node> map = new HashMap<>();

        private DoublyLinkedList list = new DoublyLinkedList();

        private int capacity;


        public LRUCache(int capacity) {
            this.capacity = capacity;
        }

        public int get(int key) {
            if (!map.containsKey(key)) {
                return -1;
            }
            Node node = map.get(key);
            //调整get节点在双向链表中的位置->删掉已知节点，再放入头部就可以
            list.remove(node);
            list.addFirst(node);
            return node.value;


        }


        public void put(int key, int value) {
            //如果map中存在该节点，一旦被使用，更新值，再将其移动到头位置
            if (map.containsKey(key)) {
                Node node = map.get(key);
                node.value = value;
                list.remove(node);
                list.addFirst(node);
            } else {
                //如果map中不存在该节点，则构造节点，存入map，将其放在双向链表的表头
                Node node = new Node(key, value);
                map.put(key, node);
                list.addFirst(node);
                //如果链表数量超出，则移除末尾元素。map和list都要移除
                if (map.size() > capacity) {
                    Node last = list.removeLast();
                    map.remove(last.key);
                }
            }
        }
    }
}
