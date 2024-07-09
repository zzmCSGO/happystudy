package com.zzm.hot100.twenty;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @BelongsProject: leet
 * @BelongsPackage: com.zzm.hot100
 * @Author: zzm
 * @CreateTime: 2024-01-13  13:16
 * @Description: TODO
 * @Version: 1.0
 */

//整数转罗马数字
public class Twelve {
    public static void main(String[] args) {
        System.out.println(intToRoman(12));
//        System.out.println((int)Math.pow(10,0));
    }

    public static String intToRoman(int num) {
        HashMap<Integer,String> map=new HashMap();
        List<String> list=new ArrayList<>();
        map.put(1,"I");
        map.put(5,"V");
        map.put(10,"X");
        map.put(50,"L");
        map.put(100,"C");
        map.put(500,"D");
        map.put(1000,"M");
        map.put(4,"IV");
        map.put(9,"IX");
        map.put(40,"XL");
        map.put(90,"XC");
        map.put(400,"CD");
        map.put(900,"CM");
        int count=0;
        int temp=0;
        while(num!=0){
            int last=num%10;
            num=num/10;
            temp=last*(int)Math.pow(10,count);
            if(map.containsKey(temp)){
                list.add(map.get(temp));
            }else{
                if(temp>5*(int)Math.pow(10,count)){
                    StringBuilder sb=new StringBuilder();
                    sb.append(map.get(5*(int)Math.pow(10,count)));
                    int now=temp-5*(int)Math.pow(10,count);
                    int k=now/(int)Math.pow(10,count);
                    for(int i=0;i<k;i++){
                        sb.append(map.get((int)Math.pow(10,count)));
                    }
                    list.add(sb.toString());
                }else{
                    StringBuilder sb=new StringBuilder();
                    int k=temp/(int)Math.pow(10,count);
                    for(int i=0;i<k;i++){
                        sb.append(map.get((int)Math.pow(10,count)));
                    }
                    list.add(sb.toString());
                }
            }
            count++;
        }
        StringBuilder sb=new StringBuilder();
        for(int i=list.size()-1;i>=0;i--){
            sb.append(list.get(i));
        }
        return sb.toString();
    }
}
