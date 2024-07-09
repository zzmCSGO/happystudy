package com.zzm.hot200.hundred;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @BelongsProject: leet
 * @BelongsPackage: com.zzm.hot200.hundred
 * @Author: zzm
 * @CreateTime: 2024-02-27  17:50
 * @Description: TODO
 * @Version: 1.0
 */
//198.打家劫舍
public class NinetyEight {

    public int rob(int [] houses){
        int len=houses.length;
        if(len==1){
            return houses[0];
        }
        int[]dp=new int[len];
        dp[0]=houses[0];
        dp[1]=Math.max(houses[0],houses[1]);
        for(int i=2;i<houses.length;i++){
            dp[i]=Math.max(dp[i-1],dp[i-2]+houses[i]);
        }
        return dp[len-1];
    }
//    HashMap<String,Integer> map=new HashMap<>();
//        map.put("money",100);
//    Thread t1=new Thread(()->{
//        for (int i = 0; i < 100; i++) {
//            map.put("money",map.get("money")+1);
//        }
//    });
//    Thread t2=new Thread(()->{
//        for (int i = 0; i < 100; i++) {
//            map.put("money",map.get("money")-1);
//        }
//    });
//        t1.start();
//        t2.start();
//        t1.join();
//        t2.join();
//        System.out.println(map.get("money"));

    public boolean judge (String str) {

        // write code here
        int len=str.length();
        if(len==1){
            return true;
        }
        int mid=len/2;
        StringBuilder sb=new StringBuilder();
        for(int i=str.length()-1;i>=mid;i--){
            sb.append(str.charAt(i));
        }
        String s=sb.toString();
        for(int i=0;i>s.length();i++){
            if(str.charAt(i)!=s.charAt(i)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws InterruptedException {
//        NinetyEight ninetyEight = new NinetyEight();
//        int rob = ninetyEight.rob(new int[]{85,17,19,10,6,3,32,93,64});
//        System.out.println(rob);
//        int[] ints =new int[]{1,2,3,4,5,6,7,8,9,10};
//        int[] copy = Arrays.copyOfRange(ints, 0, 5);
//        System.out.println(Arrays.toString(copy));
        String test="abaa";
        NinetyEight ninetyEight = new NinetyEight();
        boolean judge = ninetyEight.judge(test);


    }

}
