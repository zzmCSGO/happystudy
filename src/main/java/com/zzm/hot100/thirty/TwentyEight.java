package com.zzm.hot100.thirty;

/**
 * @BelongsProject: leet
 * @BelongsPackage: com.zzm.hot100
 * @Author: zzm
 * @CreateTime: 2024-01-17  13:29
 * @Description: TODO
 * @Version: 1.0
 */
//28找出字符串中第一个匹配项的下标
public class TwentyEight {
    public static void main(String[] args) {
        String haystack = "mississippi";
        String needle = "issip";
        System.out.println(new TwentyEight().strStrSecond(haystack, needle));
    }

    public int strStr(String haystack, String needle) {
        //字符串needle长度
        int len = haystack.length();
        int count = 0;
        int res = -1;
        for (int i = 0; i < len; i++) {
            if (haystack.charAt(i) == needle.charAt(count)) {
                count++;
            } else if (haystack.charAt(i) != needle.charAt(count)) {
                count = 0;
            }
            if (count == needle.length()) {
                res = i - count + 1;
                break;
            }
        }
        return res;
    }

    public int strStrSecond(String haystack, String needle) {
        //逐个遍历字符串haystack
        //每次遍历needle的长度，如果有一个字符串不匹配，或者haystack剩余的长度小于needle的长度，就跳出循环
        int needLen = needle.length();
        int hayLen = haystack.length();
        int res = -1;
        for (int i = 0; i < hayLen; i++) {
            StringBuilder sb = new StringBuilder();
            if (hayLen - i < needLen) {
                break;
            }
            for (int j = i; j < needLen+i; j++) {
                sb.append(haystack.charAt(j));
            }
            if (sb.toString().equals(needle)) {
                res = i;
                break;
            }
        }
        return res;
    }
}
