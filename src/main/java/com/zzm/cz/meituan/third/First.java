package com.zzm.cz.meituan.third;

import java.util.HashSet;
import java.util.Scanner;

/**
 * @BelongsProject: happystudy
 * @BelongsPackage: com.zzm.meituan.third
 * @Author: zzm
 * @CreateTime: 2024-03-23  09:45
 * @Description: TODO
 * @Version: 1.0
 */
public class First {

    // 计算最多可以切割出的满足条件的子串数量
    public static int maxSubstrings(String s, int k) {
        int count = 0; // 用于计数满足条件的子串数量
        int left = 0;  // 当前考察的子串的起始位置

        while (left < s.length()) {
            HashSet<Character> uniqueChars = new HashSet<>();
            int right = left;
            // 扩展当前子串直到其权值不小于k
            while (right < s.length() && uniqueChars.size() * (right - left + 1) < k) {
                uniqueChars.add(s.charAt(right));
                right++;
            }
            // 如果在字符串结束前找到了满足条件的子串，增加计数
            if (uniqueChars.size() * (right - left) >= k) {
                count++;
                left = right; // 从找到的子串之后继续寻找下一个子串
            } else {
                // 如果没有找到满足条件的子串，则结束循环
                break;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        String s = "aabbaaa"; // 示例字符串
        String s1=s.substring(2);
        System.out.println(s1);
    }



}
