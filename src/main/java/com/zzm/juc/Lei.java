package com.zzm.juc;

import java.util.HashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @BelongsProject: leet
 * @BelongsPackage: com.zzm.juc
 * @Author: zzm
 * @CreateTime: 2024-02-25  13:28
 * @Description: TODO
 * @Version: 1.0
 */
public class Lei {
    static HashMap<Integer,Integer> map=new HashMap<>();
    public static void main(String[] args) {
        map.put(1,2);
        map.put(1,3);
        map.merge(1,1,Integer::sum);
        System.out.println(map.get(1));
    }
}
