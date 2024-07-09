package com.zzm.structure.hash;

/**
 * @BelongsProject: leet
 * @BelongsPackage: com.zzm.structure.hash
 * @Author: zzm
 * @CreateTime: 2024-01-29  15:49
 * @Description: TODO
 * @Version: 1.0
 */
public class HashTable {
    // 节点类
    static class Entry {
        int hash; // 哈希码
        Object key; // 键
        Object value; // 值
        Entry next;

        public Entry(int hash, Object key, Object value) {
            this.hash = hash;
            this.key = key;
            this.value = value;
        }
    }
    Entry[] table = new Entry[16];
    int size = 0; // 元素个数
    float loadFactor = 0.75f; // 12 阈值
    int threshold = (int) (loadFactor * table.length);//阈值

    // 根据 hash 码获取 value
    Object get(int hash, Object key) {
        //求模运算效率比较低，可以用位运算代替，性能更高，前提是数组的长度必须是2的整数次方
        int idx = hash & (table.length - 1);
        if (table[idx] == null) {
            return null;
        }
        Entry p = table[idx];
        while (p != null) {
            if (p.key.equals(key)) {
                return p.value;
            }
            p = p.next;
        }
        return null;
    }

    // 向 hash 表存入新 key value，如果 key 重复，则更新 value
    void put(int hash, Object key, Object value) {
        int idx = hash & (table.length - 1);
        if (table[idx] == null) {
            // 1. idx 处有空位, 直接新增
            table[idx] = new Entry(hash, key, value);
        } else {
            // 2. idx 处无空位, 沿链表查找 有重复key更新，否则新增
            Entry p = table[idx];
            while (true) {
                if (p.key.equals(key)) {
                    p.value = value; // 更新
                    return;
                }
                if (p.next == null) {
                    break;
                }
                p = p.next;
            }
            p.next = new Entry(hash, key, value); // 新增
        }
        size++;
        if (size > threshold) {
            resize();
        }
    }

    private void resize() {
        //创建一个新的数组，长度是原数组的2倍
        Entry[] newTable = new Entry[table.length << 1];
        for (int i = 0; i < table.length; i++) {
            Entry p = table[i]; // 拿到每个链表头
            //只有链表头不为空才需要去拆分
            if (p != null) {
            /*
                拆分链表，移动到新数组，拆分规律
                * 一个链表最多拆成两个
                * hash & table.length == 0 的一组
                * hash & table.length != 0 的一组
                                          p
                0->8->16->24->32->40->48->null     00001000   8
                            a                      00010000   16
                0->16->32->48->null
                        b
                8->24->40->null
             */
                //尾指针
                Entry a = null;
                Entry b = null;
                //头指针，用来返回结果
                Entry aHead = null;
                Entry bHead = null;
                while (p != null) {
                    if ((p.hash & table.length) == 0) {//分配到链表A
                        if (a != null) {
                            a.next = p;
                        } else {
                            aHead = p;//记录一下头部
                        }
                        a = p; // 分配到a,之后每次相当于移动尾指针a 效果等同于 a=a.next
                    } else {//分配到链表B
                        if (b != null) {
                            b.next = p;
                        } else {
                            bHead = p;//记录一下头部
                        }
                        b = p; // 分配到b，之后每次相当于移动尾指针b 效果等同于 b=b.next
                    }
                    p = p.next;
                }
                // 规律： a 链表保持索引位置不变，b 链表 原索引位置+table.length
                if (a != null) {
                    a.next = null;
                    newTable[i] = aHead;
                }
                if (b != null) {
                    b.next = null;
                    newTable[i + table.length] = bHead;
                }
            }
        }
        //扩容之后，新数组代替旧数组
        table = newTable;
        //更新阈值
        threshold = (int) (loadFactor * table.length);
    }

    // 根据 hash 码删除，返回删除的 value
    Object remove(int hash, Object key) {
        int idx = hash & (table.length - 1);
        if (table[idx] == null) {
            return null;
        }
        Entry p = table[idx];
        Entry prev = null;
        while (p != null) {
            if (p.key.equals(key)) {
                // 找到了, 删除
                if (prev == null) { // 链表头
                    table[idx] = p.next;
                } else { // 非链表头
                    prev.next = p.next;
                }
                size--;
                return p.value;
            }
            prev = p;//保存p的前继节点
            p = p.next;
        }
        return null;
    }
    Object get( Object key){
        int hash = hash(key);
        return get(hash,key);
    }

    private static int hash(Object key) {
        int hash= key.hashCode();
        //高位参与运算，增加hash的随机性
        return hash^(hash>>>16);
    }

    void put( Object key, Object value){
        int hash = hash(key);
        put(hash,key,value);

    }
    Object remove( Object key){
        int hash = hash(key);
        return remove(hash,key);
    }
}
