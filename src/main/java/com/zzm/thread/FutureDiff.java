package com.zzm.thread;

import org.apache.http.concurrent.FutureCallback;
import org.springframework.util.concurrent.ListenableFuture;

import java.util.List;
import java.util.concurrent.CompletableFuture;
/**
 * @Author:zzm
 * @Date:2024/8/28 20:54
 */
public class FutureDiff {
    public static void main(String[] args) {

    }
//    public void future() {
//        ExecutorService executor = Executors.newFixedThreadPool(5);
//        ListeningExecutorService guavaExecutor = MoreExecutors.listeningDecorator(executor);
//        ListenableFuture<String> future1 = guavaExecutor.submit(() -> {
//            //step 1
//            System.out.println("执行step 1");
//            return "step1 result";
//        });
//        ListenableFuture<String> future2 = guavaExecutor.submit(() -> {
//            //step 2
//            System.out.println("执行step 2");
//            return "step2 result";
//        });
//        ListenableFuture<List<String>> future1And2 = Futures.allAsList(future1, future2);
//        Futures.addCallback(future1And2, new FutureCallback<List<String>>() {
//            @Override
//            public void onSuccess(List<String> result) {
//                System.out.println(result);
//                ListenableFuture<String> future3 = guavaExecutor.submit(() -> {
//                    System.out.println("执行step 3");
//                    return "step3 result";
//                });
//                Futures.addCallback(future3, new FutureCallback<String>() {
//                    @Override
//                    public void onSuccess(String result) {
//                        System.out.println(result);
//                    }
//                    @Override
//                    public void onFailure(Throwable t) {
//                    }
//                }, guavaExecutor);
//            }
//
//            @Override
//            public void onFailure(Throwable t) {
//            }}, guavaExecutor);
//    }
}
