package com.zzm.scenario;

import java.util.concurrent.CompletableFuture;

/**
 * @Author:zzm
 * @Date:2024/8/29 19:21
 */
public class PaymentDesign {


    public static void main(String[] args) {
        CompletableFuture<Object> pay = CompletableFuture.supplyAsync(() -> bankCardPay());
        CompletableFuture<Object> stock = CompletableFuture.supplyAsync(() -> orderStockUpdate());
        CompletableFuture opt = pay.thenCombine(stock, (resPay, resStock) -> {
            return null;
        });
        System.out.println("支付成功");
    }


    /**
     * 银行卡支付
     * @return
     */
    private static Object bankCardPay() {
        return true;
    }


    /**
     * 订单库存
     */
    private static Object orderStockUpdate() {
        return true;
    }
}
