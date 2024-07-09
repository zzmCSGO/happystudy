package com.zzm.hot100.twenty;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @BelongsProject: leet
 * @BelongsPackage: com.zzm.hot100
 * @Author: zzm
 * @CreateTime: 2024-01-13  13:56
 * @Description: TODO
 * @Version: 1.0
 */
//罗马数字转整数
public class Thirteen {


    public static void main(String[] args) {
        String s = "III";
//        System.out.println(s.substring(0,1));
        System.out.println(romanToInt(s));
    }

    public static int romanToInt(String s) {

        HashMap<String, Integer> map = new HashMap();
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);
        int res = 0;
        int length = s.length();
        for (int i = 0; i < length; i++) {
            //判断一下是否越界
            if (i + 2 <= length) {
                String temp = s.substring(i, i + 2);
                if (map.containsKey(temp)) {
                    res += map.get(temp);
                    i = i + 1;
                }
                System.out.println(i);
            } else if (map.containsKey(String.valueOf(s.charAt(i)))) {

                res += map.get(String.valueOf(s.charAt(i)));
            }
            System.out.println("代码块内" + map.containsKey(String.valueOf(s.charAt(i))));
        }
        return res;
    }

    public static int plus(String s) {

        HashMap<String, Integer> map = new HashMap();
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);
        int res = 0;
        int length = s.length();
        for (int i = 0; i < length; i++) {

            if (i < length - 1 && s.charAt(i + 1) > s.charAt(i)) {
                res -= map.get(String.valueOf(s.charAt(i)));
            } else {
                res += map.get(String.valueOf(s.charAt(i)));
            }
        }
        return res;
    }
}
