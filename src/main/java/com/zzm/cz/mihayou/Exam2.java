package com.zzm.cz.mihayou;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

/**
 * @BelongsProject: leet
 * @BelongsPackage: com.zzm.mihayou
 * @Author: zzm
 * @CreateTime: 2024-03-17  11:41
 * @Description: TODO
 * @Version: 1.0
 */
public class Exam2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int[] a=new int[n];
        int[] b=new int[m];
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
        }
        for (int i = 0; i < m; i++) {
            b[i]=sc.nextInt();
        }
        long count=0;
        int sumA=calSum(a);
        int sumB=calSum(b);
        int tempA=0;
        int tempB=0;
        int [] tempAArr=calRepeat(a);
        int [] tempBBrr=calRepeat(b);
        for (int i = 0; i < tempAArr.length; i++) {
            tempA+=(tempAArr[i]-1)*sumB;
        }
        for (int i = 0; i < tempBBrr.length; i++) {
            tempB+=(tempBBrr[i]-1)*sumA;
        }
        count=sumB*sumA+tempA+tempB;
        System.out.println(count);
    }

    public static int calSum(int[] arr){
        int sum=0;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
        }
        return  sum;
    }

    public static int[] calRepeat(int[] arr){
        HashMap<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if(map.containsKey(arr[i])){
                map.put(arr[i],map.get(arr[i])+1);
            }else{
                map.put(arr[i],1);
            }

        }
        int count=0;
        for(int key:map.keySet()){
            if(map.get(key)>1){
                count++;
            }
        }
        int [] repeatedE=new int[count];
        int[] repeatedC=new int[count];
        int index=0;
        for(int key:map.keySet()){
            if(map.get(key)>1){
                repeatedE[index]=key;
                repeatedC[index]=map.get(key);
                index++;
            }
        }
        return  repeatedC;
    }

}
