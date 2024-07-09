package com.zzm.algorithm.cache;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

/**
 * @BelongsProject: leet
 * @BelongsPackage: com.zzm.algorithm.cache
 * @Author: zzm
 * @CreateTime: 2024-02-25  21:52
 * @Description: TODO
 * @Version: 1.0
 */
//实现缓存LRU算法+惰性删除
public class MyCache {

    static class Node {
        int key;
        int value;
        Node pre;
        Node next;

        long timeout;

        public Node() {

        }

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public Node(int key, int value, long timeout) {
            this.key = key;
            this.value = value;
            this.timeout = timeout;
        }
    }

    static class DeMyList {
        Node head;
        Node tail;

        public DeMyList() {
            head = tail = new Node();
            head.next = tail;
            tail.pre = head;
        }

        public void addFirst(Node newNode) {
            Node old = head.next;
            head.next = newNode;
            newNode.pre = head;
            newNode.next = old;
            old.pre = newNode;
        }

        public void remove(Node node) {
            Node pre = node.pre;
            Node next = node.next;
            pre.next = next;
            next.pre = pre;
        }

        public Node removeLast() {
            Node last = tail.pre;
            remove(last);
            return last;
        }
    }

    private int capacity;
    private HashMap<Integer, Node> map = new HashMap<>();
    private DeMyList list = new DeMyList();

    public MyCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        } else {
            Node node = map.get(key);
            list.remove(node);
            list.addFirst(node);
            return node.value;
        }
    }


    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            list.remove(node);
            node.value = value;
            list.addFirst(node);
            map.put(key, node);
        } else {
            Node node = new Node(key, value);
            if (map.size() >= capacity) {
                Node last = list.removeLast();
                map.remove(last.key);
                map.put(key, node);
                list.addFirst(node);
            } else {
                map.put(key, node);
                list.addFirst(node);
            }
        }
    }

    //带超时时间的添加节点
    public void offer(int key, int value, long timeout, TimeUnit unit) {
        //将timout转换成毫秒
        //currentTimeMillis是秒还是毫秒？ 毫秒
        long nanos = unit.toMillis(timeout);
        long currentTimeMillis = System.currentTimeMillis();
        long timeoutTime = currentTimeMillis + nanos;
        if (map.containsKey(key)) {
            Node node = map.get(key);
            map.remove(key);
            list.remove(node);
            node.value = value;
            node.timeout = timeoutTime;
            list.addFirst(node);
            map.put(key, node);
        } else {
            Node node = new Node(key, value, timeoutTime);
            if (map.size() >= capacity) {
                Node last = list.removeLast();
                map.remove(last.key);
                map.put(key, node);
                list.addFirst(node);
            } else {
                map.put(key, node);
                list.addFirst(node);
            }
        }
    }

    //惰性删除
    public int poll(int key) {
        if (!map.containsKey(key)) {
            return -1;
        } else {
            Node node = map.get(key);
            long currentTimeMillis = System.currentTimeMillis();
            //判断时间是否超时
            if (node.timeout > currentTimeMillis) {
                list.remove(node);
                list.addFirst(node);
                return node.value;
            } else {
                //超时了
                list.remove(node);
                map.remove(key);
                return -1;
            }
        }

    }

    public static void main(String[] args) {
        System.out.println(System.currentTimeMillis());
        long timeMillis = System.currentTimeMillis();
        //将纳秒转为时间戳

        System.out.println();

    }
}
