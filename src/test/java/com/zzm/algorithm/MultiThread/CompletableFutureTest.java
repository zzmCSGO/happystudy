package com.zzm.algorithm.MultiThread;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Author:zzm
 * @Date:2024/8/31 22:00
 */
public class CompletableFutureTest {
    public static void main(String[] args) {
        CompletableFuture cf1 = CompletableFuture.runAsync(() -> {
            for (int i = 0; i < 1000; i++) {
                System.out.println("1");
            }
        });
        CompletableFuture cf2 = CompletableFuture.runAsync(() -> {
            for (int i = 0; i < 1000; i++) {
                System.out.println("2");
            }
        });
        CompletableFuture cf3 = CompletableFuture.runAsync(() -> {
            for (int i = 0; i < 1000; i++) {
                System.out.println("3");
            }
        });
        cf3.join();
        cf1.join();
        cf2.join();
        ThreadPoolExecutor
//        CompletableFuture cf2 = cf1.thenRun(() -> {
//            System.out.println("2");
//        });
//        CompletableFuture cf3 = cf2.thenRun(() -> {
//            System.out.println("3");
//        });
    }
}
