package com.zzm.cz.meituan.third;

import java.util.Scanner;

/**
 * @BelongsProject: happystudy
 * @BelongsPackage: com.zzm.meituan.third
 * @Author: zzm
 * @CreateTime: 2024-03-23  11:06
 * @Description: TODO
 * @Version: 1.0
 */
public class Second {
    public static int minDeletionsToAvoidEvenLengthPalindromes(String s) {
        int deletions = 0; // 记录需要删除的字符数量
        int count = 1; // 连续字符的计数器，初始为1表示至少有一个字符

        // 遍历字符串
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                // 如果当前字符与前一个字符相同，则增加计数
                count++;
            } else {
                // 如果当前字符与前一个字符不同，则计算之前连续相同字符的删除数量
                // 每个段落至少需要删除一个字符来避免偶数长度的回文子串
                // 除非该段落只有一个字符
                if (count > 1) {
                    deletions += (count - 1);
                }
                count = 1; // 重置计数器
            }
        }

        // 处理字符串末尾的连续字符
        if (count > 1) {
            deletions += (count - 1);
        }

        return deletions;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n = sc.nextInt(); // 输入整数n
        String s = sc.next(); // 输入字符串s
        System.out.println(minDeletionsToAvoidEvenLengthPalindromes(s)); // 输出结果
    }
}
